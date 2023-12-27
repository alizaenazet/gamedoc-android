package com.example.gamedoc.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.LibraryAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
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

                Spacer(modifier = Modifier.width(9.dp))

                Row(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Purple40,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                        },
                        colors = SearchBarDefaults.colors(containerColor = Primary),
                        modifier = Modifier
                            .width(200.dp)
                            .height(60.dp)
                            .padding(bottom = 6.dp)
                    ) {}
                }

                Spacer(modifier = Modifier.width(5.dp))

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
        ) {
            var searchInput by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
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

                Spacer(modifier = Modifier.width(15.dp))

                Row(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Purple40,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                        },
                        colors = SearchBarDefaults.colors(containerColor = Primary),
                        modifier = Modifier
                            .width(200.dp)
                            .height(60.dp)
                            .padding(bottom = 6.dp)
                    ) {}
                }
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

                Spacer(modifier = Modifier.width(9.dp))

                Row(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Purple40,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                        },
                        colors = SearchBarDefaults.colors(containerColor = Primary),
                        modifier = Modifier
                            .width(200.dp)
                            .height(60.dp)
                            .padding(bottom = 6.dp)
                    ) {}
                }

                Spacer(modifier = Modifier.width(5.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickPost
                ) {
                    Icon(
                        imageVector = Icons.Default.LibraryAdd,
                        contentDescription = "Add Post Button", tint = Purple40
                    )
                }
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant4(
            onClickBackButton: () -> Unit,
            onSearch: (String) -> Unit,
            onClickTrolli: () -> Unit
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

                Spacer(modifier = Modifier.width(9.dp))

                Row(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Purple40,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                        },
                        colors = SearchBarDefaults.colors(containerColor = Primary),
                        modifier = Modifier
                            .width(200.dp)
                            .height(60.dp)
                            .padding(bottom = 6.dp)
                    ) {}
                }

                Spacer(modifier = Modifier.width(5.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickTrolli
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Shoping Cart Button", tint = Purple40
                    )
                }
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant5(
            onClickBackButton: () -> Unit,
            onSearch: (String) -> Unit,
            onClickFavorite: () -> Unit
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

                Spacer(modifier = Modifier.width(9.dp))

                Row(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Purple40,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                        },
                        colors = SearchBarDefaults.colors(containerColor = Primary),
                        modifier = Modifier
                            .width(200.dp)
                            .height(60.dp)
                            .padding(bottom = 6.dp)
                    ) {}
                }

                Spacer(modifier = Modifier.width(5.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickFavorite
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite Icon", tint = Purple40
                    )
                }
            }
        }

        @Composable
        public fun Variant6(
            onClickBackButton: () -> Unit,
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

                Spacer(modifier = Modifier.width(220.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickPost
                ) {
                    Icon(
                        imageVector = Icons.Default.LibraryAdd,
                        contentDescription = "Add Post Button", tint = Purple40
                    )
                }
            }
        }

        @Composable
        public fun Variant7(
            onClickBackButton: () -> Unit,
        ) {
            var searchInput by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
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

            Variant2(
                onClickBackButton = {},
                onSearch = {},
            )

            Variant3(
                onClickBackButton = {},
                onSearch = {},
                onClickPost = {}
            )

            Variant4(
                onClickBackButton = {},
                onSearch = {},
                onClickTrolli = {}
            )

            Variant5(
                onClickBackButton = {},
                onSearch = {},
                onClickFavorite = {}
            )

            Variant6(
                onClickBackButton = {},
                onClickPost = {}
            )

            Variant7(
                onClickBackButton = {},
            )
        }
    }
}