val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val mockkVersion: String by project
val nimbusJoseJwtVersion: String by project
val helsearbeidsgiverTokenproviderVersion: String by project

val githubPassword: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jmailen.kotlinter")
    id("maven-publish")
}

group = "no.nav.helsearbeidsgiver"
version = "0.1.3"

tasks {
    test {
        useJUnitPlatform()
    }
}

repositories {
    mavenCentral()
    maven {
        credentials {
            username = "x-access-token"
            password = githubPassword
        }
        setUrl("https://maven.pkg.github.com/navikt/helsearbeidsgiver-tokenprovider")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/navikt/${rootProject.name}")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

dependencies {
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-json:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization:$ktorVersion")
    implementation("com.nimbusds:nimbus-jose-jwt:$nimbusJoseJwtVersion")
    implementation("no.nav.helsearbeidsgiver:helsearbeidsgiver-tokenprovider:$helsearbeidsgiverTokenproviderVersion")

    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-client-mock:$ktorVersion")
}
