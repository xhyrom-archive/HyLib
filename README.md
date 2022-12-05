<h1 align="center">
  <br>
  <img src="https://github.com/xHyroM/HyLib/blob/main/images/logo.png?raw=true" alt="HyLib logo" width="256">
  <br>
</h1>

<h4 align="center">Source code for HyLib, a paper plugin and powerful library.</h4>

<p align="center">
    <a href="https://bstats.org/plugin/bukkit/HyChat" alt="bstats servers">
        <img src="https://img.shields.io/bstats/servers/16983?color=2fbfc4&style=for-the-badge" />
    </a>
    <a href="https://bstats.org/plugin/bukkit/EcoPets" alt="bstats players">
        <img src="https://img.shields.io/bstats/players/16983?color=2fbfc4&style=for-the-badge" />
    </a>
    <a href="https://discord.gg/kFPKmEKeMS/" alt="Discord">
        <img src="https://img.shields.io/discord/1046534628577640528?label=discord&style=for-the-badge&color=2fbfc4"/>
    </a>
</p>

<div align="center">

  [![Docs](https://github.com/xHyroM/HyLib/blob/main/images/graphic.png?raw=true)](https://discord.gg/kFPKmEKeMS/)

</div>

<br />

<h1>
  Developers
</h1>

```yml
depend:
  - hylib-{platform}
```

### Get jar from repository  
_Gradle:_
```kt
repositories {
  maven("https://repo.jopga.me/releases")
}

dependencies {
  compileOnly("me.xhyrom.hylib:hylib-PLATFORM:VERSION")
}
```

_Maven:_  
```xml
<repository>
  <id>jopgamer-repo-releases</id>
  <name>Hyro - Development</name>
  <url>http://repo.jopga.me/releases</url>
</repository>
```

```xml
<dependency>
  <groupId>me.xhyrom.hylib</groupId>
  <artifactId>hylib-PLATFORM</artifactId>
  <version>VERSION</version>
  <scope>provided</scope>
</dependency>
```
