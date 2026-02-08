package com.example.fase1.ui.viewmodel


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fase1.ui.model.RandomuserApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor() : ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _contacts = mutableStateOf(listOf<String>())
    val contacts: State<List<String>> = _contacts

    @RequiresApi(Build.VERSION_CODES.O)
    fun importContacts() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val client = HttpClient(CIO) {
                    install(ContentNegotiation) {
                        json(Json { ignoreUnknownKeys = true })
                    }
                }

                // Llamada a tu API Randomuser.com
                val response: RandomuserApiResponse = client.get("https://randomuser.me/api").body()

                // Mapear nombres completos
                val newContacts = response.results.map { "${it.name.first} ${it.name.last}" }

                _contacts.value = newContacts

                client.close()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}