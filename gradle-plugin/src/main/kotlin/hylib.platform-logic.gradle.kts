import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("hylib.shadow-logic")
}

tasks {
    shadowJar {
        archiveFileName.set("HyLib-${project.name.substringAfter("hylib-").capitalize()}-${project.version}-plugin.jar")
        destinationDirectory.set(rootProject.layout.buildDirectory.dir("libs"))
    }
    named<ShadowJar>("shadowJarApi") {
        archiveFileName.set("HyLib-${project.name.substringAfter("hylib-").capitalize()}-${project.version}.jar")
        destinationDirectory.set(rootProject.layout.buildDirectory.dir("libs"))
    }
}