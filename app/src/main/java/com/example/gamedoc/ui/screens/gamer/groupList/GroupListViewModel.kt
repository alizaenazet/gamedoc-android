package com.example.gamedoc.ui.screens.gamer.groupList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.gamedoc.data.SettingsDataStore
import com.example.gamedoc.model.ViewRouteParams
import com.example.gamedoc.model.group.GroupList
import com.example.gamedoc.network.RetrofitInstance
import com.example.gamedoc.network.group.GroupContainer
import com.example.gamedoc.ui.ListScreens
import com.example.gamedoc.ui.screens.register.gamer.RegisterGamerUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface GamerGroupListUiState{
    data class Success(
        val groupList: GroupList?
    ): GamerGroupListUiState
    data class Error(
        val error: String
    ): GamerGroupListUiState
    object Loading: GamerGroupListUiState
}

class GamerGroupListViewModel(
    viewRouteParams: ViewRouteParams,
    ): ViewModel(){
    var _gamerGroupListUiState : GamerGroupListUiState by mutableStateOf(GamerGroupListUiState.Success(null))
        private set



    private lateinit var data: GroupList

    init {
        loadData(viewRouteParams.dataStore,viewRouteParams.navController)
    }

    fun loadData(dataStore: SettingsDataStore, navController: NavController){
        _gamerGroupListUiState = GamerGroupListUiState.Loading
        viewModelScope.launch {
            try {
                // TODO(Test: Request again with validation token)
                // TODO(EXPECT: Can validate correctly and get the data)
                val groupListData = GroupContainer().groupRepository.getGroupList()
                when(groupListData.statusCode){
                    200 -> {
                        if (groupListData.successResponseBody != null) {
                            data = groupListData.successResponseBody
                            _gamerGroupListUiState = GamerGroupListUiState.Success(data)
                        }else{
                            _gamerGroupListUiState = GamerGroupListUiState.Success(null)
                        }
                    }
                    401 -> {
                        RetrofitInstance.setUserToken("")
                        dataStore.saveTokenToPreferencesStore("")
                        dataStore.saveUserRoleToPreferencesStore("")
                        navController.navigate(ListScreens.Login.name)
                    }

                }

            }catch(e: HttpException) {
                RegisterGamerUiState.Error(error = e.message())
            }catch (e: Throwable){
                RetrofitInstance.setUserToken("")
                dataStore.saveTokenToPreferencesStore("")
                dataStore.saveUserRoleToPreferencesStore("")
                navController.navigate(ListScreens.Login.name)
            }
        }
    }

    fun serachGroup(searchKey: String){

    }
// ehintz@example.com




}
