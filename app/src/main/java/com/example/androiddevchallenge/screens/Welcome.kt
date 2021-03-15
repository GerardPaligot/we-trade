/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.WeTradeButtons
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Welcome(
    getStarted: () -> Unit,
    logIn: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.welcome_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "WeTrade",
            modifier = Modifier.align(alignment = Alignment.Center)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
        ) {
            WeTradeButtons.Primary(
                text = "Get started",
                onClick = getStarted,
                modifier = Modifier.weight(1f)
            )
            WeTradeButtons.Outlined(
                text = "Log in",
                onClick = logIn,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreview() {
    MyTheme {
        Welcome(
            getStarted = {},
            logIn = {}
        )
    }
}
