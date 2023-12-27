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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamedoc.ui.theme.Accent
import com.example.gamedoc.ui.theme.Primary
import com.example.gamedoc.ui.theme.Secondary

class InputField {
    companion object {
        @Composable
        public fun Login(
            onInput: () -> Unit
        ) {
            var input by remember { mutableStateOf(TextFieldValue("")) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    label = { Text(text = "User Name") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Person Icon",
                            tint = Secondary
                        )
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
                        .fillMaxWidth()
                )
            }
        }

        @Composable
        public fun Password(
            onInput: () -> Unit
        ) {
            var input by remember { mutableStateOf(TextFieldValue("")) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    label = { Text(text = "Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Lock Icon",
                            tint = Secondary
                        )
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
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
                )
            }
        }

        @Composable
        public fun Variant5(
            onInput: () -> Unit
        ) {
            var input by remember { mutableStateOf(TextFieldValue("")) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    label = { Text(text = "Phone Number") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Phone,
                            contentDescription = "Phone Icon",
                            tint = Secondary
                        )
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
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
                )
            }
        }

        @Composable
        public fun Variant6(
            onInput: () -> Unit
        ) {
            var input by remember { mutableStateOf(TextFieldValue("")) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    label = { Text(text = "Date") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.CalendarMonth,
                            contentDescription = "Calendar Icon",
                            tint = Secondary
                        )
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
                        .fillMaxWidth()
                )
            }
        }

        @Composable
        public fun Variant7(
            onInput: () -> Unit
        ) {
            var input by remember { mutableStateOf(TextFieldValue("")) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    label = { Text(text = "Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.AlternateEmail,
                            contentDescription = "Email Icon",
                            tint = Secondary
                        )
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
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
                )
            }
        }

        @Composable
        public fun Variant8(
            onInput: () -> Unit
        ) {
            var input by remember { mutableStateOf(TextFieldValue("")) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    label = { Text(text = "Input") },
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
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun TextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
) {
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
