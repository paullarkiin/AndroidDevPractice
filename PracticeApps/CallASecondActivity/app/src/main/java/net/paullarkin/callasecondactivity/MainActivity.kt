package net.paullarkin.callasecondactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureNext()
    }

    private fun configureNext()
    {
        val nextButton = findViewById<Button>(R.id.btnNext)


        nextButton.setOnClickListener {
            val intent = Intent(this, ActivityNext::class.java)
            startActivity(intent)
        }
    }
}