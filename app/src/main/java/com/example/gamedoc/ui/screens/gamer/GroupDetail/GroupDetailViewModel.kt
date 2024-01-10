package com.example.gamedoc.ui.screens.gamer.GroupDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamedoc.model.ViewRouteParams
import com.example.gamedoc.model.group.DetailGroup
import com.example.gamedoc.network.RetrofitInstance
import com.example.gamedoc.network.group.GroupContainer
import com.example.gamedoc.ui.ListScreens
import com.example.gamedoc.ui.screens.register.gamer.RegisterGamerUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface GroupDetaiUiState {
    data class Success(
        val groupDetail: DetailGroup?
    ):GroupDetaiUiState
    data class Error(
        val error: String
    ):GroupDetaiUiState
    object Loading: GroupDetaiUiState
}

class GroupDetailViewModel (
    viewRouteParams: ViewRouteParams,
    groupid: String,
): ViewModel(){
 var _groupDetailUiState: GroupDetaiUiState by mutableStateOf(GroupDetaiUiState.Loading)
     private set

    private lateinit var data: DetailGroup
    init {
        loadData(viewRouteParams,groupid)
    }

    fun loadData(
     viewRouteParams: ViewRouteParams,
     groupId: String
    ) {
        viewModelScope.launch {
            _groupDetailUiState = GroupDetaiUiState.Loading
            try {
                val detailGroupData = GroupContainer().groupRepository.getGroupDetail(groupId)
                when(detailGroupData.statusCode){
                    200 -> {
                        if (detailGroupData.successResponseBody != null){
                            data = detailGroupData.successResponseBody
                            _groupDetailUiState = GroupDetaiUiState.Success(data)
                        }else{
                            _groupDetailUiState = GroupDetaiUiState.Success(null)
                        }
                    }

                    404 -> {

                    }

                    401 -> {
                        RetrofitInstance.setUserToken("")
                        viewRouteParams.dataStore.saveTokenToPreferencesStore("")
                        viewRouteParams.dataStore.saveUserRoleToPreferencesStore("")
                        viewRouteParams.navController.navigate(ListScreens.Login.name)
                    }
                }
            } catch(e: HttpException) {
                _groupDetailUiState =  GroupDetaiUiState.Error(error = e.message())
            }catch (e: Throwable){
                RetrofitInstance.setUserToken("")
                viewRouteParams.dataStore.saveTokenToPreferencesStore("")
                viewRouteParams.dataStore.saveUserRoleToPreferencesStore("")
                viewRouteParams.navController.navigate(ListScreens.Login.name)
            }
        }
    }


}