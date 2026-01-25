package com.example.fase1.fase2.Api

import com.example.fase1.fase2.ContactEntity

fun ApiContact.toEntity(): ContactEntity {
    return ContactEntity(
        name = "${name.first} ${name.last}",
        phone = phone,
        email = email,
        image = picture.medium
    )
}
