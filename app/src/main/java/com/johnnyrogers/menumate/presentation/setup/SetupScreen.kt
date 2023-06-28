package com.johnnyrogers.menumate.presentation.setup

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.johnnyrogers.menumate.destinations.SetupScreenDestination
import com.johnnyrogers.menumate.presentation.common.Brand
import com.johnnyrogers.menumate.ui.theme.fontFamily
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun SetupScreen(
    navigator: DestinationsNavigator?,
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize(),
    ) {
        val (brand, heading, subheading, form, button, footer) = createRefs()
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
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
                    append("Signup")
                }
            },
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            textAlign = TextAlign.Start,
            lineHeight = 52.sp,
            modifier = Modifier
                .width(520.dp)
                .constrainAs(heading) {
                    top.linkTo(brand.bottom, 22.dp)
                    start.linkTo(parent.start)
                },
        )

        Text(
            text = "the perfect tool for organizing menus, managing orders, and achieving your goals.",
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
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(modifier = Modifier.padding(8.dp))
            val isChecked = remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .width(IntrinsicSize.Max),
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
                    text = buildAnnotatedString {
                        append("I agree with ")
                        withStyle(
                            SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                            ),
                        ) {
                            append("Terms ")
                        }
                        append("and ")
                        withStyle(
                            SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                            ),
                        ) {
                            append("Privacy")
                        }
                    },
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                )
            }
        }

        Button(
            onClick = {
                navigator?.navigate(SetupScreenDestination)
            },
            colors = ButtonDefaults.textButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .constrainAs(button) {
                    top.linkTo(form.bottom, 82.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        ) {
            Text(
                text = "Let's Roll",
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(),

        ) {
            Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.primary)
        }
    }
}
