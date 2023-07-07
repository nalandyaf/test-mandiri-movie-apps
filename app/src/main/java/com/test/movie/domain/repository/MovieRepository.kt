package com.test.movie.domain.repository

import com.test.movie.domain.model.MovieDetail
import com.test.movie.domain.model.MovieList
import com.test.movie.util.Resource

interface MovieRepository {
    suspend fun getMovieList(listId: String, page: Int, region: String?): Resource<MovieList>
    suspend fun getMoviesByGenre(genreId: Int, page: Int): Resource<MovieList>
    suspend fun getMovieSearchResults(query: String, page: Int): Resource<MovieList>
    suspend fun getMovieDetails(movieId: Int): Resource<MovieDetail>

}