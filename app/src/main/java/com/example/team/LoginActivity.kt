package com.example.team

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        // Need to updateUI and pass the user obj
    }

    fun loginAccount (view : View){
        val email = findViewById<EditText>(R.id.emailEditText).text.toString()
        val password = findViewById<EditText>(R.id.passwdEditText).text.toString()

        auth.signInWithEmailAndPassword( email, password)
            .addOnCompleteListener(this) { task ->
                if ( task.isSuccessful ){
                    // Sign in is success. Update UI with signed-in user's info
                    val user = auth.currentUser
                    // Need to updateUI and pass the user obj
                } else {
                    Log.w(TAG, "Sign In w/ Email Failed", task.exception)
                    Toast.makeText(baseContext, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    companion object {
        private const val TAG = " Email or Password invalid";
    }


}
