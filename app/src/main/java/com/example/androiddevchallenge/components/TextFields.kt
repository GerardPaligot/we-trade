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
package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeTheme

object WeTradeTextFields {
    @Composable
    fun Email(
        modifier: Modifier = Modifier,
        onTextChanged: (text: String) -> Unit = {}
    ) {
        WeTradeTextField(
            label = "Email address",
            leadingIcon = Icons.Filled.MailOutline,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onTextChanged = onTextChanged
        )
    }

    @Composable
    fun Password(
        modifier: Modifier = Modifier,
        onTextChanged: (text: String) -> Unit = {}
    ) {
        WeTradeTextField(
            label = "Password",
            leadingIcon = Icons.Filled.Password,
            modifier = modifier,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onTextChanged = onTextChanged
        )
    }
}

@Composable
internal fun WeTradeTextField(
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = WeTradeTheme.colors.onSurface,
        leadingIconColor = WeTradeTheme.colors.onSurface,
        focusedBorderColor = WeTradeTheme.colors.primary,
        unfocusedBorderColor = WeTradeTheme.colors.onSurface,
        disabledBorderColor = WeTradeTheme.colors.onSurface,
        errorBorderColor = WeTradeTheme.colors.failure,
        focusedLabelColor = WeTradeTheme.colors.primary,
        unfocusedLabelColor = WeTradeTheme.colors.onSurface,
        disabledLabelColor = WeTradeTheme.colors.onSurface,
        errorLabelColor = WeTradeTheme.colors.failure,
        cursorColor = WeTradeTheme.colors.onSurface,
        errorCursorColor = WeTradeTheme.colors.failure,
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onTextChanged: (text: String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onTextChanged(text)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        textStyle = textStyle,
        label = {
            Text(label, style = textStyle)
        },
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        colors = colors,
    )
}

@Preview
@Composable
internal fun WeTradeTextFieldPreview() {
    MyTheme {
        Column {
            WeTradeTextFields.Email()
            Spacer(modifier = Modifier.height(5.dp))
            WeTradeTextFields.Password()
        }
    }
}
