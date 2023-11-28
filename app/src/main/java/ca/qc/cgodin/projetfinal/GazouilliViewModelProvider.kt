package ca.qc.cgodin.projetfinal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.qc.cgodin.projetfinal.repository.GazouilliRepository

class GazouilliViewModelProvider(
    private val gazouilliRepository: GazouilliRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(GazouilliViewModel::class.java)){
            GazouilliViewModel(gazouilliRepository) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}