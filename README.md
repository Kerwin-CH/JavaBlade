
# 1月24日 更新

- 添加接口Token 认证

------------------------------------------

说明:值得注意的是，Android 访问api和浏览器不同。无法通过接口保持会话（sessionId未设置）
未防止滥用，需要通过接口获取token保持在app内部。每次访问带上token值。

另外可以设置token的过期时间 比如在token后面加上时间戳 如果token的时间戳大于某个时间，token过期需要重新获取。


# 项目描述

如何从app开发变成后台开发?从选择一个合适的web框架开始吧。
使用[balde](https://github.com/lets-blade/blade)框架开发api，并使用androidstudio 开发了一个简单记事本。实现了简单的crud。


# 使用方式

- 运行服务器  api_project下的Application.java
- 修改app_priject 的 ApiConstants 的 服务器地址
- 编译运行App 

- api 文档地址 /doc



# APP 截图
 <img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/001.jpg" width = "400" height = "680" alt="图片名称" align=center />

<img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/002.jpg" width = "400" height = "680" alt="图片名称" align=center />

<img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/003.jpg" width = "400" height = "680" alt="图片名称" align=center />

<img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/004.jpg" width = "400" height = "680" alt="图片名称" align=center />

<img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/005.jpg" width = "400" height = "680" alt="图片名称" align=center />

# 服务器截图

<img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/006.png" width = "800" height = "480" alt="图片名称" align=center />

<img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/007.png" width = "800" height = "480" alt="图片名称" align=center />



# API文档 截图

<img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/008.png" width = "800" height = "480" alt="图片名称" align=center />

<img src="https://github.com/HuRuWo/LearnRESTfulApi/blob/master/sceen_img/009.png" width = "800" height = "480" alt="图片名称" align=center />



# 其他

项目只是抛砖引玉，功能不复杂。

相关博客文章
[APP接口开发的入门指南](https://www.jianshu.com/p/18c8690f3188)
个人主页
[五谷观精分道长](https://www.jianshu.com/u/d84f93a917c2)


# 感谢

- [blade](https://github.com/lets-blade/blade)
- [swagger可视化编辑工具](http://www.sosoapi.com)
- [swagger编辑工具](http://editor.swagger.io/)