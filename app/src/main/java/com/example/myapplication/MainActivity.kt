package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.Room.User
import com.example.myapplication.Room.UserDatabase
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
        finish()

        var users: List<User>

        val recyclerView : RecyclerView = findViewById(R.id.employeerRV)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val firstNameEditText : TextInputEditText = findViewById(R.id.firstNameEditText)
        val lastNameEditText : TextInputEditText = findViewById(R.id.lastNameEditText)
        val phoneNumberEditText : TextInputEditText = findViewById(R.id.phoneNoEditText)
        val submit : Button = findViewById(R.id.submitButton)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "database-name")
            .build()





        var firstName : String ?
        var lastName : String ?
        var phoneNumber : Int ?

        submit.setOnClickListener{
            firstName = if (!firstNameEditText.text.isNullOrBlank()){
                firstNameEditText.text.toString()
            }else{
                null
            }

            lastName = if (!lastNameEditText.text.isNullOrBlank()){
                lastNameEditText.text.toString()
            } else {
                null
            }

            phoneNumber = if (!phoneNumberEditText.text.isNullOrBlank()){
                phoneNumberEditText.text.toString().toInt()
            }else {
                null
            }

            insertEmployee(firstName = firstName, lastName = lastName, phoneNumber = phoneNumber)

        }

        db.userDao().getAllEmployees().observe(this) { it ->
            println(it)
            recyclerView.adapter = RecyclerViewAdapter(it)
        }




/*
                lifecycleScope.launch {
                    withContext(Dispatchers.IO){

        //                users = db.userDao().getAllEmployees()


                    }
                    withContext(Dispatchers.Main){
//                        recyclerView.adapter = RecyclerViewAdapter(users)
                        db.userDao().getAllEmployees().observe(this@MainActivity, Observer{
                            println(it)
                        })



                    }
                }


 */

    }

    private fun insertEmployee(firstName : String?= null, lastName : String?= null, phoneNumber : Int? = null){
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = buildDatabase()
                db.userDao().insertEmployee(
                    User(
                        firstName = firstName,
                        lastName = lastName,
                        phoneNumber = phoneNumber
                    )
                )
            }
            withContext(Dispatchers.Main){


            }
        }
    }




    private fun buildDatabase() : UserDatabase {
        return Room.databaseBuilder(
                applicationContext,
                UserDatabase::class.java, "database-name")
            .build()
    }


}