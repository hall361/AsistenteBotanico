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
import com.poli.botanicalassistant.domain.video.Video
import com.poli.botanicalassistant.domain.video.VideoType
import androidx.navigation.fragment.findNavController

class VideosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

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

        videoAdapter = VideoAdapter(getVideoList()) { videoId ->
            val action = VideosFragmentDirections.actionVideosFragmentToVideoPlayerFragment(videoId)
            findNavController().navigate(action)
        }
        recyclerView.adapter = videoAdapter

        swipeRefreshLayout.setOnRefreshListener {
            refreshVideoList()
        }
    }

    private fun refreshVideoList() {
        videoAdapter.notifyDataSetChanged()
        swipeRefreshLayout.isRefreshing = false
    }

    private fun getVideoList(): List<Video> {
        return listOf(
            Video(
                id = "BA01",
                videoName = "Cómo cuidar tus orquídeas",
                creationDate = "2022-12-14",
                duration = 130,
                category = listOf(VideoType.TUTORIAL),
                author = "The Home Depot México",
                serverId = "https://www.youtube.com/watch?v=HlpFuis3kfE",
                imageUrl = "https://img.youtube.com/vi/HlpFuis3kfE/0.jpg"
            ),
            Video(
                id = "BA02",
                videoName = "Cultivo y cuidado de los Cuernos o Helechos",
                creationDate = "2016-05-20",
                duration = 1134,
                category = listOf(VideoType.TUTORIAL, VideoType.INFO),
                author = "TvAgro",
                serverId = "https://www.youtube.com/watch?v=GqUi41a1IaQ",
                imageUrl = "https://img.youtube.com/vi/GqUi41a1IaQ/0.jpg"
            ),
            Video(
                id = "BA03",
                videoName = "Como cuidar un cafeto en casa",
                creationDate = "2016-02-27",
                duration = 303,
                category = listOf(VideoType.TUTORIAL),
                author = "Café Kinetic",
                serverId = "https://www.youtube.com/watch?v=JE82zoYVwwo",
                imageUrl = "https://img.youtube.com/vi/JE82zoYVwwo/0.jpg"
            ),
            Video(
                id = "BA04",
                videoName = "TOP 8 Plantas SUCULENTAS para INTERIOR (muy resistentes)",
                creationDate = "2023-02-15",
                duration = 1031,
                category = listOf(VideoType.INFO, VideoType.OTHER),
                author = "Azaregram",
                serverId = "https://www.youtube.com/watch?v=9lTCSjNa8yI",
                imageUrl = "https://img.youtube.com/vi/9lTCSjNa8yI/0.jpg"
            )
        )
    }
}
