package ca.qc.cgodin.projetfinal.network

import ca.qc.cgodin.projetfinal.models.Enregistrement
import ca.qc.cgodin.projetfinal.models.AjoutUtilisateur
import ca.qc.cgodin.projetfinal.models.Jeton
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


interface GazouilliApiService {
    @GET("/jeton")
    suspend fun getConnexion(@Header("Authorization") auth: String): Response<Jeton> //Call<ResponseBody>
    @POST("/utilisateurs")
    suspend fun postUtilisateur(@Body enregistrement: Enregistrement): Response<AjoutUtilisateur> //Call<ResponseBody>

    @GET("/jeton_user/{Jeton}")
    suspend fun getUtilisateur(@Header("Authorization") auth: String, @Path("Jeton") jeton: Jeton): Response<Jeton> //Call<ResponseBody>

    /*
        @POST("/succursales/Succursale-Liste")
        suspend fun getListeSuccursale(@Body compteSuccursale: CompteSuccursale): Response<ResponseSuccursales>

        @POST("/succursales/Succursale-Compte")
        suspend fun getCompteSuccursale(@Body compteSuccursale: CompteSuccursale): Response<NbSuccursales>

        @POST("/succursales/Succursale-Budget")
        suspend fun setBudgetSuccursale(aut: String, ville: String)

        @DELETE("/succursales/Succursale-Suppression")
        suspend fun deleteAjoutSuccursale(aut: String, ville: String)*/


}