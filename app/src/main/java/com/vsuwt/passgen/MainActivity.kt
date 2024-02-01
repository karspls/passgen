package com.vsuwt.passgen

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var generatedTv: TextView
    private lateinit var generateBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generatedTv = findViewById(R.id.generated_password_tv)
        generateBtn = findViewById(R.id.generate_pwd_btn)
        generateBtn.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.generate_pwd_btn -> {
                val digits = ('0'.. '9').toList()
                val lower = ('a'..'z').toList()
                val upper = lower.map { it.uppercaseChar() }
                var all = digits + lower + upper
                val pwd = (1..12).map { all.random() }.joinToString("")
                generatedTv.text = pwd
            }
        }

    }
}