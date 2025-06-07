package com.example.litthu_eyelash_app.presentation.login.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.litthu_eyelash_app.presentation.login.viewmodel.LoginViewModel
import com.example.litthu_eyelash_app.presentation.widget.CommonOutlinedTextFieldWithLabel
import com.example.litthu_eyelash_app.presentation.widget.rememberInject
import com.example.litthu_eyelash_app.utils.getLanguageCode


object LoginScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberInject<LoginViewModel>()
        val navigator = LocalNavigator.currentOrThrow

        var phoneNumber by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Logo
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.6f))
                        )
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.6f))
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Title
                Text(
                    text = "Constants.UIText.APP_NAME",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(48.dp))

                // Phone Number Field
                CommonOutlinedTextFieldWithLabel(
                    label = "Constants.UIText.PHONE_NUMBER",
                    value = phoneNumber,
                    hint = "Constants.UIText.PHONE_NUMBER_HINT",
                    onValueChange = { value ->
                        phoneNumber = value
                    },
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Phone,
//                            contentDescription = "Phone",
//                            tint = Color(0xFF6B7280)
//                        )
//                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Password Field
                CommonOutlinedTextFieldWithLabel(
                    label = "Constants.UIText.PASSWORD",
                    value = password,
                    hint = "Constants.UIText.PASSWORD_HINT",
                    onValueChange = { value ->
                        password = value
                    },
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Phone,
//                            contentDescription = "Phone",
//                            tint = Color(0xFF6B7280)
//                        )
//                    },
//                    trailingIcon = {
//                        IconButton(
//                            onClick = { passwordVisible = !passwordVisible }
//                        ) {
//                            Icon(
//                                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
//                                contentDescription = if (passwordVisible) "Hide password" else "Show password",
//                                tint = Color(0xFF6B7280)
//                            )
//                        }
//                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Login Button
                Button(
                    onClick = {
                        viewModel.login()
                        println("Login clicked - Phone: $phoneNumber, Password: $password")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = "Constants.UIText.LOGIN",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Links
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextButton(
                        onClick = {
                            // Handle forgot password
                            println("Forgot password clicked")
                        }
                    ) {
                        Text(
                            text = "Constants.UIText.FORGOT_PASSWORD",
                            color = Color(0xFF8B5CF6), // purple-500
                            fontSize = 14.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Constants.UIText.DO_NOT_HAVE_ACCOUNT",
                            color = Color(0xFF9CA3AF),
                            fontSize = 14.sp
                        )
                        TextButton(
                            onClick = {
                                // Handle sign up
                                println("Sign up clicked")
                            },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "Constants.UIText.SIGN_UP",
                                color = Color(0xFF8B5CF6),
                                fontSize = 14.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(64.dp))

                // Footer
                Text(
                    text = "Constants.UIText.COPYRIGHT",
                    color = Color(0xFF4B5563), // gray-600
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

