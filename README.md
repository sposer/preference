# preference

方便使用PreferenceFragmentCompat

## 使用

1. 确保repositories中有`mavenCentral()`，如：

    ``` java
    repositories {
        ...
        mavenCentral()
        ...
    }
    
    ```

2. 在子目录的build.gradle中添加：

    ``` java
    dependencies {
        //添加的
        implementation "androidx.preference:preference-ktx:1.2.0"
        implementation "top.heue.utils:preference:1.1.0"
    }
    ```

3. 点击`Sync Now`等待完成
