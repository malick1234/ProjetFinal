package ca.qc.cgodin.projetfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.projetfinal.databinding.FragmentEtablirSessionBinding
import java.util.Base64

class EtablirSessionFragment : Fragment() {
    private lateinit var _binding: FragmentEtablirSessionBinding
    private val binding get() = _binding!!
    private val viewModel: GazouilliViewModel by navGraphViewModels(R.id.nav_graph)
    var nom : String = ""
    var mdp : String = ""
    companion object {
        var mdp_base64 = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEtablirSessionBinding.inflate(layoutInflater);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConnexion.setOnClickListener{
            nom = binding.txtNom.text.toString();
            mdp = binding.txtPassword.text.toString();

            if(nom == "" || mdp == ""){
                Toast.makeText(activity, "Veuillez renseignez les champs!",
                    Toast.LENGTH_LONG).show()
            }
            else{
                val motDePasse = "$nom:$mdp"
                mdp_base64 = Base64.getEncoder().encodeToString(motDePasse.toByteArray())
                viewModel.getConnexion("Bearer $mdp_base64");

                if(viewModel.connect?.jeton?.toString() != null){
                    findNavController().navigate(R.id.action_etablirSessionFragment_to_indexFragment)
                    Toast.makeText(activity, "Bienvenue " + viewModel.connect?.jeton?.toString(),
                        Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(activity, "Les informations entrées sont incorrectes!",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}