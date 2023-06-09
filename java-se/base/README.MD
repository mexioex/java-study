# Java 基础学习

## 基本数据类型相关概念

### 各类型变量取值范围,字节长度,与默认值

|   关键字   |        取值范围        | 字节长度 |  默认值  |
|:-------:|:------------------:|:----:|:-----:|
|  byte   |     -2^8~2^8-1     |  1   |   0   |
|  short  |    -2^16~2^16-1    |  2   |   0   |
|  char   |       0~2^16       |  2   |   0   |
|   int   |    -2^32~2^32-1    |  4   |   0   |
|  float  |  - 3.4^38~3.4^38   |  4   | 0.0f  |
|  long   |    -2^64~2^64-1    |  8   |  0L   |
| double  | - 1.8^308~ 1.8^308 |  8   | 0.0d  |
| boolean |     true~false     |  ?   | false |

### 变量运算的细节

- byte,char,short,int加减值的类型为int,因为它们的字节长度都小于int,而且JVM一个槽的长度是4位,所以当这几种类型的变量参与运算之后,都需要强制转换类型
- 短字节长度与高字节长度运算,如果想保留原始类型,必须强制转换,但可能会造成溢出
- 基本类型之间都是可以强制转换的
- 自操作运算符隐含强制类型转换

```
byte b = 1;
b=b++;// 编译错误
b+=1;// 正常运行
```

### i++和++i的区别

- i++是i原本的值先参与运算,i再+1
- ++i是i原本的值先+1,再参与运算

### byte,char,short,int,enum,String

只有这写类型可以用于 switch 表达式,因为 switch 对应的 JVM 指令是 lookupswitch,tableswitch,这些指令只支持 int,String 在
switch 中本质只是一种语法糖,实际是用的 String 的 hashCode

### boolean到底占几个字节

- boolean 逻辑上只占1位即可,实际 JVM 底层没有 boolean 的操作指令,所以按 int 处理
- boolean 变量按 int 处理,boolean 数组按 byte 处理
- 不同的 JVM 实现可能有不同的标准

## 流程控制语句

- switch 中,continue,break,yield无法结束循环