这个项目是自己在工作之余，为了方便收集大数据平台的数据和通过界面展示数据做的一个小工具。

主要是springmvc + hibernate + mysql 为主体。 配合其他一些1框架进行处理数据，事务管理，日志管理，界面展示等功能实现。

目前的功能如下：

1.从源端接收数据Json or XML 然后转为java bean , 通过POI对java bean处理产生excel表格， 或者是通过freemarker 作为view resovler 对java bean进行展示。 
表格展示的话通过bootstrap dataTable，可以对数据进行搜索和分页。
可视化工具选择的是antV而没有选择echars 因为我感觉antv的界面稍微好看一点。

2.数据的持久化是用hibernate 连接mysql 加载和更新数据到mysql . mysql目前使用的是AWS云服务，为以后部署应用提供支撑。

3.web服务器现在选用的是tomcat.

4.事务管理用的spring aop 和aspectJ, 日志管理也可以用spring aop 和aspectJ 这个是下一步的目标。//todo

5.可视化数据打算用ajax来进行前后台数据交互。//todo
