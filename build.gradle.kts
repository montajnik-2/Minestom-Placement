plugins {
    `kotlin-dsl`
    `maven-publish`
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

var minestomVersion = "42195c536b"
var statesVersion = "e7732512f4"
var utilityVersion = "227252e316"

group = "fr.bretzel.minestom.placement"
version = "1.1.1"

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://jitpack.io")
}

java {
    withSourcesJar()
}

dependencies {
    implementation("com.github.Minestom:Minestom:$minestomVersion")
    implementation("com.github.ALS-Project:Minestom-States:$statesVersion")
    implementation("com.github.ALS-Project:Minestom-Utilities:$utilityVersion")
}

tasks {
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        minimize()
        exclude("com.github.Minestom:Minestom:*")
    }
}

