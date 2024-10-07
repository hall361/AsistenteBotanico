package com.poli.botanicalassistant.ui.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.R
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.lifecycleScope

class VideosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private val videosViewModel: VideosViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        videoAdapter = VideoAdapter(emptyList()) { videoId ->
            val action = VideosFragmentDirections.actionVideosFragmentToVideoPlayerFragment(videoId)
            findNavController().navigate(action)
        }
        recyclerView.adapter = videoAdapter

        swipeRefreshLayout.setOnRefreshListener {
            refreshVideoList()
        }

        videosViewModel.loadVideos()
        viewLifecycleOwner.lifecycleScope.launch {
            videosViewModel.videos.collect { videoList ->
                videoAdapter = VideoAdapter(videoList) { videoId ->
                    val action =
                        VideosFragmentDirections.actionVideosFragmentToVideoPlayerFragment(videoId)
                    findNavController().navigate(action)
                }
                recyclerView.adapter = videoAdapter
            }
        }
    }

    private fun refreshVideoList() {
        videoAdapter.notifyDataSetChanged()
        swipeRefreshLayout.isRefreshing = false
    }
}
