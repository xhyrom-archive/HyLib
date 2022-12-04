plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.ajoberstar.grgit", "grgit-core", "5.0.0")
    implementation("gradle.plugin.com.github.johnrengelman", "shadow", "7.1.2")
}