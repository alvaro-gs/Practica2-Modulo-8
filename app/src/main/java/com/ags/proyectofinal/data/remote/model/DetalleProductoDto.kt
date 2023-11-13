package com.ags.proyectofinal.data.remote.model

import com.google.gson.annotations.SerializedName

data class DetalleProductoDto(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("image")
    var imageURL: String? = null,
    @SerializedName("long_desc")
    var description: String? = null,
    @SerializedName("type_id")
    var categoryId: Long ? = 0,
    @SerializedName("presentations")
    var presentations : List<Presentations>? = null,
    @SerializedName("latitud")
    var latitud : Double? = 0.0,
    @SerializedName("longitud")
    var longitud : Double? = 0.0

)

data class Presentations(
    @SerializedName("desc")
    var desc: String? = null,
    @SerializedName("price")
    var price: Double? = 0.0
)
