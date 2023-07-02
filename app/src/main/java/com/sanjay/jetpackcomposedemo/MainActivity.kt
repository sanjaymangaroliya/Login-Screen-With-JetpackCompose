package com.sanjay.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.background)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(100.dp))

                var emailLength by remember { mutableStateOf(0) }

                //MARK: Image
                Image(
                    painter = painterResource(
                        id = if (emailLength == 200) {
                            R.drawable.shy
                        } else if (emailLength <= 0) {
                            R.drawable.neutral
                        } else if (emailLength == 1) {
                            R.drawable.frame_1
                        } else if (emailLength == 2) {
                            R.drawable.frame_2
                        } else if (emailLength == 3) {
                            R.drawable.frame_3
                        } else if (emailLength == 4) {
                            R.drawable.frame_4
                        } else if (emailLength == 5) {
                            R.drawable.frame_5
                        } else if (emailLength == 6) {
                            R.drawable.frame_6
                        } else if (emailLength == 7) {
                            R.drawable.frame_7
                        } else if (emailLength == 8) {
                            R.drawable.frame_8
                        } else if (emailLength == 9) {
                            R.drawable.frame_9
                        } else if (emailLength == 10) {
                            R.drawable.frame_10
                        } else if (emailLength == 11) {
                            R.drawable.frame_11
                        } else if (emailLength == 12) {
                            R.drawable.frame_12
                        } else if (emailLength == 13) {
                            R.drawable.frame_13
                        } else if (emailLength == 14) {
                            R.drawable.frame_14
                        } else if (emailLength == 15) {
                            R.drawable.frame_15
                        } else if (emailLength == 16) {
                            R.drawable.frame_16
                        } else if (emailLength >= 17) {
                            R.drawable.frame_17
                        } else {
                            R.drawable.neutral
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(140.dp)
                )

                val email = remember { mutableStateOf(TextFieldValue()) }
                val password = remember { mutableStateOf(TextFieldValue()) }
                var passwordVisible by rememberSaveable { mutableStateOf(false) }
                var passwordFocus = false
                
                Spacer(modifier = Modifier.height(20.dp))

                //MARK: Email
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp, vertical = 10.dp)
                        .onFocusChanged {
                            if (it.isFocused) {
                                //passwordFocus = false
                                emailLength = 1
                            }
                        },
                    label = { Text(text = getString(R.string.email), fontSize = 16.sp) },
                    singleLine = true,
                    value = email.value,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.white),
                        unfocusedBorderColor = colorResource(id = R.color.white),
                        cursorColor = colorResource(id = R.color.white),
                        textColor = colorResource(id = R.color.white),
                        placeholderColor = colorResource(id = R.color.white)
                    ),
                    onValueChange = {
                        email.value = it
                        emailLength = it.text.length
                    },
                )

                //MARK: Password
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp, vertical = 10.dp)
                        .onFocusChanged {
                            if (it.isFocused) {
                                passwordFocus = true
                                emailLength = 200
                            }
                        },
                    label = { Text(text = getString(R.string.password)) },
                    placeholder = { Text(getString(R.string.password)) },
                    singleLine = true,
                    value = password.value,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.white),
                        unfocusedBorderColor = colorResource(id = R.color.white),
                        cursorColor = colorResource(id = R.color.white),
                        textColor = colorResource(id = R.color.white),
                        placeholderColor = colorResource(id = R.color.white)
                    ),
                    onValueChange = { password.value = it },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image: ImageVector
                        val description: String
                        if (passwordVisible) {
                            image = Icons.Filled.Visibility
                            description = "Hide password"
                            if (!passwordFocus) {
                                passwordFocus = true
                                emailLength = 0
                            }

                        } else {
                            image = Icons.Filled.VisibilityOff
                            description = "Show password"
                            if (passwordFocus) {
                                passwordFocus = false
                                emailLength = 200
                            }
                        }
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, description)
                        }
                    }
                )

                //MARK: Login button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp, vertical = 20.dp),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
                    shape = RoundedCornerShape(50.dp),
                ) {
                    Text(
                        text = getString(R.string.login),
                        color = colorResource(id = R.color.background),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}