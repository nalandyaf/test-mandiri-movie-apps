package com.test.movie.domain.usecase

import com.test.movie.domain.repository.MovieRepository
import com.test.movie.util.Constants
import com.test.movie.util.Resource
import com.test.movie.util.Type
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetails @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke(type: Type, id: Int): Flow<Resource<Any>> = flow {
        emit(
            when (type) {
                Type.MOVIE -> movieRepository.getMovieDetails(id)
                Type.REVIEW -> movieRepository.getMovieReviewList(id)
                else -> throw IllegalArgumentException(Constants.ILLEGAL_ARGUMENT_DETAIL_TYPE)
            }
        )
    }
}