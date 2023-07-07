package com.test.movie.data.repository

import com.test.movie.data.mapper.toMovieDetail
import com.test.movie.data.mapper.toMovieList
import com.test.movie.data.mapper.toMovieReviewList
import com.test.movie.data.remote.api.MovieApi
import com.test.movie.domain.model.MovieDetail
import com.test.movie.domain.model.MovieList
import com.test.movie.domain.model.MovieReviewList
import com.test.movie.domain.repository.MovieRepository
import com.test.movie.util.Resource
import com.test.movie.util.SafeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi, private val safeApiCall: SafeApiCall
) : MovieRepository {
    override suspend fun getMovieList(
        listId: String, page: Int, region: String?
    ): Resource<MovieList> = safeApiCall.execute {
        movieApi.getMovieList(listId = listId, page = page, region = region).toMovieList()
    }

    override suspend fun getMoviesByGenre(genreId: Int, page: Int): Resource<MovieList> =
        safeApiCall.execute {
            movieApi.getMoviesByGenre(genreId = genreId, page = page).toMovieList()
        }

    override suspend fun getMovieSearchResults(query: String, page: Int): Resource<MovieList> =
        safeApiCall.execute {
            movieApi.getMovieSearchResults(query = query, page = page).toMovieList()
        }

    override suspend fun getMovieDetails(movieId: Int): Resource<MovieDetail> =
        safeApiCall.execute {
            movieApi.getMovieDetails(movieId = movieId).toMovieDetail()
        }

    override suspend fun getMovieReviewList(movieId: Int): Resource<MovieReviewList> =
        safeApiCall.execute {
            movieApi.getMovieReviews(movieId).toMovieReviewList()
        }

}