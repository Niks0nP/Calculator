plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("jacoco")
    id("com.github.kt3k.coveralls") version "2.12.2"
}

jacoco {
    toolVersion = "0.8.10"
}

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest") // или "test" если не Android

    reports {
        xml.required.set(true)
        html.required.set(true)
    }

    val fileFilter = listOf(
        "**/R.class",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "**/*Test*.*",
        "android/**/*.*"
    )

    val debugTree = fileTree("${buildDir}/intermediates/javac/debug/classes") {
        exclude(fileFilter)
    }

    sourceDirectories.setFrom(files("src/main/java", "src/main/kotlin"))
    classDirectories.setFrom(files(debugTree))
    executionData.setFrom(fileTree(buildDir).include(
        "jacoco/testDebugUnitTest.exec",
        "outputs/unit_test_code_coverage/debugUnitTest/testDebugUnitTest.exec"
    ))
}
tasks.named("coveralls") {
    dependsOn("jacocoTestReport")
    doFirst {
        val report = file("$buildDir/reports/jacoco/jacocoTestReport/jacocoTestReport.xml")
        if (!report.exists()) {
            throw GradleException("Coveralls: Jacoco report not found at ${report.absolutePath}")
        } else {
            println("Coveralls: Found Jacoco report at ${report.absolutePath}")
        }
    }
}

coveralls {
    sourceDirs.addAll(listOf("src/main/kotlin", "src/main/java"))
    jacocoReportPath = file("build/reports/jacoco/jacocoTestReport/jacocoTestReport.xml").absolutePath
}

android {
    namespace = "com.niks0n.calculator"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.niks0n.calculator"
        minSdk = 28
        targetSdk = 35
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation (libs.androidx.lifecycle.viewmodel.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    androidTestImplementation (libs.androidx.runner)
    testImplementation (libs.cucumber.java8)
    testImplementation(libs.cucumber.java)
    testImplementation(libs.cucumber.junit)
}