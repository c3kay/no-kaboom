# "NoKaboom" MC Spigot/Paper Plugin

Disable explosions in Minecraft without using gamerules.

## Features

The following Explosions can be disabled via a config:

- Creeper
- Fireballs of Ghasts
- Wither Projectiles
- TNT* (including Minecart TNT)
- Endercrystals*

_(*) Explosions enabled by default._

## Contribute

### Build

```shell
./gradlew build
```

The Jar is then available in `build/libs`. Using Gradle plugin [Spigradle](https://github.com/spigradle/spigradle).

### Debug

Starting a PaperMC server with the plugin installed: 

```shell
./gradlew debugPaper
```

or use the generated IntelliJ run config `RunPaper` or `RunSpigot`.
