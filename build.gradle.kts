import java.time.Instant

plugins {
    id("com.gradle.build-scan") version "2.3"
}

buildScan {
    tag("Demo")
    link("GitHub", "https://github.com/marcphilipp/introduction-to-gradle")
    value("location", "Mannheim")
}

tasks.register<Greeting>("helloWorld") {
    recipient.set("World")
}

tasks.register<Greeting>("halloMannheim") {
    message.set("Hallo")
    recipient.set(provider {
        "Mannheim at ${Instant.now()}"
    })
}

subprojects {
    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    configurations.all {
        resolutionStrategy.eachDependency {
            when (requested.name) {
                "commons-math3" -> useVersion("3.6.1")
                "guava" -> useVersion("28.0-jre")
                "spring-boot-dependencies" -> useVersion("2.1.6.RELEASE")
            }
            when (requested.group) {
                "org.junit.jupiter" -> useVersion("5.5.0")
            }
        }
    }
}
