# tools-code-generator

自动生成使用spring、MyBatis、Mysql搭建的web工程代码，支持自定义模板。


## 立即使用

1、进入release\CodeGenerator目录；

2、修改config.properties文件参数配置；

3、执行run.bat，生成代码在target文件夹中；

4、复制target下的文件夹覆盖工程根目录即可。


## 自定义模板

在release\CodeGenerator目录创建文件夹，命名为template_xxx；

修改config.properties中的projectType=xxx；

执行run.bat，工具会使用template_xxx目录下的模板生成代码。
