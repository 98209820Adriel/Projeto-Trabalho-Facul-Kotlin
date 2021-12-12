package com.example.cheerupapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cheerupapp.Infra.MotivationConstant
import com.example.cheerupapp.Infra.SecurityPreferences
import com.example.cheerupapp.R
import com.example.cheerupapp.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private   var mPhraseFilter : Int = MotivationConstant.FRASEFILTER.ALL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if (supportActionBar != null ){
            supportActionBar!!.hide()
        }

        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivationConstant.KEY.PERSON_NAME)
        textName.text = "Óla, $name!"

        //Logica inicial de seleção
        imageAll.setColorFilter(resources.getColor(R.color.colorPrimaryDark))
        handleNewFrase()


        buttonNewFrase.setOnClickListener(this)
        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageBomdia.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id

        val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageBomdia)

        if (id == R.id.buttonNewFrase) {
            handleNewFrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

            imageAll.setColorFilter(resources.getColor(R.color.white))
            imageHappy.setColorFilter(resources.getColor(R.color.white))
            imageBomdia.setColorFilter(resources.getColor(R.color.white))


        when (id) {
            R.id.imageAll -> {
                imageAll.setColorFilter(resources.getColor(R.color.colorPrimaryDark))
                mPhraseFilter = MotivationConstant.FRASEFILTER.ALL
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(resources.getColor(R.color.colorPrimaryDark))
                mPhraseFilter = MotivationConstant.FRASEFILTER.HAPPY
            }
            R.id.imageBomdia -> {
                imageBomdia.setColorFilter(resources.getColor(R.color.colorPrimaryDark))
                mPhraseFilter = MotivationConstant.FRASEFILTER.BOMDIA
            }
        }
    }

    private fun handleNewFrase() {
       textFrase.text  = Mock().getPhrase(mPhraseFilter)
    }

}