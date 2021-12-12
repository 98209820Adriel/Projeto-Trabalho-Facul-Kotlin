package com.example.cheerupapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cheerupapp.Infra.MotivationConstant
import com.example.cheerupapp.Infra.SecurityPreferences
import com.example.cheerupapp.R
import com.example.cheerupapp.databinding.ActivitySplashBinding
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var  mSecurityPreferences: SecurityPreferences

    private  lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mSecurityPreferences = SecurityPreferences(this)


        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        butts.setOnClickListener(this)

        verifyName()


    }

    override fun onClick( view: View) {
       val id = view.id
        if (id == R.id.butts){
            handleSave()

        }
    }

    private fun verifyName(){
        val name = mSecurityPreferences.getString(MotivationConstant.KEY.PERSON_NAME)
        if (name != ""){

            startActivity(Intent(this, MainActivity::class.java))

        }
    }

    private fun handleSave(){
        val name =  ediName.text.toString()

        if (name != ""){
            mSecurityPreferences.storeString(MotivationConstant.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))


        }else{
            Toast.makeText(this, "Informe seu nome?", Toast.LENGTH_SHORT).show()
        }


    }
}