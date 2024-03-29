plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}

android {
    namespace = "com.example.gamedoc"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.example.gamedoc"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    val BASE_URL = "https://29ea-114-141-92-36.ngrok-free.app"
//    val BASE_URL = "https://84d8c3a5-117b-49d8-a01f-6627c2f80d9f.mock.pstmn.io"

    buildTypes {
        debug{
            buildConfigField("String","BASE_URL","\"$BASE_URL/api/\"")
        }


        getByName("release"){
            buildConfigField("String","BASE_URL","\"$BASE_URL/api/\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val squareupVersion = "2.9.0"
    val lifecyleVersion = "2.6.2"

    implementation("io.coil-kt:coil-compose:1.4.0") // Sesuaikan dengan versi terbaru yang tersedia

    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Retrofit and okHttp
    implementation("com.squareup.retrofit2:retrofit:$squareupVersion")
    implementation("com.squareup.retrofit2:converter-gson:$squareupVersion")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    // Coroutines and viewmode library
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecyleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecyleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecyleVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    //  google icons library
    implementation("androidx.compose.material:material-icons-extended")

    // data store
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Jepatck Navigation
    implementation("androidx.navigation:navigation-compose:2.7.5")

    //coil
    implementation("io.coil-kt:coil-compose:2.4.0")
}