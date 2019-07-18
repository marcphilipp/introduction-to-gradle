import java.time.Instant

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
}
