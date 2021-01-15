package com.udacity.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.udacity.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName( "Paul Larkin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

       // findViewById<Button>(R.id.done_button).setOnClickListener {
         //   addNicknameView(it)
        //}

        binding.doneButton.setOnClickListener {
            addNicknameView(it)
        }
    }

    private fun addNicknameView(view: View) {

        binding.apply {
          //  binding.nicknameText.text = binding.editText.text
            binding.myName?.nickname = editText.text.toString()
            invalidateAll() // re-create the elements with the correct data.
            binding.editText.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}


