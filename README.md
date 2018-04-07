这是一个使用ssm(springMVC、spring、mybatis)搭建一个demo
===
>拉取代码后在mysql数据库执行(ssm-demo\sql)中的sql脚本
  修改 ssm-demo\demo-parent\demo-web\src\main\resources 文件夹中的 jdbc.properties 文件，连接到数据库

>使用 eclipse 导入 maven 项目(ssm-demo\demo-parent)即可直接编译运行

>运行后在浏览器输入
```
  http://localhost/test/list
```
>显示: 
```	
[{"SEX":"0","USER_ID":1,"USER_NAME":"test1"},
{"SEX":"1","USER_ID":2,"USER_NAME":"test2"}]
```

>项目搭建成功

----

### 流程图

```flow
st=>start: 开始
io=>inputoutput: 拉取代码：
    https://github.com/weiyihong/ssm-demo.git
op1=>operation: 执行sql脚本
    ssm-demo\sql
op2=>operation: 导入maven项目到eclipse
op3=>operation: 修改  jdbc.properties 
    ssm-demo\demo-parent\demo-web\src\main\resources
op4=>operation: 编译执行
op5=>condition: 访问
    http://localhost/test/list
sub=>subroutine: 显示
    [{"SEX":"0","USER_ID":1,"USER_NAME":"test1"},
    {"SEX":"1","USER_ID":2,"USER_NAME":"test2"}]
e=>end: 成功

st->io->op1->op2->op3->op4->op5(yes)->sub->e
op5(no)->op1
```