package com.johnnyrogers.menumate.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johnnyrogers.menumate.R
import com.johnnyrogers.menumate.ui.theme.fontFamily

@Composable
fun Brand(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        modifier = Modifier.size(32.dp),
    )
    Spacer(
        modifier = Modifier
            .size(8.dp),
    )
    Text(
        text = "Menu Mate",
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Left,
        modifier = modifier,
    )
}
