package com.poli.botanicalassistant.domain.video

data class Video(
    val id: String, // Identificador único del video
    val videoName: String, // Nombre del video
    val creationDate: String, // Fecha de creación
    val duration: Int, // Duración en segundos
    val category: List<String>, // Categorías a las que pertenece el video
    val author: String, // Autor del video
    val serverId: String // Identificador del servidor donde está almacenado el video
)
