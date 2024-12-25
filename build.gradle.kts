val kotlin_version: String by project
val logback_version: String by project

val postgresqlDriverVersion = "42.3.1"
val exposedVersion = "0.41.1"

plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"
    id("io.ktor.plugin") version "3.0.0-rc-2"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-config-yaml")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$kotlin_version")
    implementation("io.ktor:ktor-server-content-negotiation:$kotlin_version")
    implementation("io.ktor:ktor-server-auth:$kotlin_version")
    implementation("io.ktor:ktor-server-auth-jwt:$kotlin_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.postgresql:postgresql:$postgresqlDriverVersion")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    implementation("org.flywaydb:flyway-core:9.22.0")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("at.favre.lib:bcrypt:0.9.0")
    implementation("joda-time:joda-time:2.12.5")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.0")
    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
