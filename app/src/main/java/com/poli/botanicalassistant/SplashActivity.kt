package com.poli.botanicalassistant

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 5000 // Duración del splash en milisegundos (5 segundos)
    private lateinit var countdownTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Inicializar el TextView para mostrar el contador
        countdownTextView = findViewById(R.id.countdown_text)

        // Iniciar el contador
        startCountdown()

        // Iniciar la MainActivity después de la duración del splash
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToMainActivity()
        }, SPLASH_TIME_OUT)
    }

    private fun startCountdown() {
        val handler = Handler(Looper.getMainLooper())
        for (i in SPLASH_TIME_OUT / 1000 downTo 1) {
            handler.postDelayed({
                countdownTextView.text = "Loading... $i"
            }, (SPLASH_TIME_OUT / 1000 - i) * 1000L)
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Finaliza la SplashActivity
    }
}
