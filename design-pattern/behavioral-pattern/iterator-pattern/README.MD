# 迭代器模式

## 包含角色

- Iterator 抽象迭代器,定义遍历容器以及返回对象的操作
- Aggregate 抽象容器,对应 Java 中的,java.util.Collection 接口
- ConcreteAggregate 具体容器,可以实现内部不同的结构,但会暴露处理容器的具体迭代器
- ConcreteIterator 具体迭代器,根据每个具体容器必须有一个具体迭代器
