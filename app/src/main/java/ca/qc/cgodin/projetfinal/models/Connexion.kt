package ca.qc.cgodin.projetfinal.models

import com.google.gson.annotations.SerializedName

data class Connexion(
    @SerializedName("nom")
    val nom: String,
    @SerializedName("mdp")
    val mdp: String
)