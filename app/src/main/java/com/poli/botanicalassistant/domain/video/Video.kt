package com.poli.botanicalassistant.domain.video

/**
 * Representa un video con detalles sobre su nombre, autor, categoría, y otros atributos.
 *
 * @property id El identificador único del video.
 * @property videoName El nombre del video.
 * @property creationDate La fecha de creación del video.
 * @property duration La duración del video en segundos.
 * @property category Lista de categorías a las que pertenece el video.
 * @property author El autor del video.
 * @property serverId El identificador del servidor donde está almacenado el video.
 * @property imageUrl La URL de la imagen del video.
 */
data class Video(
    val id: String,
    val videoName: String,
    val creationDate: String,
    val duration: Int,
    val category: List<VideoType>,
    val author: String,
    val serverId: String,
    val imageUrl: String
)
