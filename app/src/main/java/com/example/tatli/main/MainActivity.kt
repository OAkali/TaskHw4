package com.example.tatli.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tatli.App
import com.example.tatli.R
import com.example.tatli.databinding.ActivityMainBinding
import com.example.tatli.db.Note
import com.example.tatli.history.HistoryActivity

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.save.setOnClickListener {
            binding.apply {
                if (!binding.etTitle.text
                        .isNullOrEmpty() && !binding.etDesc.text.isNullOrEmpty()
                ){
                save()
                    startActivity(Intent(this@MainActivity,HistoryActivity::class.java))
                }else Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }

    }
    private fun save() {
        val data = Note(
            title = binding.etTitle.text.toString(),
            value = binding.etDesc.text.toString()
        )
        App.db.noteDao().insert(data)
    }



    companion object{
        const val KEY_R="key.r"
    }
}