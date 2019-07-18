plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("integration-test") {
            id = "integration-test"
            implementationClass = "IntegrationTestPlugin"
        }
    }
}
