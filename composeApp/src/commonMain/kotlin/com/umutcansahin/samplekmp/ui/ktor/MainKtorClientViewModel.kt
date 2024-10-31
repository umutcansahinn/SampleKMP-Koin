package com.umutcansahin.samplekmp.ui.ktor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

private const val TODO_ENDPOINT = "https://jsonplaceholder.typicode.com/todos/1"

class MainKtorClientViewModel(
    private val ktorClient: HttpClient
) : ViewModel() {

    private val _data = MutableStateFlow<String>("Empty")
    val data = _data.asStateFlow()


    fun getData() {
        viewModelScope.launch {
            try {
                val result = ktorClient.get(urlString = TODO_ENDPOINT).body<Response>()
                delay(2_500)
                _data.update { result.toString() }
            }catch (exception:Exception) {
                _data.update {
                    exception.message.toString()
                }
            }
        }
    }
}

@Serializable
data class Response(
    val userId: Int = -1,
    val id: Int = -1,
    val title: String = "",
    val completed: Boolean = false
)