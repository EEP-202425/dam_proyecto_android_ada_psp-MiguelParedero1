pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application")      version "8.8.0"
        id("org.jetbrains.kotlin.android") version "2.0.0"
        id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
        id("org.jetbrains.kotlin.plugin.compose")       version "2.0.0"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT) // o FAIL_ON_PROJECT_REPOS si ya lo cambiaste
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AlquilerCoches"
include(":app")
