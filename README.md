����һ��ʹ��ssm(springMVC��spring��mybatis)�һ��demo
===
>��ȡ�������mysql���ݿ�ִ��(ssm-demo\sql)�е�sql�ű�
  �޸� ssm-demo\demo-parent\demo-web\src\main\resources �ļ����е� jdbc.properties �ļ������ӵ����ݿ�

>ʹ�� eclipse ���� maven ��Ŀ(ssm-demo\demo-parent)����ֱ�ӱ�������

>���к������������
```
  http://localhost/test/list
```
>��ʾ: 
```	
[{"SEX":"0","USER_ID":1,"USER_NAME":"test1"},
{"SEX":"1","USER_ID":2,"USER_NAME":"test2"}]
```

>��Ŀ��ɹ�

----

### ����ͼ

```flow
st=>start: ��ʼ
io=>inputoutput: ��ȡ���룺
    https://github.com/weiyihong/ssm-demo.git
op1=>operation: ִ��sql�ű�
    ssm-demo\sql
op2=>operation: ����maven��Ŀ��eclipse
op3=>operation: �޸�  jdbc.properties 
    ssm-demo\demo-parent\demo-web\src\main\resources
op4=>operation: ����ִ��
op5=>condition: ����
    http://localhost/test/list
sub=>subroutine: ��ʾ
    [{"SEX":"0","USER_ID":1,"USER_NAME":"test1"},
    {"SEX":"1","USER_ID":2,"USER_NAME":"test2"}]
e=>end: �ɹ�

st->io->op1->op2->op3->op4->op5(yes)->sub->e
op5(no)->op1
```