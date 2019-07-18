plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":lib"))
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
