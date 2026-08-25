plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "stopwatch.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        jsMain.dependencies {
            implementation(project(":shared"))
            implementation(compose.html.core)
            implementation(compose.runtime)
        }
    }
}
