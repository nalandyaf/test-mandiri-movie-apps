import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id ("androidx.navigation.safeargs.kotlin")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
}

val movieDbKey:String = gradleLocalProperties(rootDir).getProperty("tmdb_api_key")

android {
    namespace = "com.test.movie"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.test.movie"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String","TMDB_API_KEY",movieDbKey)
    }

    buildFeatures {
        buildConfig = true
    }

    dataBinding{
        enable = true
    }



    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isDebuggable = true
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    //Navigation
    implementation (libs.navigation.ktx)
    implementation (libs.navigation.ui)

    //dagger
    implementation (libs.hilt.dagger.android)
    kapt (libs.hilt.dagger.compiler)

    //Coroutines
    implementation (libs.kotlinx.coroutines.android)

    //lifecycle
    implementation (libs.androidx.lifecycle.runtime.ktx)

    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.gson)
    implementation (libs.logging.interceptor)

    //Glide + Glide Transformations
    implementation (libs.glide)
    kapt (libs.glide.compiler)
    implementation(libs.glide.transformations)

    //Palette
    implementation (libs.androidx.palette.ktx)

    //Custom Views
    implementation (libs.photo.view)
    implementation (libs.expandable)
    implementation (libs.youtube.player)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}