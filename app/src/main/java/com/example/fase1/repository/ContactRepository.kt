package com.example.fase1.repository

import com.example.fase1.data.local.dao.ContactDao
import com.example.fase1.Api.toEntity
import com.example.fase1.remote.datasource.ApiService
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