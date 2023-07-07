package com.test.movie.domain.usecase

import com.test.movie.domain.model.MovieDetail
import com.test.movie.domain.repository.MovieRepository
import com.test.movie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetails @Inject constructor(private val movieRepository: MovieRepository) {

    operator fun invoke(id: Int): Flow<Resource<MovieDetail>> = flow {
        emit(
            movieRepository.getMovieDetails(id)
        )
    }
}