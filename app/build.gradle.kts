import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation ("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testImplementation ("org.junit.platform:junit-platform-suite:1.8.1")
    testImplementation ("org.skyscreamer:jsonassert:1.5.1")
    implementation ("info.picocli:picocli:4.7.0")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.8.9")
    implementation ("io.vertx:vertx-core:3.5.3")
    testImplementation ("org.assertj:assertj-core:3.24.2")
    implementation ("org.slf4j:slf4j-simple:2.0.5")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.4")
    implementation ("commons-io:commons-io:2.6")
}

application { mainClass.set("hexlet.code.App") }

repositories { mavenCentral() }
tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }