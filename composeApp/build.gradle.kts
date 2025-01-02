import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    kotlin("plugin.serialization") version "1.9.10"
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            freeCompilerArgs += listOf("-Xbinary=bundleId=org.grechka.composeapp")
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation("com.squareup.okhttp3:okhttp:4.11.0")
            implementation(libs.androidx.activity.compose)
            implementation("io.ktor:ktor-utils:2.3.3")
            implementation(libs.voyager.navigator)
            implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-beta15")
            implementation("moe.tlaster:precompose:1.3.13")
        }
        commonMain.dependencies {
            implementation(platform("androidx.compose:compose-bom:2024.12.01"))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
            implementation("io.ktor:ktor-client-core:2.3.1")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.1")
            implementation("io.ktor:ktor-client-logging:2.3.1")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.1")
            implementation("io.ktor:ktor-client-cio:2.3.1")
            implementation("io.ktor:ktor-utils:2.3.4")
            implementation(libs.commons.text)
            implementation(libs.jsoup)
            implementation(libs.precompose)
            val voyagerVersion = "1.1.0-beta02"
            implementation(libs.voyager.navigator)
            implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-beta15")
            implementation("moe.tlaster:precompose:1.3.13")

        }
        iosMain.dependencies{
            implementation("org.jetbrains.compose.runtime:runtime:1.5.0")
            implementation("org.jetbrains.compose.foundation:foundation:1.5.0")
            implementation("org.jetbrains.compose.material:material:1.5.0")
            implementation("org.jetbrains.compose.ui:ui:1.5.0")
            implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-beta15")
        }
    }
}

android {
    namespace = "org.grechka.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.grechka.project"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.navigation.runtime.ktx)
    debugImplementation(compose.uiTooling)
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.material3)
    implementation(libs.androidx.activity.compose)
}


repositories {
    google()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    maven("https://jitpack.io")
}
tasks.register("assembleXCFramework") {
    dependsOn(
        "linkDebugFrameworkIosArm64",
        "linkDebugFrameworkIosX64",
        "linkDebugFrameworkIosSimulatorArm64",
        "linkReleaseFrameworkIosArm64",
        "linkReleaseFrameworkIosX64",
        "linkReleaseFrameworkIosSimulatorArm64"
    )

    doLast {
        val xcFrameworkDir = layout.buildDirectory.dir("XCFrameworks").get().asFile
        xcFrameworkDir.mkdirs()

        exec {
            commandLine(
                "xcodebuild",
                "-create-xcframework",
                "-framework", layout.buildDirectory.file("bin/iosArm64/debugFramework/composeApp.framework").get().asFile.absolutePath,
                "-framework", layout.buildDirectory.file("bin/iosSimulatorArm64/debugFramework/composeApp.framework").get().asFile.absolutePath,
                "-framework", layout.buildDirectory.file("bin/iosX64/debugFramework/composeApp.framework").get().asFile.absolutePath,
                "-framework", layout.buildDirectory.file("bin/iosArm64/releaseFramework/composeApp.framework").get().asFile.absolutePath,
                "-framework", layout.buildDirectory.file("bin/iosSimulatorArm64/releaseFramework/composeApp.framework").get().asFile.absolutePath,
                "-framework", layout.buildDirectory.file("bin/iosX64/releaseFramework/composeApp.framework").get().asFile.absolutePath,
                "-output", xcFrameworkDir.resolve("ComposeApp.xcframework")
            )
        }
    }
}