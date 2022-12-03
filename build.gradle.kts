import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java-library")
    id("java")
    id("maven-publish")
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
    maven("https://repo.codemc.io/repository/maven-snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")

    implementation("dev.jorel:commandapi-shade:8.5.1")
    implementation("dev.dejvokep:boosted-yaml:1.3")
    implementation("com.github.retrooper.packetevents:spigot:2.0.0-SNAPSHOT")
    implementation("org.bstats:bstats-bukkit:3.0.0")
}

tasks.withType<ShadowJar> {
    relocate("dev.jorel.commandapi", "me.xhyrom.hylib.libs.commandapi")
    relocate("dev.dejvokep.boostedyaml", "me.xhyrom.hylib.libs.boostedyaml")
    relocate("org.bstats", "me.xhyrom.hylib.libs.bstats")

    relocate("com.github.retrooper.packetevents", "me.xhyrom.hylib.libs.packetevents.api")
    relocate("io.github.retrooper.packetevents", "me.xhyrom.hylib.libs.packetevents.impl")

    exclude("LICENSE")
}

tasks.register<ShadowJar>("buildApi") {
    mustRunAfter("jar")

    from(sourceSets.main.get().output)
    configurations = listOf(project.configurations.runtimeClasspath.get())

    relocate("dev.jorel.commandapi", "me.xhyrom.hylib.libs.commandapi")
    relocate("dev.dejvokep.boostedyaml", "me.xhyrom.hylib.libs.boostedyaml")
    relocate("org.bstats", "me.xhyrom.hylib.libs.bstats")

    relocate("com.github.retrooper.packetevents", "me.xhyrom.hylib.libs.packetevents.api")
    relocate("io.github.retrooper.packetevents", "me.xhyrom.hylib.libs.packetevents.impl")

    exclude("LICENSE")
    exclude("kotlin/**")

    archiveFileName.set("${project.name}-${project.version}.jar")
}

tasks.build {
    dependsOn(tasks.getByName("shadowJar"), tasks.getByName("buildApi"))
}

application {
    mainClass.set("me.xhyrom.hylib.HyLibPlugin")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

artifacts {
    archives(tasks.getByName("shadowJar"))
    archives(tasks.getByName("buildApi"))
}