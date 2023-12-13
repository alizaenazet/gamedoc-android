package com.example.gamedoc.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Navbar {
    companion object{
        @Composable
        public fun  userDefault(){
            Column() {
                Row {

                }
            }
        }

        @Composable
        public fun dokterDefault(){
            Text(text = "")
        }

        @Composable
        public fun userRounded(){
            Text(text = "")
        }

        @Composable
        public fun dokterRounded(){
            Text(text = "")
        }
    }

}