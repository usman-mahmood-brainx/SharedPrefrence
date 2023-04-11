package com.example.sharedprefrence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedprefrence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref  = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.apply {
            btnSave.setOnClickListener {
                val userName = edtUserName.text.toString()
                val email = edtEmail.text.toString()

                editor.apply {
                    putString("userName",userName)
                    putString("email",email)
                    apply()

                }
            }

            btnLoad.setOnClickListener {
                val userName = sharedPref.getString("userName",null)
                val email = sharedPref.getString("email",null)
                tvUserName.text = userName
                tvEmail.text = email
            }
        }
        
        
    }
}