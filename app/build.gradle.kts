plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":lib"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClassName = "com.example.app.App"
}

tasks.register<Zip>("zipSources") {
    from(sourceSets["main"].allJava)
    archiveClassifier.set("sources")
}
