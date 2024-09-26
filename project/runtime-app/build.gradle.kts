import io.izzel.taboolib.gradle.*

dependencies {
    // 引入 API
    compileOnly(project(":project:core"))
}

// 子模块
taboolib { subproject = true }