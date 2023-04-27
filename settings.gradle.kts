rootProject.name = "Movie_Mania"

include(":androidApp")
include(":shared")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        id("com.github.gmazzo.buildconfig").version("3.1.0")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
