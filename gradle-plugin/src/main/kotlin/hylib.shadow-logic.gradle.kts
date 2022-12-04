import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("hylib.base-logic")
    id("com.github.johnrengelman.shadow")
}

tasks {
    named<Jar>("jar") {
        archiveClassifier.set("unshaded")
    }
    val shadowJar = named<ShadowJar>("shadowJar") {
        configureRelocations()
    }
    val shadowJarApi = register<ShadowJar>("shadowJarApi") {
        from(sourceSets.main.get().output)
        configurations = listOf(project.configurations.runtimeClasspath.get())

        exclude("kotlin/**")

        configureRelocations()
    }
    named("build") {
        dependsOn(shadowJar)
        dependsOn(shadowJarApi)
    }
}

publishShadowJar()

fun ShadowJar.configureRelocations() {
    // TODO: implement storage drivers
    //relocate("org.sqlite", "me.xhyrom.hylib.libs.sqlite")
    //relocate("com.mysql", "me.xhyrom.hylib.libs.mysql")
    //relocate("org.mariadb", "me.xhyrom.hylib.libs.mariadb")

    relocate("org.bstats", "me.xhyrom.hylib.libs.bstats")
    relocate("dev.dejvokep.boostedyaml", "me.xhyrom.hylib.libs.boostedyaml")
    relocate("dev.jorel.commandapi", "me.xhyrom.hylib.libs.commandapi")

    relocate("com.github.retrooper.packetevents", "me.xhyrom.hylib.libs.packetevents.api")
    relocate("io.github.retrooper.packetevents", "me.xhyrom.hylib.libs.packetevents.impl")
}