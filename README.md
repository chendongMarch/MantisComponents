目前组件化通用的方案：

使用一个标记，来决定是不是组件独立运行，如果需要独立运行，则更改 `gradle` 配置为 `application`，然后使用 `manifest.srcFile` 来动态的更改 `AndroidManifest.xml` 来源增加入口 `Activity`，这里又有使用 `buildType` 来存放多个 `Manifest.xml`，或者自己开辟一个新的目录来存放 `Manifest.xml` 等方法。

弊端：

- 多个 `Manifest.xml` 文件公共的部分没办法合并，导致代码重复，`Manifest.xml` 一旦改动，多个地方都要人工同步；
- 违背了 `BuildType` 原本的用途，如果我有自定义的 `BuildType`，比如预发测试专用的 `preTest` 方式，这里将变得非常不合理；
- 对组件的 `build.gradle` 侵入性很大，我们需要在 `module` 中根据配置兼容它作为 `app` 运行或者作为组件运行的两种场景，更有甚者，需要根据这个 `module` 定制一个特殊的字段，比如 `isMusicModuleRun`，这对作为依赖的 `module` 来说是很不友好的，同样 `app` 模块也需要做这些工作，组件的独立和解耦我们是从代码层面上分割开的，而我们希望他能独立运行则主要是为了更容易调试。
- `Application` 的初始化难以管理和同步，为了能独立运行子组件，子组件需要有自己的 `Application`，也要同时去管理他所关联的组件的依赖和初始化，当组件越来越多时，变得难以维护；
- 组件虽然独立运行了，但是编译的组件没有减少，除非我们手动去改 `settings.gradle` 和 `build.gradle` 中依赖的模块，否则这些模块仍然会参加编译过程，并没有显著减少编译的时间；


本方案是针对以上问题，对于组件化的一种尝试，希望通过 `gradle` 脚本来实现组件的动态依赖和编译；

首先我们不再把组件能独立运行作为一个解耦的硬性标准，组件并不是完全独立运行的，组件之间虽然解耦，但是他们都是运行在组件化容器之中；

子组件不再需要去关注 `Manifest.xml`、入口配置等，他还是一个简单的 `module`，组件化容器有一个唯一的入口组件，入口组件十分轻量，它主要负责应用入口页面、应用结构化配置、组件依赖管理等，承担起 `application` 和组件化容器的工作，所有被依赖的子组件都被注入到这个容器当中，当组件单独运行时也同样通过入口组件启动，然后重定向到子业务组件页面中，从而达到组件单独运行的效果；

引入 `.component.json` 文件，作为组件化的配置，包括入口组件，组件依赖列表等，当切换运行状态时，根据配置文件，动态的更改 `settings.gralde` 和 入口组件的 `build.gradle` 达到动态依赖的目的；


## 目录结构


- app 组件化容器及入口
- component_blog 博客组件，独立
- component_main 主页组件
- component_music 音乐组件
- component_biz	业务组件基础，业务相关数据结构、服务、常量、服务等
- component_basic 组件化基础，网络、图片、服务、路由、基础依赖等
- common 公共基础库
- script 脚本文件，主要包含三个重要脚本


## 临时文件

组件化临时文件，跟个人配置有关，应该被忽略掉

- .component.json 配置文件，配置了组件的入口，和组件列表
- .component_config.gradle 组件配置
- .component_deps.gradle 组件动态依赖
- .component_setting.gradle 动态编译配置