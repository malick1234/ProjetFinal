package ca.qc.cgodin.projetfinal

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.projetfinal.models.AjoutUtilisateur
import ca.qc.cgodin.projetfinal.models.Enregistrement
import ca.qc.cgodin.projetfinal.models.Jeton
import ca.qc.cgodin.projetfinal.repository.GazouilliRepository
import kotlinx.coroutines.launch

class GazouilliViewModel(
    private val gazouilliRepository: GazouilliRepository
)  : ViewModel(){
    companion object{
       var userUrl =  "/jeton_user/"

    }
    var connect: Jeton? = null
    var ajout: AjoutUtilisateur? = null

    fun getConnexion(auth: String) = viewModelScope.launch {
        try {
            val response = gazouilliRepository.getConnexion(auth)
            Log.i("Reponse de la connexion", "Le jeton est ${response.body()}")
            if(response.isSuccessful){
                if(response.body()?.toString() != "Utilisateur non trouvé"){
                    connect = response.body()
                    userUrl += connect;
                }
                else{

                }
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }

    fun postUtilisateur(enregistrement: Enregistrement) = viewModelScope.launch {
        try {
            val response = gazouilliRepository.postUtilisateur(enregistrement)
            Log.i("Reponse de l'ajout'", "L'ajout est ${response.body()}")
            if(response.isSuccessful){
                if(response.body()?.toString() == ""){
                    ajout = response.body()
                }
                else{

                }
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }
    /*
    fun getCompteSuccursale(compteSuccursale: CompteSuccursale) = viewModelScope.launch {
        try {
            val response = succursaleRepository.getCompteSuccursale(compteSuccursale)
            if(response.isSuccessful){
                if(response.body()?.statut == "OK" && response.body()?.nbSuccursale != null){
                    nbSuccursale = response.body()?.nbSuccursale.toString();
                }
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }

    fun getListeSuccursale(compteSuccursale: CompteSuccursale) = viewModelScope.launch {
        try {
            val response = succursaleRepository.getListeSuccursale(compteSuccursale)
            if(response.isSuccessful){
                if(response.body()?.statut == "OK" && response.body()?.succursales != null){
                    liste.postValue(response.body());
                }
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }

    fun deleteAjoutSuccursale(delete: Delete) = viewModelScope.launch {
        try {
            val response = succursaleRepository.deleteAjoutSuccursale(delete)
            if(response.isSuccessful){
                if(response.body()?.statut == "OK" || response.body()?.statut == "PASOK"){
                    effacer = response.body()?.statut.toString();
                }
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }
    fun setSuccursale(ajout: Ajout) = viewModelScope.launch {
        try {
            val response = succursaleRepository.setSuccursale(ajout)
            if(response.isSuccessful){
                ajouter = response.body()?.statut.toString();
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }*/
}