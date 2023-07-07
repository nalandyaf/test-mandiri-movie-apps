package com.test.movie.di

import com.test.movie.data.repository.MovieRepositoryImpl
import com.test.movie.domain.repository.MovieRepository
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Singleton
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMovieRepository(repository: MovieRepositoryImpl): MovieRepository
}