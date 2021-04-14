
 # **🔥FinalClick🔥** #
 [![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
 [![](https://jitpack.io/v/JackL124/FinalClick.svg)](https://www.jitpack.io/#JackL124/FinalClick)
 [![MinSdk](https://img.shields.io/badge/%20MinSdk%20-%2019%2B%20-f0ad4e.svg)](https://android-arsenal.com/api?level=19)


## aop防快速点击，对业务层无任何侵入，只需添加依赖即可 ###

 ## 为何要使用FinalClick
- FinalClick的宗旨是业务层无需任何代码可实现所有onClick事件防快速点击，任何有代码入侵的防快速点击都是耍流氓！！！
- 除此之外FinalClick同时提供对任何继承自View的视图禁用防快速点击

## Demo
[Download APK-Demo](apk/app-debug.apk)

## 使用步骤

#### 1.aspectjx插件引用
在项目根目录的build.gradle 中依赖AspectJX
```
 dependencies {
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.10'
        }
```
在需要使用的Module build.gradle 中应用插件

```
apply plugin: 'android-aspectjx'
```
如集成aspectjx报错或想了解更多aspectjx相关内容，请移步至[AspectJX](https://github.com/HujiangTechnology/gradle_plugin_android_aspectjx)


#### 2.使用

* ##### 1.在项目根目录的build.gradle 中添加

```
repositories {
       google()
       jcenter()
       maven { url 'https://jitpack.io' }
   }
```

* ##### 2.在app build.gradle 中添加依赖
```
 dependencies {
 	        implementation 'com.github.JackL124:FinalClick:v1.0.0'
 	}
```
* ##### 3.配置全局点击间隔时间
```
ClickUtil.intervalMillis=500
```

至此,项目中所有点击（包涵 接口回调内部类/接口回调实现接口/Lambda表达式/xlm onClick/RecycleView....）均支持防快速点击，是不是简单粗暴话不多！！！

## 禁用防快速点击功能
在某些例如连击、抢红包、刷礼物等业务场景下，我们并不希望被限制快速点击，此时只需调用needQuickClick()即可禁用防快速点击功能
</br>例如：
```
 button.needQuickClick()
```
button即可禁用防快速点击功能

详细用法可参考demo代码</br>
[MainActivity](https://github.com/JackL124/FinalClick/blob/master/app/src/main/java/com/jackl/app/MainActivity.kt)</br>
[RecyclerAdapter](https://github.com/JackL124/FinalClick/blob/master/app/src/main/java/com/jackl/app/RecyclerAdapter.kt)


### 如果觉得的还不错.....欢迎大家Star 👍

## thanks
[AspectJX](https://github.com/HujiangTechnology/gradle_plugin_android_aspectjx)</br>

## License

    Copyright 2015 bingoogolapple

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


