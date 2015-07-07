J2WBase
===================================
接受不完美的自己，享受不断完善的自己 我们的承诺是，每天都要有进步!

Gradle 版本
-----------------------------------
1.classpath 'com.android.tools.build:gradle:1.2.3'<br />
2.版本 - gradle-2.4-all.zip<br />

新项目引用
-----------------------------------
Project-build.gradle

     buildscript {
         repositories {
             //从中央库里面获取依赖
             jcenter()
         }
         dependencies {
             classpath 'com.android.tools.build:gradle:1.0.0'
         }
     }
     
     allprojects {
         repositories {
             jcenter()
             //远程仓库
             maven { url "https://github.com/J2W/mvn-repo-j2w/raw/master/repository" }
         }
     }

App-build.gradle:
    android {
        //配置信息
        packagingOptions {
        exclude 'META-INF/services/javax.annotation.processing.Processor'
        exclude 'META-INF/LICENSE.txt'
        exclude 'META-INF/NOTICE.txt'
        }
    }

Gradle依赖
-----------------------------------
App-build.gradle:<br />

    compile 'j2w.team.view:base:1.0.1' <br /> //正式版
    
