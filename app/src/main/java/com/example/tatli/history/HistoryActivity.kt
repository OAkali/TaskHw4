package com.example.tatli.history

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.tatli.App
import com.example.tatli.databinding.ActivityHistoryBinding
import com.example.tatli.db.Note
import com.example.tatli.history.adapter.TitleAdapter
import com.example.tatli.main.MainActivity

class HistoryActivity : AppCompatActivity() {
    private val binding: ActivityHistoryBinding by lazy {
        ActivityHistoryBinding.inflate(layoutInflater)

    }
    private val t_Adapter = TitleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvItem.adapter = t_Adapter
        binding.add.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        save()
    }
    private fun save() {
        App.db.noteDao().getAllNotes().observe(this, Observer {
            t_Adapter.submitList(it)
        })
    }

}