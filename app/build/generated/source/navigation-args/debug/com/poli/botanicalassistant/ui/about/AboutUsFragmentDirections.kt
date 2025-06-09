package com.poli.botanicalassistant.ui.about

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.poli.botanicalassistant.R

public class AboutUsFragmentDirections private constructor() {
  public companion object {
    public fun actionNavAboutUsToNavGarden(): NavDirections =
        ActionOnlyNavDirections(R.id.action_nav_about_us_to_nav_garden)

    public fun actionNavAboutUsToNavVideos(): NavDirections =
        ActionOnlyNavDirections(R.id.action_nav_about_us_to_nav_videos)
  }
}
