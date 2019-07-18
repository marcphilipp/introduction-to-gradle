import java.time.Instant

plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":lib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.0")
}

application {
    mainClassName = "com.example.app.App"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

tasks.create<Zip>("zipSources") {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allJava)
    from(sourceSets.test.get().allJava)
}

val helloWorld by tasks.registering(Greeting::class) {
    message.set("Hello")
    recipient.set("World")
}

tasks.create<Greeting>("halloMannheim") {
    message.set("Hallo")
    recipient.set(provider {
        "Mannheim at ${Instant.now()}"
    })
    dependsOn(helloWorld)
}
