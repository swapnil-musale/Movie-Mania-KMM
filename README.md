# Movie Mania
The Movie Mania is simple Movie app which build using **Kotlin Multiplatform Mobile**

| Platforms | ![](https://img.shields.io/badge/Android-black.svg?style=for-the-badge&logo=android) ![](https://img.shields.io/badge/iOS-black.svg?style=for-the-badge&logo=apple)  |
|-----------|---|

### How does it work?

It fetch free movie data from [TMDB](https://www.themoviedb.org/). App uses the Compose for Android and SwiftUi for iOS to render the UI.

### Screenshots
### Android App

<table style="width:100%">
  <tr>
    <th>Movie List Screen</th>
    <th>Movie Details Screen</th> 
  </tr>
  <tr>
    <td><img src = "https://user-images.githubusercontent.com/125433713/235070368-3f8c21cf-a9c8-4d14-9abd-e0200a2116d8.png" width=250/></td> 
    <td><img src = "https://user-images.githubusercontent.com/125433713/235070726-aa9ed645-8bb3-47f3-b7dc-7238a5b88539.png" width=250/></td>
  </tr>
</table>

### iOS App

<table style="width:100%">
  <tr>
    <th>Movie List Screen</th>
    <th>Movie Details Screen</th> 
  </tr>
  <tr>
    <td><img src = "https://user-images.githubusercontent.com/125433713/235072281-f76256ae-80bc-4a33-9f28-5bd6905c2adb.png" width=250/></td> 
    <td><img src = "https://user-images.githubusercontent.com/125433713/235072293-4fee6736-a8ff-4560-974a-9037feb68313.png" width=250/></td>
  </tr>
</table>


## Built with

- [Kotlin](kotlinlang.org) : Programming language
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) : To host the common bussiness logic of Android and iOS app.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) : Android App UI built using Jetpack Compose.
- [Android Navigation](https://developer.android.com/jetpack/compose/navigation): Navigation framework for Android.
- [Swift UI](https://developer.apple.com/xcode/swiftui/) : iOS App UI built using Swift UI.
- [iOS Navigation](https://developer.apple.com/documentation/swiftui/navigationstack) : Navigation framework for iOS.
- [DI](https://insert-koin.io/) : Koin used for Dependency Injection.
- [Networking](https://ktor.io/) : Ktor used for network calls.


## Project structure

This Compose Multiplatform project includes three modules:

### shared
This is a Kotlin module that contains the common logic for both Android and iOS applications, the code you share between platforms.
This shared module contains ViewModel, Network related common code.

### androidApp
This androidApp module is used to write android UI in Jetpack Compose.

### iosApp
This iosApp module is used to write ios app UI in Swift UI.

## How to run the app
This project use Android Studio Flamingo | 2022.2.1 .

Generate API key from [TMDB API](https://developers.themoviedb.org/3), place the key in 'local.properties' file as API_KEY=<YOUR_API_KEY>

## License
 ```
 Copyright 2023 Swapnil Musale

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   ```
