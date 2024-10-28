package com.umutcansahin.samplekmp.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val mainViewModel = koinViewModel<MainViewModel>()
    val singletonFirst by mainViewModel.singletonFirst.collectAsState()
    val singletonSecond by mainViewModel.singletonSecond.collectAsState()
    val factoryFirst by mainViewModel.factoryFirst.collectAsState()
    val factorySecond by mainViewModel.factorySecond.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                mainViewModel.increaseSingletonFirst()
            }
        ) {
            Text("singletonFirst")
        }
        Button(
            onClick = {
                mainViewModel.increaseSingletonSecond()
            }
        ) {
            Text("singletonSecond")
        }
        Text(text = singletonFirst.toString())
        Text(text = singletonSecond.toString())

        Button(
            onClick = {
                mainViewModel.increaseFactoryFirst()
            }
        ) {
            Text("factoryFirst")
        }
        Button(
            onClick = {
                mainViewModel.increaseFactorySecond()
            }
        ) {
            Text("factorySecond")
        }
        Text(text = factoryFirst.toString())
        Text(text = factorySecond.toString())
    }
}