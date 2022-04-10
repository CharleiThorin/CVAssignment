package com.example.charles.curriculumvitae

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.charles.curriculumvitae.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var mainBinder: ActivityLoginBinding

    private val users:ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinder = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mainBinder.root)

        users.add(User("Charles", "Kyewalabye", "ckiwabs@miu.edu", "thorin"))
        users.add(User("Oaken", "Thor", "thor@miu.edu", "thorin"))
        users.add(User("Wayne", "Kiwabs", "wayne@miu.edu", "thorin"))
        users.add(User("Neo", "Matrix", "neo@miu.edu", "thorin"))

        mainBinder.signIn.setOnClickListener {
            val validUser = users.find { it.username == mainBinder.email.text.toString() }

            if (validUser?.password == mainBinder.password.text.toString()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", validUser.username)
                startActivity(intent)
            }
        }

        val activityLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == Activity.RESULT_OK){
                val user  = result.data?.extras?.getSerializable("user") as User
                users.add(user)
            }
        }

        mainBinder.createAccountButton.setOnClickListener {
            activityLaunch.launch(Intent(this, RegisterActivity::class.java))
        }

        mainBinder.forgotPass.setOnClickListener {
            val password = users.find { it.username == mainBinder.email.text.toString() }?.password
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, password)
            startActivity(intent)
        }
    }
}