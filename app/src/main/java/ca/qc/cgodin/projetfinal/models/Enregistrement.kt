package ca.qc.cgodin.projetfinal.models

import com.google.gson.annotations.SerializedName

data class Enregistrement(
    @SerializedName("nom")
    val nom: String,
    @SerializedName("courriel")
    val courriel: String,
    @SerializedName("mdp1")
    val mdp: String
)
