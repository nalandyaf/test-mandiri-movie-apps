package com.test.movie.presentation.screen.moviedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.test.movie.R
import com.test.movie.databinding.FragmentMovieDetailsBinding
import com.test.movie.presentation.adapter.ImageAdapter
import com.test.movie.presentation.adapter.MovieAdapter
import com.test.movie.presentation.adapter.PersonAdapter
import com.test.movie.presentation.adapter.VideoAdapter
import com.test.movie.presentation.base.BaseFragment
import com.test.movie.presentation.screen.youtube.YoutubeFragmentDirections
import com.test.movie.util.Type
import com.test.movie.util.setGenreChips
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment :
    BaseFragment<FragmentMovieDetailsBinding>(R.layout.fragment_movie_details) {

    override val viewModel: MovieDetailViewModel by viewModels()

    val adapterVideos = VideoAdapter {
        findNavController().navigate(YoutubeFragmentDirections.actionGlobalYoutubeFragment(it))
    }
    val adapterCast = PersonAdapter(isCast = true)
    val adapterImages = ImageAdapter()
    val adapterRecommendations = MovieAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manageRecyclerViewAdapterLifecycle(
            binding.rvVideos, binding.rvCast, binding.rvImages, binding.rvRecommendations
        )

        viewModel.initRequest(detailId)

        collectFlows(listOf(::collectDetails, ::collectMovieReviews, ::collectUiState))

    }

    private suspend fun collectDetails() {
        viewModel.details.collect { details ->
            binding.cgGenres.setGenreChips(details.genres, Type.MOVIE, backgroundColor)
            adapterVideos.submitList(details.videos.filterVideos())
            adapterCast.submitList(details.credits.cast)
            adapterImages.submitList(details.images.backdrops)
            adapterRecommendations.submitList(details.recommendations.results)
        }
    }

    private suspend fun collectUiState() {
        viewModel.uiState.collect { state ->
            if (state.isError) showSnackbar(
                message = state.errorText!!, actionText = getString(R.string.button_retry)
            ) {
                viewModel.retryConnection {
                    viewModel.initRequest(id)
                }
            }
        }
    }

    private suspend fun collectMovieReviews() {
        viewModel.movieReviews.collect { movieReviews -> }
    }
}