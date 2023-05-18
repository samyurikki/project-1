package com.learning.dialogfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    lateinit var showButton:Button
    lateinit var name:TextView
    lateinit var age:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showButton = findViewById(R.id.showFragment)
        name=findViewById(R.id.textViewName)
        age=findViewById(R.id.textViewAge)

        showButton.setOnClickListener {
            val fragmentManager:FragmentManager = supportFragmentManager
            val myDialog = MyDialogFragment()
            myDialog.isCancelable = false
            myDialog.show(fragmentManager,"MyDialogFragment")
            }
    }

    fun getUserData(userName:String,userAge:Int){
        name.text = "Name: $userName"
        age.text = "Age: ${userAge}"
    }
}