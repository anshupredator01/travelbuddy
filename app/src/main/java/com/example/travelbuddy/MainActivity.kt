package com.example.travelbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.util.jar.Attributes
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

    private lateinit var textviewWelcome: MaterialTextView
    companion object {
        const val Name = "NameOfUserLogged"
    }
    private var name: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textviewWelcome = findViewById(R.id.textview_welcome)


        user.let {
            // Name, email address, and profile photo Url
            name = user.displayName
            val email = user.email
            val photoUrl = user.photoUrl

            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            val uid = user.uid
        }

        name = if (intent != null) {
            intent.getStringExtra(Name)
        } else {
            "!"
        }

        "Welcome\n $name !".also { textviewWelcome.text = it }


    }
}