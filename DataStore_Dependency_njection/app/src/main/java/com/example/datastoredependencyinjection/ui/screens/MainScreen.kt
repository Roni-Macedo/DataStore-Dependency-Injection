package com.example.datastoredependencyinjection.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.datastoredependencyinjection.datastore.DataStoreManager
import com.example.datastoredependencyinjection.ui.theme.PurpleGrey40
import com.example.datastoredependencyinjection.ui.theme.PurpleGrey80
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current
    val dataStoreManager = remember { DataStoreManager(context) }

    var text by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        dataStoreManager.getText().collect {
            result = it
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(PurpleGrey80)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                result,
                fontSize = 30.sp
            )
            OutlinedTextField(
                modifier = Modifier.padding(16.dp),
                value = text,
                onValueChange = { text = it }
            )
            Button(
                modifier = Modifier,
                onClick = {
                    scope.launch {
                        if (text.isNotBlank()) {
                            dataStoreManager.saveText(text)
                        }
                        text = ""
                    }

                },
                colors = ButtonDefaults.buttonColors(PurpleGrey40)
            ) {
                Text("SAVE")
            }
        }
    }
}