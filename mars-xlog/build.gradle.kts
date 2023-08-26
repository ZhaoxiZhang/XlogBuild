plugins {
    id("com.android.library")
}

android {
    namespace = "com.tencent.mars.xlog"
    compileSdk = 33
    ndkVersion = "20.1.5948944"

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ndk {
            abiFilters.addAll(mutableListOf("armeabi-v7a","arm64-v8a"))
        }

//        externalNativeBuild {
//            cmake {
//                cppFlags.addAll(mutableListOf("-fexceptions", "-fno-rtti"))
//                arguments.add("-DANDROID_STL=c++_shared")
//            }
//        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    externalNativeBuild {
        cmake {
            // 指定CMake编译配置文件路径
            path = file("src/main/cpp/mars/CMakeLists.txt")
        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}