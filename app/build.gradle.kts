plugins {
    application
    id("org.sonarqube") version "6.2.0.5505"
    checkstyle
}

group = "io.hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "hutzy_java-project-61")
        property("sonar.organization", "hutzy")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
