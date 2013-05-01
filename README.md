# 我的第一个GitHub项目

这是项目 [DigitalServer](https://github.com/aaron077/DigitalServer) ，
欢迎访问。
这个项目主要想用到Netty和手机终端通信，Netty SocketIO和HTML通信
这个项目主要是服务器端，完成两件事
 * 手机终端和服务端通信
    1：手机终端把把手机号码提交服务器，服务器通过短信网关向用户手机发送验证码。同一号码每天最多提交3次验证（所有终端）。验证码有效时间为2分钟，俩分钟内不准重复提交请求。
	2：游戏结束提交手机号、成绩、终端ID提交至服务器，服务器同时记录时间点。提交的终端ID须与服务器终端管理验证是否存在该终端ID
		如不存在则提示非法操作。
 * 服务端管理
 	1:终端管理。包含属性：终端ID、终端名称、所属单位、地区。支持Excel导入功能
 	2:成绩排名统计
	
## 版本库地址

支持三种访问协议：

* HTTP协议: `https://github.com/aaron077/DigitalServer.git` 。
* Git协议: `git://github.com/aaron077/DigitalServer.git` 。
* SSH协议: `ssh://git@github.com/aaron077/DigitalServer.git` 。

## 克隆版本库

操作示例：

