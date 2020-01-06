plugins {
  kotlin("multiplatform") version "1.3.61"
}
repositories {
  mavenCentral()
}
kotlin {
  // For ARM, should be changed to iosArm32 or iosArm64
  // For Linux, should be changed to e.g. linuxX64
  // For MacOS, should be changed to e.g. macosX64
  // For Windows, should be changed to e.g. mingwX64
  macosX64("macos") {
    binaries {
      executable {
        entryPoint = "hello.main"
        runTask?.args("")
      }
    }
  }
  sourceSets {
    getByName("macosMain").kotlin.srcDirs("src/macosMain/kotlin")
  }
}

// Use the following Gradle tasks to run your application:
// :runReleaseExecutableMacos - without debug symbols
// :runDebugExecutableMacos - with debug symbols
