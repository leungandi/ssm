ssm环境DEMO

1.搭建spring+springMVC+mybatis环境demo;

2.使用MAVEN管理jar包;

3.项目访问路径说名:

3.1.http://localhost:8080/springmvc/test/hello---跳转到首页,hello.jsp;

3.2.http://localhost:8080/springmvc/test/error---定义了局部异常,访问此action，因异常,跳转到error.jsp;

3.3.http://localhost:8080/springmvc/user/queryUserById---连接数据库查询用户信息;

3.4.http://localhost:8080/springmvc/test/*---测试访问系统上下文及监听器的方法,具体说明见action中说明;

4.本demo由Andrew完成于2016年6月5日16:49,版本V1.0.0;

v1.0.1-2016-07-16
更新：增加echats插件

1.http://localhost:8080/springmvc/test/echarts---跳转到echats首页
