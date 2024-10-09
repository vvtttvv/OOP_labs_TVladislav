plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")
    testImplementation(kotlin("test"))
}

// Установка версии JVM для Kotlin
kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(22)) // Устанавливаем JVM версии 22
    }
}

// Установка версии JVM для Java
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22)) // Устанавливаем ту же версию JVM для Java
    }
}

tasks.test {
    useJUnitPlatform()
}
