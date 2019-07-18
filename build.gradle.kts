import java.time.Instant

plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.google.guava:guava:27.1-jre")
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

application {
    mainClassName = "com.example.app.App"
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Zip>("zipSources") {
    from(sourceSets["main"].allJava)
    archiveClassifier.set("sources")
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
