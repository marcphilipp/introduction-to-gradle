plugins {
    java
}

val integrationTestSourceSet = sourceSets.create("integrationTest") {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
}

configurations {
    named(integrationTestSourceSet.implementationConfigurationName) {
        extendsFrom(configurations.testImplementation.get())
    }
    named(integrationTestSourceSet.runtimeOnlyConfigurationName) {
        extendsFrom(configurations.testRuntimeOnly.get())
    }
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
