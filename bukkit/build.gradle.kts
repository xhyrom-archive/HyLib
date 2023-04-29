plugins {
    id("hylib.platform-logic")
}

dependencies {
    api(project(":hylib-common"))
    api("org.bstats:bstats-bukkit:3.0.1")
    api("dev.jorel:commandapi-bukkit-shade:9.0.0")
    api("com.github.retrooper.packetevents:spigot:2.0.0-SNAPSHOT")

    compileOnly("org.jetbrains:annotations:24.0.1")
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}
