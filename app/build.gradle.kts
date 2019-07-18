plugins {
    java
    application
}

repositories {
    jcenter()
}

val integrationTestSourceSet = sourceSets.create("integrationTest") {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
}

val integrationTestImplementation by configurations.getting {
    extendsFrom(configurations.testImplementation.get())
}

configurations.named(integrationTestSourceSet.runtimeOnlyConfigurationName) {
    extendsFrom(configurations.testRuntimeOnly.get())
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

tasks {
    val integrationTest by registering(Test::class) {
        description = "Runs the integration tests."
        group = "verification"
        testClassesDirs = integrationTestSourceSet.output.classesDirs
        classpath = integrationTestSourceSet.runtimeClasspath
        mustRunAfter(test)
    }

    check {
        dependsOn(integrationTest)
    }
}
