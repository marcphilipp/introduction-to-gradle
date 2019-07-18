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
