# CineVault

Kotlin Multiplatform App built with [TMDB Client](https://www.themoviedb.org/)


# Technologies Used
Kotlin, Jetpack Compose, Coroutines, Flow, Ktor, Navigation3

# Android App Screen shots
<img alt="Home Page" src="https://github.com/user-attachments/assets/852d6859-6b57-46ad-9da8-39aab404aff7" width="300"/>
<img alt="Explore Page" src="https://github.com/user-attachments/assets/24e44a7a-012f-4afc-847a-8dcf41007808" width="300"/>
<img alt="Explore Details" src="https://github.com/user-attachments/assets/d6aa5112-29e2-42f0-8fcc-180d9df42928" width="300"/>

# iOS App Screen shots
<img alt="Home Page" src="https://github.com/user-attachments/assets/18cc4814-dd48-423b-a1fc-c14a20ab8750" width="300" height="720"/>
<img alt="Explore Page" src="https://github.com/user-attachments/assets/2f4b8d42-f455-4dea-b2a1-f127e3c4c7ce" width="300" height="720"/>
<img alt="Explore Details" src="https://github.com/user-attachments/assets/7c1006f3-fa45-473d-a0f6-37e884b89a6d" width="300" height="720"/>


This is a Kotlin Multiplatform project targeting Android, iOS.

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug

  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…


