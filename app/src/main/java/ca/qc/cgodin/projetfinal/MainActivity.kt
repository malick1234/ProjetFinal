package ca.qc.cgodin.projetfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import ca.qc.cgodin.projetfinal.databinding.ActivityMainBinding
import ca.qc.cgodin.projetfinal.repository.GazouilliRepository
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    private val navController by lazy {     val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navHostFragment.navController }

    private lateinit var binding: ActivityMainBinding
    private lateinit var gazouilliViewModel: GazouilliViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val gazouilliRepository = GazouilliRepository();
        val viewModelProviderFactory = GazouilliViewModelProvider(gazouilliRepository)
        try {
            val viewModelProvider = ViewModelProvider(
                navController.getViewModelStoreOwner(R.id.nav_graph),
                viewModelProviderFactory)
                gazouilliViewModel = viewModelProvider.get(GazouilliViewModel::class.java)
        }catch (e:IllegalArgumentException){
            e.printStackTrace()
        }
    }
}