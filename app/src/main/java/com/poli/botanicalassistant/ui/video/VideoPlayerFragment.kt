package com.poli.botanicalassistant.ui.video

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants.PlayerError
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.FragmentVideoPlayerBinding

class VideoPlayerFragment : Fragment() {

    private var _binding: FragmentVideoPlayerBinding? = null
    private val binding get() = _binding!!
    private val args: VideoPlayerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR)
        setupVideoPlayer()
    }

    private fun setupVideoPlayer() {
        with(binding.youtubePlayerView) {
            lifecycle.addObserver(this)
            addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = extractVideoId(args.videoId)
                    loadVideo(videoId, youTubePlayer)
                }

                override fun onError(youTubePlayer: YouTubePlayer, error: PlayerError) {
                    handleVideoError(error)
                }
            })
        }
    }

    private fun loadVideo(videoId: String, youTubePlayer: YouTubePlayer) {
        try {
            youTubePlayer.loadVideo(videoId, 0f)
        } catch (e: Exception) {
            showErrorFeedback(getString(R.string.video_player_error_generic_video))
        }
    }

    private fun handleVideoError(error: PlayerError) {
        when (error) {
            PlayerError.VIDEO_NOT_FOUND -> showErrorFeedback(getString(R.string.video_player_error_video_not_found))
            PlayerError.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER -> showErrorFeedback(getString(R.string.video_player_error_video_not_playable))
            else -> showErrorFeedback(getString(R.string.video_player_error_unexpected))
        }
    }

    private fun setupOrientation(screenOrientation: Int) {
        requireActivity().requestedOrientation = screenOrientation
    }

    private fun showErrorFeedback(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun extractVideoId(videoUrl: String): String {
        return videoUrl.substringAfter("v=").substringBefore("&")
    }

    override fun onDestroy() {
        super.onDestroy()
        setupOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        _binding = null
    }
}
