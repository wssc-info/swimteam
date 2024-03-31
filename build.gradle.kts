plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-text
    implementation("org.apache.commons:commons-text:1.11.0")
    // https://mvnrepository.com/artifact/commons-beanutils/commons-beanutils
    implementation("commons-beanutils:commons-beanutils:1.9.4")

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    //implementation("org.slf4j:slf4j-api:2.0.12")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api
    implementation("org.apache.logging.log4j:log4j-api:2.23.1")

    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.23.1")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")

    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

}

tasks.test {
    useJUnitPlatform()
}