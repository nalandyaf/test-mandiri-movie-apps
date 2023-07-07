<h1 align="center">Test Mandiri - Movie Apps</h1>

<p align="center">
A movie app that implements <b>MVVM</b> design pattern by following the <b>clean architecture</b> principles, using 
  <a href="https://www.themoviedb.org/">TMDB API</a>.
</p>

## ✨ Features
### 🔸 Project Features
- Written in [Kotlin](https://kotlinlang.org/)
- Implementing MVVM design pattern with Android Architecture Components
- Implementing single-activity architecture
- Following clean architecture principles[*](https://github.com/bbor98/movieapp-mvvm-clean-architecture#-note)
- Dependency injection with [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- Consuming a [REST API](https://www.themoviedb.org/documentation/api)
- Safe API call with [Retrofit](https://github.com/square/retrofit) & [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) with the help of `Sealed Class`
- Caching API response with [`OkHttpClient`](https://square.github.io/okhttp/4.x/okhttp/okhttp3/-ok-http-client/)
- Observing data changes and updating the UI state with [`StateFlow`](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/)
- Lifecycle-aware `RecyclerView` & `ViewPager2` adapters with util classes that implements [`DefaultLifecycleObserver`](https://developer.android.com/reference/androidx/lifecycle/DefaultLifecycleObserver)
- Easing the binding process and handling common operations with base classes (`BaseActivity`, `BaseFragment`, and `BaseViewModel`)
- Handling common view logic with [`BindingAdapter`](https://developer.android.com/topic/libraries/data-binding/binding-adapters)
- Infinite scrolling with the help of `RecyclerView.OnScrollListener` (no paging library used)
- ViewPager2 auto sliding functionality with the help of `Handler` & `Runnable`
- Detecting and fixing leaks with [LeakCanary](https://github.com/square/leakcanary)

## 🔑 Prerequisite
To build the project successfully, you need to get your [TMDB API key](https://developers.themoviedb.org/3/getting-started/introduction) and add a new line in the `local.properties` file as shown below.
```
tmdb_api_key=Your_TMDB_API_Key
```

The project separated into three main layers:
- Data
- Presentation
- Domain

### 🔸 Data
Data layer contains application data that are fetched from either the network source or the local database.

Consists of four packages:
- `local` contains *Room* components to fetch data from the local database
- `mapper` contains mapping functions to map DTOs(Data Transfer Objects) and database entities to domain models
- `remote` contains *Retrofit* components to fetch data from the network source
- `repository` contains **implementations** of repository interfaces that are defined in the domain layer

### 🔸 Presentation
Presentation layer is responsible for displaying application data on the screen. It contains  UI elements that render the data on the screen and ViewModel classes that store and manage data in a lifecycle-conscious way.

Consists of two packages:
- `adapter` contains RecyclerView & ViewPager2 adapter classes
- `ui` contains Activities & Fragments with their corresponding ViewModel classes

### 🔸 Domain
Domain layer is the central layer of the project. This layer is a bridge between the data layer and the presentation layer-it retrieves data from the data layer and exposes it to the presentation layer. This layer is independent of other layers-any changes in other layers don't affect this layer.

Consists of three packages:
- `model` contains data classes that hold the data retrieved from the data layer to be used later on in the presentation layer to expose it to UI
- `repository` contains repository **interfaces** to abstract the domain layer from the data layer
- `usecase` contains use cases(interactors) that handle the business logic, which are reused by multiple ViewModels

## 📚 Libraries
- [Jetpack](https://developer.android.com/jetpack) libraries
  - [Navigation](https://developer.android.com/guide/navigation) - Handling navigation between destinations within the app
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Handling lifecycles with lifecycle-aware component
  - [DataBinding](https://developer.android.com/topic/libraries/data-binding) - Binding UI components in layouts to data sources using a declarative format
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Storing and managing UI-related data in a lifecycle-conscious way
  - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Injecting dependencies
  - [Room](https://developer.android.com/training/data-storage/room) - Constructing SQLite database more easily
  - [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - Persisting the key-value pairs or typed objects with protocol buffers
  - [Palette](https://developer.android.com/training/material/palette-colors) - Extracting prominent colors from images
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - Allowing asynchronous programming with Kotlin
- [Retrofit](https://github.com/square/retrofit) - Interacting with the REST API
- [OkHttp](https://github.com/square/okhttp) - Implementing interceptors
- [Gson](https://github.com/google/gson) - Converting JSON to Kotlin data class
- [Glide](https://github.com/bumptech/glide) - Loading and caching images
- [Glide Transformations](https://github.com/wasabeef/glide-transformations) - Providing image transformations for Glide
- [PhotoView](https://github.com/Baseflow/PhotoView) - Implementing zoom functionality to ImageView
- [ExpandableLayout](https://github.com/cachapa/ExpandableLayout) - Animating the expansion and collapse of its child views
- [YouTube Android Player](https://github.com/PierfrancescoSoffritti/android-youtube-player) - Playing YouTube video in app


