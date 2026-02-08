package com.example.fase1.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.fase1.data.local.User
import com.example.fase1.ui.model.RetrofitInstance
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    var users by mutableStateOf<List<User>>(emptyList())
        private set

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            try {
                users = RetrofitInstance.api.getUsers().results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
