# 什么是内部类

类内部定义的其他类,如B类表示A类的一部分,且B类单独存在没有意义,如人与心脏的关系

## 类的五大成员

- 属性
- 方法
- 构造方法
- 代码块
- 内部类

## 内部类的特点

- 内部类可以直接访问外部类的成员,包括私有
- 外部类要访问内部类的成员,必须创建对象

## 内部类的分类

- 成员内部类
    - 可以被权限修饰符修饰
- 静态内部类
    - 静态内部类是成员内部类的一种
    - 只能访问外部类的静态变量和静态方法
    - 访问非静态的需要创建外部类的对象
- 局部内部类
    - 内部类定义在方法里面
    - 外界无法直接使用,需要在方法内部创建对象使用
    - 该类可以直接访问外部类的成员,也可以访问方法内的局部变量
- 匿名内部类
  - 