plugins {
    `java-library`
    `maven-publish`
}

java {
    javaTarget(17)
    withSourcesJar()
}

tasks {
    processResources {
        filesMatching(listOf("plugin.yml")) {
            expand(
                "name" to project.name,
                "version" to project.version,
                "description" to project.description,
                "author" to "xHyroM#2815"
            )
        }
    }

    javadoc {
        source(rootProject.subprojects.filter { it.plugins.hasPlugin(JavaPlugin::class.java) }.map { it.sourceSets.main.get().allJava })
        classpath = files(rootProject.subprojects.map { it.sourceSets.main.get().compileClasspath })

        title = "HyLib Javadocs"
        options.encoding = Charsets.UTF_8.name()
        (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }
}

tasks.register("javadocJar", Jar::class) {
    dependsOn.add(tasks.javadoc)
    archiveClassifier.set("javadoc")
    from(tasks.javadoc)
}

publishing {
    publications.create<MavenPublication>("mavenJava") {
        groupId = project.group as String
        artifactId = project.name
        version = project.version as String
        from(components["java"])
    }
}