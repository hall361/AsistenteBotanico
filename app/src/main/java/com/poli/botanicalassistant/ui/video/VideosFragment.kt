package com.poli.botanicalassistant.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.poli.botanicalassistant.databinding.FragmentVideosBinding
import com.poli.botanicalassistant.ui.video.model.VideoUi
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class VideosFragment : Fragment(), OnVideoClickListener {

    private var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!
    private val videosViewModel: VideosViewModel by viewModel()
    private val videoAdapter: VideoAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeVideos()
        configSwipeRefreshLayout()

        videosViewModel.loadVideos()
    }

    private fun observeVideos() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                videosViewModel.videosUiState.collect { state ->
                    when (state) {
                        is VideosUiState.Loading -> binding.swipeRefreshLayout.isRefreshing = true
                        is VideosUiState.Success -> showVideos(state.videos)
                    }
                }
            }
        }
    }

    private fun configSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            videosViewModel.loadVideos()
        }
    }

    private fun showVideos(videos: List<VideoUi>) {
        videoAdapter.submitList(videos)
        binding.swipeRefreshLayout.isRefreshing = false
    }

    private fun setupRecyclerView() {
        videoAdapter.setListener(this)
        binding.recyclerView.apply {
            adapter = videoAdapter
        }
    }

    override fun onVideoClick(video: VideoUi) {
        val action = VideosFragmentDirections.actionVideosFragmentToVideoPlayerFragment(video.serverId)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
