package ca.qc.cgodin.projetfinal.repository

import ca.qc.cgodin.mini_projet3.network.RetrofitInstance
import ca.qc.cgodin.projetfinal.models.Connexion
import ca.qc.cgodin.projetfinal.models.Enregistrement
import retrofit2.http.Body

class GazouilliRepository() {
    suspend fun getConnexion(auth: String) =
        RetrofitInstance.retrofitService.getConnexion(auth);

    suspend fun postUtilisateur(enregistrement: Enregistrement) =
        RetrofitInstance.retrofitService.postUtilisateur(enregistrement);

    /*suspend fun getCompteSuccursale(@Body compteSuccursale: CompteSuccursale) =
        RetrofitInstance.retrofitService.getCompteSuccursale(compteSuccursale);

    suspend fun getListeSuccursale(@Body compteSuccursale: CompteSuccursale) =
        RetrofitInstance.retrofitService.getListeSuccursale(compteSuccursale);

    suspend fun deleteAjoutSuccursale(@Body delete: Delete) =
        RetrofitInstance.retrofitService.deleteAjoutSuccursale(delete);

    suspend fun setSuccursale(@Body ajout: Ajout) =
        RetrofitInstance.retrofitService.setSuccursale(ajout);*/

}
