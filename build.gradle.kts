@file:Suppress("PropertyName", "SpellCheckingInspection")

import io.izzel.taboolib.gradle.App
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("io.izzel.taboolib") version "2.0.19"
    kotlin("jvm") version "1.9.24"
}

subprojects {
    apply<JavaPlugin>()
    apply(plugin = "io.izzel.taboolib")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    // TabooLib 配置
    taboolib {
        env {
            isDebug = false
            install(App)
            // 依赖下载目录
            fileLibs = "libraries"
            // 资源下载目录
            fileAssets = "assets"
        }
        version {
            taboolib = "6.2.0-beta33"
            coroutines = "1.7.3"
            skipKotlinRelocate = true
            skipTabooLibRelocate = true
        }

        classifier = null
    }

    // 全局仓库
    repositories {
        mavenLocal()
        mavenCentral()
    }

    // 全局依赖
    dependencies {
        taboo("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.24") // 添加依赖，要用taboo
        testImplementation(kotlin("test"))
        taboo(kotlin("reflect"))
    }

    // 编译配置
    java {
        withSourcesJar()
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjvm-default=all", "-Xextended-compiler-checks")
        }
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.jar {
        manifest {
            attributes("Main-Class" to "io.github.username.project.AppPlugin") // 主类
            attributes("Description" to "APP多模块示例")
        }
    }
}

gradle.buildFinished {
    buildDir.deleteRecursively()
}
