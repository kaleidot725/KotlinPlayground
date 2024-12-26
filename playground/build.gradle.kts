plugins {
    kotlin("jvm") version "2.1.0"
}

group = "jp.kaleidot725.tray.utility"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}