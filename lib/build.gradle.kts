plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.apache.commons:commons-math3")
    implementation("com.google.guava:guava")
    testImplementation("org.junit.jupiter:junit-jupiter")
}
