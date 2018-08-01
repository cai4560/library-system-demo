# library-system-demo
The demo for library system

## Repository
https://github.com/cai4560/library-system-demo

## Environment
+ MySQL Ver 14.14 Distrib 5.7.13
+ Gradle 4.7

## Set Up
+ 启动MySQL，初始化数据的脚本在src/main/resources/migration下
+ 在工程目录下执行gradle wrapper ./gradlew build和./gradlew bootRun
+ 访问localhost:8080即可。

## Comment
+ 涉及到权限的接口需要在请求header加上对应角色的token
+ 前端代码目录在src/main/resources/static下
