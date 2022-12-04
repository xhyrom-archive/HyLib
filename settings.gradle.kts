pluginManagement {
    includeBuild("gradle-plugin")
}

rootProject.name = "hylib-parent"

sequenceOf(
    "common",
    "bukkit",
).forEach {
    include("hylib-$it")
    project(":hylib-$it").projectDir = file(it)
}