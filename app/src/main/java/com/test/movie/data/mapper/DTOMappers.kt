package com.test.movie.data.mapper

import com.test.movie.data.remote.dto.CompanyDTO
import com.test.movie.data.remote.dto.CountryDTO
import com.test.movie.data.remote.dto.CreditsDTO
import com.test.movie.data.remote.dto.ExternalDTO
import com.test.movie.data.remote.dto.GenreDTO
import com.test.movie.data.remote.dto.ImageDTO
import com.test.movie.data.remote.dto.ImageListDTO
import com.test.movie.data.remote.dto.LanguageDTO
import com.test.movie.data.remote.dto.MovieCreditsDTO
import com.test.movie.data.remote.dto.MovieDTO
import com.test.movie.data.remote.dto.MovieDetailDTO
import com.test.movie.data.remote.dto.MovieListDTO
import com.test.movie.data.remote.dto.PersonDTO
import com.test.movie.data.remote.dto.PersonDetailDTO
import com.test.movie.data.remote.dto.PersonListDTO
import com.test.movie.data.remote.dto.TvCreditsDTO
import com.test.movie.data.remote.dto.TvDTO
import com.test.movie.data.remote.dto.VideoDTO
import com.test.movie.data.remote.dto.VideoListDTO
import com.test.movie.domain.model.Company
import com.test.movie.domain.model.Country
import com.test.movie.domain.model.Credits
import com.test.movie.domain.model.External
import com.test.movie.domain.model.Genre
import com.test.movie.domain.model.Image
import com.test.movie.domain.model.ImageList
import com.test.movie.domain.model.Language
import com.test.movie.domain.model.Movie
import com.test.movie.domain.model.MovieCredits
import com.test.movie.domain.model.MovieDetail
import com.test.movie.domain.model.MovieList
import com.test.movie.domain.model.Person
import com.test.movie.domain.model.PersonDetail
import com.test.movie.domain.model.PersonList
import com.test.movie.domain.model.Tv
import com.test.movie.domain.model.TvCredits
import com.test.movie.domain.model.Video
import com.test.movie.domain.model.VideoList

fun CompanyDTO.toCompany(): Company = Company(
    name = name, originCountry = originCountry
)

fun CountryDTO.toCountry(): Country = Country(
    name = name
)

fun GenreDTO.toGenre(): Genre = Genre(
    id = id, name = name
)

fun ImageDTO.toImage(): Image = Image(
    filePath = filePath
)

fun ImageListDTO.toImageList(): ImageList = ImageList(backdrops = backdrops?.map { it.toImage() },
    posters = posters?.map { it.toImage() },
    profiles = profiles?.map { it.toImage() },
    stills = stills?.map { it.toImage() })

fun LanguageDTO.toLanguage(): Language = Language(
    englishName = englishName
)

fun MovieDTO.toMovie(): Movie = Movie(
    character = character,
    id = id,
    job = job,
    overview = overview,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    voteAverage = voteAverage
)

fun MovieCreditsDTO.toMovieCredits(): MovieCredits =
    MovieCredits(cast = cast.map { it.toMovie() }, crew = crew.map { it.toMovie() })

fun MovieDetailDTO.toMovieDetail(): MovieDetail = MovieDetail(
    budget = budget,
    credits = credits.toCredits(),
    externalIds = externalIds.toExternal(),
    genres = genres.map { it.toGenre() },
    homepage = homepage,
    id = id,
    images = images.toImageList(),
    originalTitle = originalTitle,
    overview = overview,
    posterPath = posterPath,
    productionCompanies = productionCompanies.map { it.toCompany() },
    productionCountries = productionCountries.map { it.toCountry() },
    recommendations = recommendations.toMovieList(),
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toLanguage() },
    status = status,
    title = title,
    videos = videos.toVideoList(),
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun MovieListDTO.toMovieList(): MovieList = MovieList(
    results = results.map { it.toMovie() }, totalResults = totalResults
)

fun VideoDTO.toVideo(): Video = Video(
    key = key, name = name, publishedAt = publishedAt, site = site, type = type
)

fun VideoListDTO.toVideoList(): VideoList = VideoList(results = results.map { it.toVideo() })

fun CreditsDTO.toCredits(): Credits = Credits(cast = cast.map { it.toPerson() },
    crew = crew.map { it.toPerson() },
    guestStars = guestStars?.map { it.toPerson() })

fun PersonDTO.toPerson(): Person = Person(
    character = character,
    department = department,
    id = id,
    job = job,
    knownForDepartment = knownForDepartment,
    name = name,
    profilePath = profilePath
)

fun PersonDetailDTO.toPersonDetail(): PersonDetail = PersonDetail(
    alsoKnownAs = alsoKnownAs,
    biography = biography,
    birthday = birthday,
    deathday = deathday,
    externalIds = externalIds.toExternal(),
    gender = gender,
    homepage = homepage,
    id = id,
    images = images.toImageList(),
    knownForDepartment = knownForDepartment,
    movieCredits = movieCredits.toMovieCredits(),
    name = name,
    placeOfBirth = placeOfBirth,
    profilePath = profilePath,
    tvCredits = tvCredits.toTvCredits()
)

fun PersonListDTO.toPersonList(): PersonList = PersonList(
    results = results.map { it.toPerson() }, totalResults = totalResults
)

fun TvDTO.toTv(): Tv = Tv(
    character = character,
    firstAirDate = firstAirDate,
    id = id,
    job = job,
    name = name,
    overview = overview,
    posterPath = posterPath,
    voteAverage = voteAverage
)

fun TvCreditsDTO.toTvCredits(): TvCredits =
    TvCredits(cast = cast.map { it.toTv() }, crew = crew.map { it.toTv() })

fun ExternalDTO.toExternal(): External = External(
    facebookId = facebookId, imdbId = imdbId, instagramId = instagramId, twitterId = twitterId
)
