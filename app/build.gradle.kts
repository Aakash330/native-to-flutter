plugins {
    alias(libs.plugins.android.application)
}



android {
    namespace = "com.hellodoctor.nativetoflutter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hellodoctor.nativetoflutter"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        create("profile") {
            initWith(getByName("debug"))
        }


    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    configurations {
        getByName("profileImplementation") {
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(fileTree(mapOf("dir" to "../libs", "include" to listOf("*.jar","*.aar"))))
    //implementation(files("../libss/demo.aar"))
   // implementation(project(":libss"))

    debugImplementation ("com.example.my_flutter_two:flutter_debug:1.0")
    add("profileImplementation", "com.example.my_flutter_two:flutter_profile:1.0")
    releaseImplementation ("com.example.my_flutter_two:flutter_release:1.0")

}