package com.poli.botanicalassistant.ui.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.poli.botanicalassistant.databinding.ActivitySplashBinding
import com.poli.botanicalassistant.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playSplashAnimation()
        navigateToMainAfterDelay()
    }

    private fun playSplashAnimation() {
        val translateY = createObjectAnimator(binding.logo, "translationY", 1000f, 0f, 1000)
        val scaleX = createObjectAnimator(binding.logo, "scaleX", 0.5f, 1f, 1000)
        val scaleY = createObjectAnimator(binding.logo, "scaleY", 0.5f, 1f, 1000)

        AnimatorSet().apply {
            playTogether(translateY, scaleX, scaleY)
            start()
        }
    }

    private fun createObjectAnimator(
        target: Any,
        propertyName: String,
        from: Float,
        to: Float,
        duration: Long
    ) = ObjectAnimator.ofFloat(target, propertyName, from, to).apply {
        this.duration = duration
        interpolator = AccelerateDecelerateInterpolator()
    }

    private fun navigateToMainAfterDelay() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val SPLASH_TIME_OUT: Long = 1800
    }
}
