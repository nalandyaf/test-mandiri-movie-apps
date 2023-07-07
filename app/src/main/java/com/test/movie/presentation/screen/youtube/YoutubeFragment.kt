package com.test.movie.presentation.screen.youtube

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.test.movie.R
import com.test.movie.databinding.FragmentYoutubePlayerBinding
import com.test.movie.presentation.base.BaseFragment


class YoutubeFragment :
    BaseFragment<FragmentYoutubePlayerBinding>(R.layout.fragment_youtube_player) {
    override val viewModel: YoutubeViewModel by viewModels()

    val args: YoutubeFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(binding.youtubePlayer)
        binding.youtubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(args.youtubeId, 0F)
            }
        })
    }

}