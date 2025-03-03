package com.example.learningretrofit.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learningretrofit.databinding.ActivityMainBinding
import com.example.learningretrofit.viewModel.PostVM

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postVM: PostVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postVM = ViewModelProvider(this).get(PostVM::class.java)

        setListeners()
        setObservers()
    }

    fun setListeners() {
        binding.btnGetPost.setOnClickListener(this)
    }

    fun setObservers() {
        postVM.getPostVM().observe(this, Observer {
            if (it != null)
                binding.tvGreeting.text = "UserId: ${it.userId}\nId: ${it.id}\nTitle: ${it.title}\nBody: ${it.body}"
        })
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            binding.btnGetPost.id -> {
                val id = binding.etGetPostId.text.toString()
                if (id != "")
                    postVM.requestPost(id)
                else
                    Toast.makeText(this, "empty id", Toast.LENGTH_LONG).show()
            }
        }
    }

}