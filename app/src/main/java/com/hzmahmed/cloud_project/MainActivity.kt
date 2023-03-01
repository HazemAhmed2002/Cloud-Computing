package com.hzmahmed.cloud_project

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hzmahmed.cloud_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener{
            val name = binding.PersonName.text.toString()
            val id = binding.PersonId.text.toString()
            val age = binding.PersonAge.text.toString()

            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age,
            )
            db.collection("persons")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener { e ->
                    Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()
                }

            }


    }
}