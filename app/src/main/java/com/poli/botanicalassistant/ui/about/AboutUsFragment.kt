package com.poli.botanicalassistant.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.FragmentAboutUsBinding
import com.poli.botanicalassistant.ui.about.model.FeatureOffered
import com.poli.botanicalassistant.ui.about.model.OnAboutUsActionListener
import org.koin.android.ext.android.inject

class AboutUsFragment : Fragment(), OnAboutUsActionListener {

    private var _binding: FragmentAboutUsBinding? = null
    private val binding get() = _binding!!
    private val aboutUsAdapter: AboutUsAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.aboutUsRecycler.adapter = aboutUsAdapter

        val items = listOf(
            AboutUsUi.Header,
            AboutUsUi.WhatWeOffer(buildFeatureOfferedList()),
            AboutUsUi.Actions(this),
            AboutUsUi.Credits
        )

        aboutUsAdapter.submitList(items)
    }

    private fun buildFeatureOfferedList() = listOf(
        FeatureOffered(R.drawable.ic_feature_offered_db, getString(R.string.plant_database_feature)),
        FeatureOffered(R.drawable.ic_feature_offered_care_guide, getString(R.string.plant_care_guidance_feature)),
        FeatureOffered(R.drawable.ic_feature_offered_videos, getString(R.string.video_tutorials_feature)),
        FeatureOffered(R.drawable.ic_feature_offered_web_navigation, getString(R.string.web_navigation_feature))
    )

    override fun goToGarden() {
        navigateToAnyAction(
            R.id.action_nav_about_us_to_nav_garden,
            R.id.mobile_navigation
        )
    }

    override fun goToVideos() {
        navigateToAnyAction(
            R.id.action_nav_about_us_to_nav_videos,
            R.id.nav_about_us
        )
    }

    private fun navigateToAnyAction(
        actionId: Int,
        popUpToId: Int
    ) {
        findNavController().navigate(
            actionId,
            null,
            NavOptions.Builder()
                .setPopUpTo(popUpToId, true)
                .build()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
