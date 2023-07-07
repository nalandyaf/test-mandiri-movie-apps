package com.test.movie.data.remote.api

import com.test.movie.data.remote.dto.MovieDetailDTO
import com.test.movie.data.remote.dto.MovieListDTO
import com.test.movie.data.remote.dto.MovieReviewListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{list_id}")
    suspend fun getMovieList(
        @Path("list_id") listId: String, @Query("page") page: Int, @Query("region") region: String?
    ): MovieListDTO

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("with_genres") genreId: Int, @Query("page") page: Int
    ): MovieListDTO

    @GET("search/movie")
    suspend fun getMovieSearchResults(
        @Query("query") query: String, @Query("page") page: Int
    ): MovieListDTO

    @GET("movie/{movie_id}?&append_to_response=credits,videos,images,recommendations,external_ids")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): MovieDetailDTO

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviews(@Path("movie_id") movieId: Int): MovieReviewListDTO
}