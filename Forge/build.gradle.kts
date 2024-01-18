val minecraftVersion: String by project
val forgeVersion: String by project
val modId: String by project

plugins {
    id("com.github.johnrengelman.shadow") version ("8.1.1")
}

architectury {
    platformSetupLoomIde()
    forge()
}

loom {
    if (project.findProperty("enableAccessWidener") == "true") { // Optional property for `gradle.properties` to enable access wideners.
        accessWidenerPath.set(project(":Common").loom.accessWidenerPath)
        forge {
            convertAccessWideners.set(true)
            extraAccessWideners.add(loom.accessWidenerPath.get().asFile.name)
        }
        println("Access widener enabled for project ${project.name}. Access widener path: ${loom.accessWidenerPath.get()}")
    }

    forge {
        mixinConfigs("$modId-common.mixins.json")
    }
}

val common by configurations
val shadowCommon by configurations
dependencies {
    // loader
    forge("net.minecraftforge:forge:$minecraftVersion-$forgeVersion")

    // common module
    common(project(":Common", "namedElements")) { isTransitive = false }
    shadowCommon(project(":Common", "transformProductionForge")) { isTransitive = false }
}
