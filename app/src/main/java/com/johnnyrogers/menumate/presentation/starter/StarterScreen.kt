package com.johnnyrogers.menumate.presentation.starter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.johnnyrogers.menumate.R
import com.johnnyrogers.menumate.destinations.SetupScreenDestination
import com.johnnyrogers.menumate.presentation.common.Brand
import com.johnnyrogers.menumate.ui.theme.Orange80
import com.johnnyrogers.menumate.ui.theme.fontFamily
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun StarterScreen(
    navigator: DestinationsNavigator?,
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize(),
    ) {
        val (brand, heading, illustration, subheading, button) = createRefs()
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
                    append("MenuMate")
                }
                append(": Where Menus Meet Convenience!")
            },
            fontFamily = fontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 52.sp,
            textAlign = TextAlign.Start,
            lineHeight = 52.sp,
            modifier = Modifier
                .width(520.dp)
                .constrainAs(heading) {
                    top.linkTo(brand.bottom, 32.dp)
                    start.linkTo(parent.start)
                },
        )

        Image(
            painter = painterResource(id = R.drawable.illustration),
            contentDescription = "illustration",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(400.dp)
                .constrainAs(illustration) {
                    top.linkTo(heading.bottom, 42.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )

        Text(
            text = buildAnnotatedString {
                append("Optimize your service with ")
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                    ),
                ) {
                    append("MenuMate")
                }
                append(" – the perfect tool for organizing menus, managing orders, and achieving your goals.")
            },
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .width(500.dp)
                .constrainAs(subheading) {
                    top.linkTo(illustration.bottom, 32.dp)
                    start.linkTo(parent.start)
                },
        )
        Button(
            onClick = {
                navigator?.navigate(SetupScreenDestination)
            },
            colors = ButtonDefaults.textButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier
                .width(300.dp)
                .height(65.dp)
                .shadow(
                    10.dp,
                    spotColor = Orange80,
                    shape = RoundedCornerShape(28.dp),
                )
                .constrainAs(button) {
                    top.linkTo(subheading.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
        ) {
            Text(
                text = "Let's Start",
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        }
    }
}

@Preview
@Composable
fun StarterScreenPreview() {
    StarterScreen(navigator = null)
}
