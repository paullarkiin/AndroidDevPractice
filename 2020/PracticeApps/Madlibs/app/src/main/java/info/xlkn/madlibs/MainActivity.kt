package info.xlkn.madlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnGenerate.setOnClickListener{

            val adj = editText_Adj.text.toString()
            val verb = editText_Verb.text.toString()
            val colour = editText_colour.text.toString()
            val noun = editText_Noun.text.toString()

            textView_outputMadlib.setText("The $colour dragon $verb at the $adj $noun and everyone lived happy ever after.\n The End.")


        }


    }
}