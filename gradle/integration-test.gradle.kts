val sourceSets = the<SourceSetContainer>()

val integrationTestSourceSet = sourceSets.create("integrationTest") {
    compileClasspath += sourceSets["main"].output
    runtimeClasspath += sourceSets["main"].output
}

val integrationTestImplementation by configurations.getting {
    extendsFrom(configurations["testImplementation"])
}

configurations.named(integrationTestSourceSet.runtimeOnlyConfigurationName) {
    extendsFrom(configurations["testRuntimeOnly"])
}

tasks {
    val integrationTest by registering(Test::class) {
        description = "Runs the integration tests."
        group = "verification"
        testClassesDirs = integrationTestSourceSet.output.classesDirs
        classpath = integrationTestSourceSet.runtimeClasspath
        mustRunAfter(named("test"))
    }

    named("check").configure {
        dependsOn(integrationTest)
    }
}
