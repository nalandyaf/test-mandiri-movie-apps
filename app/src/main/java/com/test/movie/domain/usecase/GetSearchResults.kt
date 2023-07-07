package com.test.movie.domain.usecase

import com.test.movie.domain.model.MovieList
import com.test.movie.domain.repository.MovieRepository
import com.test.movie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSearchResults @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke(
        query: String, page: Int
    ): Flow<Resource<MovieList>> = flow {
        emit(
            movieRepository.getMovieSearchResults(query = query, page = page)
        )
    }
}