plugins {
    java
    application
    `integration-test`
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":lib"))
    implementation(platform("org.springframework.boot:spring-boot-dependencies"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.junit.jupiter:junit-jupiter")
    integrationTestImplementation("org.springframework.boot:spring-boot-starter-test")
}

application {
    mainClassName = "com.example.app.App"
}

tasks.register<Zip>("zipSources") {
    from(sourceSets["main"].allJava)
    archiveClassifier.set("sources")
}
