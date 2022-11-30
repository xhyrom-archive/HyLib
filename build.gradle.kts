import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java-library")
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    kotlin("jvm") version "1.6.21"
    application
}

group = "me.xhyrom.hylib"
version = "0.1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
    implementation("dev.jorel:commandapi-shade:8.5.1")
    implementation("dev.dejvokep:boosted-yaml:1.3")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<ShadowJar> {
    relocate("dev.jorel.commandapi", "me.xhyrom.hylib.libs.commandapi")
    relocate("dev.dejvokep.boostedyaml", "me.xhyrom.hylib.libs.boostedyaml")

    exclude("LICENSE")
}

tasks.register<ShadowJar>("buildApi") {
    from(sourceSets.main.get().output)
    configurations = listOf(project.configurations.runtimeClasspath.get())

    relocate("dev.jorel.commandapi", "me.xhyrom.hylib.libs.commandapi")
    relocate("dev.dejvokep.boostedyaml", "me.xhyrom.hylib.libs.boostedyaml")

    exclude("LICENSE")
    exclude("kotlin/**")

    archiveFileName.set("${project.name}-${project.version}-api.jar")
}

tasks.named("build") { finalizedBy("buildApi") }

application {
    mainClass.set("me.xhyrom.hylib.HyLibPlugin")
}