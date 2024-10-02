package com.poli.botanicalassistant.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.FragmentAboutUsBinding

class AboutUsFragment : Fragment() {

    private var _binding: FragmentAboutUsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupWhatOfferDescription()
    }

    private fun setupWhatOfferDescription() {
        val description = getString(R.string.welcome_message) + "\n\n" +
                getString(R.string.plant_database_feature) + "\n" +
                getString(R.string.plant_care_guidance_feature) + "\n" +
                getString(R.string.video_tutorials_feature) + "\n" +
                getString(R.string.web_navigation_feature) + "\n" +
                getString(R.string.mission_statement)
        binding.appFeatures.text = description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
