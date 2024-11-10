package io.github.username.project

import taboolib.platform.App

/**
 * 主类，入口
 */
object AppPlugin {

    @JvmStatic
    fun main(args: Array<String>) {
        App.env().group("io.github.username.project").version("6.2.0-beta33")
        App.init()

        HelloWorld.sendMessage()
    }

}