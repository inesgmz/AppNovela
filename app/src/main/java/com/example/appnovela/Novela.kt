package com.example.appnovela

data class Novela(
    val titulo: String,
    val autor: String,
    val año: Int,
    val sinopsis: String,
    var reseñas: MutableList<String> = mutableListOf(),
    var esFavorita: Boolean = false



)
