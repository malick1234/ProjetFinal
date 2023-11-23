package ca.qc.cgodin.projetfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.qc.cgodin.projetfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        var test = 0
        setContentView(view)
    }
}