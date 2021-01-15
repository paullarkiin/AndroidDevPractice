package net.paullarkin.cardviewcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

private var count = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        increment()
        decrement()
    }

    private fun increment()
    {

        val tvLeft = findViewById<TextView>(R.id.tvleft)
        val countInc = findViewById<TextView>(R.id.tvCountIncrement)

        tvLeft.setOnClickListener {
            count++
            countInc.text = count.toString()
        }

    }
    private fun decrement()
    {
        val tvRight = findViewById<TextView>(R.id.tvRight)
        val countInc = findViewById<TextView>(R.id.tvCountIncrement)

        tvRight.setOnClickListener {
            count--
            countInc.text = count.toString()
        }
    }
}