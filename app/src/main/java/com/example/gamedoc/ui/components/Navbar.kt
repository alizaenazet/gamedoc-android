package com.example.gamedoc.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.LibraryAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamedoc.ui.theme.Primary
import com.example.gamedoc.ui.theme.Purple40

class Navbar {
    companion object{
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Default(
            onClickBackButton: () -> Unit,
            onSearch: (String) -> Unit,
            onClickPostUser: () -> Unit
        ) {
            var searchInput by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickBackButton
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back Arrow", tint = Purple40
                    )
                }

                SearchBar(
                    query = "Search",
                    onQueryChange = { searchInput = it },
                    onSearch = { onSearch(searchInput) },
                    active = searchInput.isNotEmpty(),
                    onActiveChange = {},
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = Purple40
                        )
                    }
                ) {}

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickPostUser
                ) {
                    Icon(
                        Icons.Default.GridOn,
                        contentDescription = "Post User Icon", tint = Purple40
                    )
                }

            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant2(
            onClickBackButton: () -> Unit,
            onSearch: (String) -> Unit,
            onClickPostUser: () -> Unit
        ) {
            var searchInput by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickBackButton
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back Arrow", tint = Purple40
                    )
                }

//                SearchBar(
//                    query = searchInput,
//                    onQueryChange = { newQuery -> searchInput = newQuery },
//                    onSearch = { onSearch(searchInput) },
//                    active = searchInput.isNotEmpty(),
//                    onActiveChange = {}
//                )

//                Row(
//                    modifier = Modifier
//                        .background(MaterialTheme.colorScheme.background)
//                ) {
//                    TextField(
//                        value = searchInput,
//                        onValueChange = {
//                            searchInput = it
//                        },
//                        placeholder = { Text(text = "Search") },
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            imeAction = ImeAction.Search
//                        ),
//                        keyboardActions = KeyboardActions(
//                            onSearch = {
//                                onSearch(searchInput)
//                            }
//                        ),
//                        colors = TextFieldDefaults.textFieldColors(
//                            cursorColor = MaterialTheme.colorScheme.primary,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(MaterialTheme.colorScheme.surface)
//                    )
//                }
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant3(
            onClickBackButton: () -> Unit,
            onSearch: (String) -> Unit,
            onClickPost: () -> Unit
        ) {
            var searchInput by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickBackButton
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back Arrow", tint = Purple40
                    )
                }

//                SearchBar(
//                    query = searchInput,
//                    onQueryChange = { newQuery -> searchInput = newQuery },
//                    onSearch = { onSearch(searchInput) },
//                    active = searchInput.isNotEmpty(),
//                    onActiveChange = {}
//                )

//                Row(
//                    modifier = Modifier
//                        .background(MaterialTheme.colorScheme.background)
//                ) {
//                    TextField(
//                        value = searchInput,
//                        onValueChange = {
//                            searchInput = it
//                        },
//                        placeholder = { Text(text = "Search") },
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            imeAction = ImeAction.Search
//                        ),
//                        keyboardActions = KeyboardActions(
//                            onSearch = {
//                                onSearch(searchInput)
//                            }
//                        ),
//                        colors = TextFieldDefaults.textFieldColors(
//                            cursorColor = MaterialTheme.colorScheme.primary,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(MaterialTheme.colorScheme.surface)
//                    )
//                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickPost
                ) {
                    Icon(
                        imageVector = Icons.Default.LibraryAdd,
                        contentDescription = "Back Arrow", tint = Purple40
                    )
                }
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant4(
            onClickBackButton: () -> Unit,
            onSearch: (String) -> Unit,
            onClickPost: () -> Unit
        ) {
            var searchInput by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickBackButton
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back Arrow", tint = Purple40
                    )
                }

//                SearchBar(
//                    query = searchInput,
//                    onQueryChange = { newQuery -> searchInput = newQuery },
//                    onSearch = { onSearch(searchInput) },
//                    active = searchInput.isNotEmpty(),
//                    onActiveChange = {}
//                )

//                Row(
//                    modifier = Modifier
//                        .background(MaterialTheme.colorScheme.background)
//                ) {
//                    TextField(
//                        value = searchInput,
//                        onValueChange = {
//                            searchInput = it
//                        },
//                        placeholder = { Text(text = "Search") },
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            imeAction = ImeAction.Search
//                        ),
//                        keyboardActions = KeyboardActions(
//                            onSearch = {
//                                onSearch(searchInput)
//                            }
//                        ),
//                        colors = TextFieldDefaults.textFieldColors(
//                            cursorColor = MaterialTheme.colorScheme.primary,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(MaterialTheme.colorScheme.surface)
//                    )
//                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickPost
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Back Arrow", tint = Purple40
                    )
                }
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    public fun ComponentPreview() {
        Column(
            Modifier.fillMaxHeight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Default(
                onClickBackButton = {},
                onSearch = {},
                onClickPostUser = {}
            )
        }
    }
}