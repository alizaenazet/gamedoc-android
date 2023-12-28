import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AlternateEmail
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamedoc.R
import com.example.gamedoc.ui.theme.Accent
import com.example.gamedoc.ui.theme.Primary
import com.example.gamedoc.ui.theme.Secondary

class InputField {
    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Login(
            onInput: (String) -> Unit
        ) {
            var input by rememberSaveable { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = {
                        input = it
                        onInput(it)
                    },
                    label = { Text(text = "User Name") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Person Icon",
                            tint = Secondary
                        )
                    },
                    supportingText = {
                        if (input.isEmpty()) {
                            Text(
                                text = "Please fill with the right input",
                                color = Color.Red,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
                                    .background(color = Color.White)
                            )
                        }
                    },
                    modifier = Modifier
                        .border(
                            width = 3.dp,
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.3f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
                )
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Password(
            onInput: (String) -> Unit
        ) {
            var input by rememberSaveable { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = {
                        input = it
                        onInput(it)
                    },
                    label = { Text(text = "Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Lock Icon",
                            tint = Secondary
                        )
                    },
                    supportingText = {
                        if (input.isEmpty()) {
                            Text(
                                text = "Please fill with the right input",
                                color = Color.Red,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
                            )
                        }
                    },
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.3f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = input.isNotEmpty(),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
                )
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant5(
            onInput: (String) -> Unit
        ) {
            var input by rememberSaveable { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = {
                        input = it
                        onInput(it)
                    },
                    label = { Text(text = "Phone Number") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Phone,
                            contentDescription = "Phone Icon",
                            tint = Secondary
                        )
                    },
                    supportingText = {
                        if (input.isEmpty()) {
                            Text(
                                text = "Please fill with the right input",
                                color = Color.Red,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
                                    .background(color = Color.White)
                            )
                        }
                    },
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.3f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
                )
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant6(
            onInput: (String) -> Unit
        ) {
            var input by rememberSaveable { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = {
                        input = it
                        onInput(it)
                    },
                    label = { Text(text = "Date") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.CalendarMonth,
                            contentDescription = "Calendar Icon",
                            tint = Secondary
                        )
                    },
                    supportingText = {
                        if (input.isEmpty()) {
                            Text(
                                text = "Please fill with the right input",
                                color = Color.Red,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
                                    .background(color = Color.White)
                            )
                        }
                    },
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.3f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
                )
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant7(
            onInput: (String) -> Unit
        ) {
            var input by rememberSaveable { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = {
                        input = it
                        onInput(it)
                    },
                    label = { Text(text = "Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.AlternateEmail,
                            contentDescription = "Email Icon",
                            tint = Secondary
                        )
                    },
                    supportingText = {
                        if (input.isEmpty()) {
                            Text(
                                text = "Please fill with the right input",
                                color = Color.Red,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
                                    .background(color = Color.White)
                            )
                        }
                    },
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.3f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
                )
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant8(
            onInput: (String) -> Unit
        ) {
            var input by rememberSaveable { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = {
                        input = it
                        onInput(it)
                    },
                    label = { Text(text = "Input") },
                    supportingText = {
                        if (input.isEmpty()) {
                            Text(
                                text = "Please fill with the right input",
                                color = Color.Red,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
                                    .background(color = Color.White)
                            )
                        }
                    },
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.3f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
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
        InputField.Login(
            onInput = {}
        )

        InputField.Password(
            onInput = {}
        )

        InputField.Variant5(
            onInput = {}
        )

        InputField.Variant6(
            onInput = {}
        )

        InputField.Variant7(
            onInput = {}
        )

        InputField.Variant8(
            onInput = {}
        )
    }
}
