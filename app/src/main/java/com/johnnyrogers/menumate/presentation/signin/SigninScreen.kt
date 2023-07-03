package com.johnnyrogers.menumate.presentation.signin

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.johnnyrogers.menumate.R
import com.johnnyrogers.menumate.destinations.HomeScreenDestination
import com.johnnyrogers.menumate.destinations.SignupScreenDestination
import com.johnnyrogers.menumate.presentation.common.Brand
import com.johnnyrogers.menumate.ui.theme.fontFamily
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun SigninScreen(
    navigator: DestinationsNavigator?,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.tomato),
            contentDescription = "tomato",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(320.dp)
                .align(Alignment.TopEnd),
        )
    }
    ConstraintLayout(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize(),
    ) {
        val mContext = LocalContext.current
        val (brand, heading, subheading, form, remember, forget_password, signin, google, login) = createRefs()
        val restaurant = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(value = false) }
        val transformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
        val isChecked = remember { mutableStateOf(false) }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .constrainAs(brand) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start)
                },
        ) {
            Brand(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        }

        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                    ),
                ) {
                    append("Sign In")
                }
            },
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 48.sp,
            textAlign = TextAlign.Start,
            lineHeight = 52.sp,
            modifier = Modifier
                .width(520.dp)
                .constrainAs(heading) {
                    top.linkTo(brand.bottom, 52.dp)
                    start.linkTo(parent.start)
                },
        )

        Text(
            text = "Welcome! Please sign in to access your account. Enter your email and password below to continue. Thank you for choosing us!",
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .width(500.dp)
                .constrainAs(subheading) {
                    top.linkTo(heading.bottom, 16.dp)
                    start.linkTo(parent.start)
                },
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(form) {
                    top.linkTo(subheading.bottom, 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        ) {
            Text("Email")
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "youremail@mail.com",
                        color = MaterialTheme.colorScheme.outline,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "email",
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text("Password")
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                visualTransformation = transformation,
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "supersecret",
                        color = MaterialTheme.colorScheme.outline,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Password,
                        contentDescription = "password",
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(
                        onClick = { showPassword = !showPassword },
                    ) {
                        val icon = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        Icon(
                            imageVector = icon,
                            contentDescription = "hide_password",
                        )
                    }
                },
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .constrainAs(remember) {
                    top.linkTo(form.bottom, 20.dp)
                    start.linkTo(parent.start, 0.dp)
                },
        ) {
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { checked ->
                        isChecked.value = checked
                    },
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Remember me",
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .constrainAs(forget_password) {
                    top.linkTo(form.bottom, 20.dp)
                    end.linkTo(parent.end, 0.dp)
                },
        ) {
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline,
                        ),
                    ) {
                        append("Forgot password?")
                    }
                },
                onClick = {
                    navigator?.navigate(SignupScreenDestination)
                },
            )
        }

        Button(
            onClick = {
                navigator?.navigate(HomeScreenDestination)
            },
            colors = ButtonDefaults.textButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .constrainAs(signin) {
                    top.linkTo(remember.bottom, 82.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        ) {
            Text(
                text = "Sign In",
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(google) {
                    top.linkTo(signin.bottom, 42.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Divider(
                    modifier = Modifier.width(320.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                )
                Text(
                    text = "Or",
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                )
                Divider(
                    modifier = Modifier.width(320.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                )
            }

            Button(
                onClick = {
                },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 62.dp)
                    .height(65.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Image",
                        modifier = Modifier
                            .height(32.dp)
                            .width(32.dp),

                    )
                    Spacer(Modifier.width(16.dp))
                    Text(
                        text = "Sign in with Google",
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .constrainAs(login) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, 32.dp)
                },
        ) {
            Text(
                text = "Don't have an account?",
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.padding(2.dp))
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline,
                        ),
                    ) {
                        append("Signup")
                    }
                },
                onClick = {
                    navigator?.navigate(SignupScreenDestination)
                },
            )
        }
    }
}

private fun mToast(context: Context) {
    Toast.makeText(context, "This is a Sample Toast", Toast.LENGTH_SHORT).show()
}
