package com.poli.botanicalassistant.ui.about

import com.poli.botanicalassistant.ui.about.model.FeatureOffered
import com.poli.botanicalassistant.ui.about.model.OnAboutUsActionListener

sealed class AboutUsUi(val type: AboutUsType) {

    data object Header : AboutUsUi(AboutUsType.HEADER)

    data class WhatWeOffer(val featuresOffered: List<FeatureOffered>) : AboutUsUi(AboutUsType.WHAT_WE_OFFER)

    data class Actions(val listener: OnAboutUsActionListener) : AboutUsUi(AboutUsType.ACTIONS)

    data object Credits : AboutUsUi(AboutUsType.CREDITS)
}
