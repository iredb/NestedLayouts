package com.example.nestedlayouts

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private fun roll(textViews: List<TextView>) {
        for (i in textViews.indices) {
            val currentValue = textViews[i].text.toString().toIntOrNull()
            if (currentValue != null) {
                textViews[i].text = ""
                val nextIndex = (i + 1) % textViews.size
                textViews[nextIndex].text = (currentValue + 1).toString()
                break
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonRoll: Button = findViewById(R.id.button_roll)

        val linearHorizontalLayout = listOf<TextView>(
            findViewById<TextView>(R.id.h1),
            findViewById<TextView>(R.id.h2),
            findViewById<TextView>(R.id.h3)
        )
        val linearVerticalLayout = listOf<TextView>(
            findViewById<TextView>(R.id.v1),
            findViewById<TextView>(R.id.v2),
            findViewById<TextView>(R.id.v3)
        )
        val constraintLayout = listOf<TextView>(
            findViewById<TextView>(R.id.c1),
            findViewById<TextView>(R.id.c2),
            findViewById<TextView>(R.id.c3)
        )

        buttonRoll.setOnClickListener {
            roll(linearHorizontalLayout)
            roll(linearVerticalLayout)
            roll(constraintLayout)
        }
    }
}