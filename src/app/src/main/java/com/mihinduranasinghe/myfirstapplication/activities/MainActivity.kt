package com.mihinduranasinghe.myfirstapplication.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mihinduranasinghe.myfirstapplication.Constants
import com.mihinduranasinghe.myfirstapplication.R
import com.mihinduranasinghe.myfirstapplication.showToast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        val TAG: String = MainActivity::class.java.simpleName//when you write any Log statement we can use TAG

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnShowToast.setOnClickListener{
            Log.i(TAG, "Button was clicked")
            showToast("Button was clicked !")
        }



        btnSubmit.setOnClickListener() {
            val userName: String = txtUserName.text.toString()

            //Navigating to second layout window activity
            val intent = Intent(
                this,
                SecondActivity::class.java
            )
            //intent.putExtra("user_name", userName)//Passing the message
            intent.putExtra(Constants.USER_MSG_KEY, userName)//Passing the message
            startActivity(intent)
        }


            btnShareToOtherApps.setOnClickListener{ //Share To Other Applications

                    //val message: String=etUserMessage.text.toString()
                    val message: String="test"
                    val intent = Intent()
                    intent.action=Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type="text/plain"

                    startActivity(Intent.createChooser(intent, "Please select app: "))


            }




            btnRecycle.setOnClickListener() {
                val intentcards = Intent(
                    this,
                    HobbiesActivity::class.java
                )
                startActivity(intentcards)
            }


        }


    }


