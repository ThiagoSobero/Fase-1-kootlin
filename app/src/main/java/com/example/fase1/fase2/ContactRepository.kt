package com.example.fase1.fase2

import com.example.fase1.fase2.Api.ApiService
import com.example.fase1.fase2.Api.toEntity
import javax.inject.Inject

class ContactRepository @Inject constructor(
    private val apiService: ApiService,
    private val contactDao: ContactDao
) {

    val contacts = contactDao.getAllContacts()

    suspend fun importContacts() {
        val response = apiService.getContacts(
            apiKey = "OUZ6-DXK4-U4BS-K10D"
        )

        val contacts = response.results.map { it.toEntity() }
        contactDao.insertContacts(contacts)
    }

}

