package com.learning.dialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    lateinit var userName:EditText
    lateinit var userAge:EditText
    lateinit var buttonOk:Button
    lateinit var buttonCancel:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_dialog,container,false)
        userName = view.findViewById(R.id.editTextName)
        userAge = view.findViewById(R.id.editTextAge)
        buttonOk = view.findViewById(R.id.buttonOk)
        buttonCancel = view.findViewById(R.id.buttonCancel)

        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)

        buttonOk.setOnClickListener {
            if (userName.text.isEmpty() || userAge.text.isEmpty()){
                Toast.makeText(requireActivity(),"Enter Your Name and Age",Toast.LENGTH_LONG).show()
            }else{
                val enteredName = userName.text.toString()
                val enteredAge = userAge.text.toString().toInt()
                val mainActivity:MainActivity = activity as MainActivity
                mainActivity.getUserData(enteredName,enteredAge)
                dialog!!.dismiss()
            }
        }
        buttonCancel.setOnClickListener {
            dialog!!.dismiss()
        }
        return view//inflater.inflate(R.layout.fragment_my_dialog, container, false)
    }

}