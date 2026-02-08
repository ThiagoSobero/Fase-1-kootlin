package com.example.fase1.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fase1.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ContactRepository
) : ViewModel() {

    val contacts = repository.contacts
        .stateIn(
            viewModelScope,
            SharingStarted.Companion.WhileSubscribed(5_000),
            emptyList()
        )

    fun importContacts() {
        viewModelScope.launch {
            repository.importContacts()
        }
    }
}