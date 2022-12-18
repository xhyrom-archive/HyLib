plugins {
    id("hylib.platform-logic")
}

dependencies {
    api(project(":hylib-common"))
    api("org.bstats:bstats-bukkit:3.0.0")
    api("dev.jorel:commandapi-shade:8.7.0")
    api("com.github.retrooper.packetevents:spigot:2.0.0-20221215.205426-101")

    compileOnly("org.jetbrains:annotations:23.0.0")
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}