plugins {
    java
    eclipse
    id("net.minecraftforge.gradle") version ("5.1.+")
    id("org.parchmentmc.librarian.forgegradle") version ("1.+")
    id("org.spongepowered.mixin") version ("0.7-SNAPSHOT")
    `maven-publish`
}

val minecraftVersion: String by project
val mixinVersion: String by project
val forgeVersion: String by project
val modName: String by project
val modAuthor: String by project
val modId: String by project
val mappingsChannel: String by project
val mappingsVersion: String by project


val baseArchiveName = "${modId}-forge-${minecraftVersion}"

base {
    archivesName.set(baseArchiveName)
}

minecraft {
    mappings(mappingsChannel, "${mappingsVersion}-${minecraftVersion}")

    runs {
        create("client") {
            workingDirectory(project.file("run"))
            ideaModule("${rootProject.name}.${project.name}.main")
            taskName("Client")
            property("mixin.env.remapRefMap", "true")
            property("mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")
            mods {
                create(modId) {
                    source(sourceSets.main.get())
                    source(project(":Common").sourceSets.main.get())
                }
            }
        }

        create("server") {
            workingDirectory(project.file("run"))
            ideaModule("${rootProject.name}.${project.name}.main")
            taskName("Server")
            property("mixin.env.remapRefMap", "true")
            property("mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")
            mods {
                create(modId) {
                    source(sourceSets.main.get())
                    source(project(":Common").sourceSets.main.get())
                }
            }
        }
    }
}

sourceSets.main.get().resources.srcDir("src/generated/resources")

// from millions of solutions, this is the only one which works... :-)
val commonTests: SourceSetOutput = project(":Common").sourceSets["test"].output

dependencies {
    minecraft("net.minecraftforge:forge:${minecraftVersion}-${forgeVersion}")
    compileOnly(project(":Common"))

    annotationProcessor("org.spongepowered:mixin:${mixinVersion}:processor")
}

mixin {
    add(sourceSets.main.get(), "${modId}.refmap.json")
    config("${modId}-common.mixins.json")
}

tasks.withType<JavaCompile> {
    source(project(":Common").sourceSets.main.get().allSource)
}

tasks.processResources {
    from(project(":Common").sourceSets.main.get().resources)
}

tasks {
    jar {
        finalizedBy("reobfJar")
    }
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            artifactId = baseArchiveName
            artifact(tasks.jar)
        }
    }

    repositories {
        maven("file://${System.getenv("local_maven")}")
    }
}
