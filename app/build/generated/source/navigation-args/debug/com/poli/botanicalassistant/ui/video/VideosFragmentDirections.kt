package com.poli.botanicalassistant.ui.video

import android.os.Bundle
import androidx.navigation.NavDirections
import com.poli.botanicalassistant.R
import kotlin.Int
import kotlin.String

public class VideosFragmentDirections private constructor() {
  private data class ActionVideosFragmentToVideoPlayerFragment(
    public val videoId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_videosFragment_to_videoPlayerFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("videoId", this.videoId)
        return result
      }
  }

  public companion object {
    public fun actionVideosFragmentToVideoPlayerFragment(videoId: String): NavDirections =
        ActionVideosFragmentToVideoPlayerFragment(videoId)
  }
}
