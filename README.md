一、什么是MVP
    MVP是一种项目架构设计模式
    其实MVP的本质就是将View和Model完全隔离出来，通过Presenter统一调度管理
    例如：找房子（租房）  房东（Model）  中介（Presenter）   自己（View）
    数据流程原理：我们的UI要从网络获取数据，那么首先你得通过Presenter中介，
    然后中介通知Model获取网络数据，放回给Presenter，Presenter通知View，更新手机界面

二、MVP的含义？
    M：就是我们的数据（包括：数据库，文件，网络）
    V：我们的UI界面（Activity、Fragment、视图）
    P：调度者


三、项目主页架构搭建
    1、搭建MVP项目架构----技术总监---
        第一步：定义MVP架构包
        第二部：项目模块划分，包的定义
        第三部：定义我们自己的基类

    2、实现主页Tab主框架 ---  UI架构
        （1）分析主框架结构
        （2）在项目实现主页Tab(MainActivity)
        （3）实现Tab基本页面显示
        （4）给每个Tab页加上一个ToolBar










