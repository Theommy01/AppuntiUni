package it.omarkiarafederico.skitracker.view.skimap

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import it.omarkiarafederico.skitracker.R
import it.omarkiarafederico.skitracker.databinding.ActivityAboutUsBinding
import it.omarkiarafederico.skitracker.databinding.ActivityMapBinding

class AboutUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_about_us)

        supportActionBar?.title = getString(R.string.aboutUsActivityTitle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val url = "https://github.com/Theommy01/programmazionemobile"
        val repo: TextView = findViewById(R.id.git)

        repo.movementMethod = LinkMovementMethod.getInstance()
        repo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

    }
}