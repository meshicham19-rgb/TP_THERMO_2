plugins {
    id("com.android.application")
}

android {
    namespace = "ma.uiz.thermo2"
    compileSdk = 34

    defaultConfig {
        applicationId = "ma.uiz.thermo2"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "1.1"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
