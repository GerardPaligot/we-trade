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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.WeTradeButtons
import com.example.androiddevchallenge.components.WeTradeTextFields
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeTheme

@Composable
fun LogIn(
    backgroundColor: Color = WeTradeTheme.colors.surface,
    contentColor: Color = WeTradeTheme.colors.onBackground,
    logIn: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
    ) {
        Box(
            modifier = Modifier.padding(bottom = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Welcome\nback",
                style = WeTradeTheme.typography.h2,
                color = contentColor,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 152.dp),
            )
        }
        WeTradeTextFields.Email(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        WeTradeTextFields.Password(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        WeTradeButtons.Primary(
            text = "Log in",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            onClick = logIn
        )
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LogInPreview() {
    MyTheme {
        LogIn {}
    }
}
