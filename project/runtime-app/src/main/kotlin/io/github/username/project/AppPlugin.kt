package io.github.username.project

import taboolib.platform.App

/**
 * 主类，入口
 */
object AppPlugin {

    @JvmStatic
    fun main(args: Array<String>) {
        App.init()

        HelloWorld.sendMessage()
    }

}