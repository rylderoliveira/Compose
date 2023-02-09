package com.impacta.compose.text

data class User(
    val profileImage: String,
    val name: String,
    val age: Int,
    val city: String,
    val curiosities: List<Curiosity>
)

data class Curiosity(
    val title: String,
    val description: String,
)
