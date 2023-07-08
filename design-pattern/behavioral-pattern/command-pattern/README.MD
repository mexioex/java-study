# 命令行模式

当需要开发一个复杂的程序,例如用来绘制点,线,线段,圆,矩形等,为了实现此功能需要很多 if-else 判断,此时可以使用命令行模式优化,通过一个
receiver 接受命令,调用命令执行,且 receiver 可以切换不同的命令行

## 适用场景

- Undo/Redo operation: 命令行模式允许将命令对象存储在队列中,实现撤销或重做
- Composite Command 组合命令: 由简单命令组合成复杂命令,这种方式可以通过面向对象的方式构建宏
- The asynchronous design invocation 一部方法调用: 命令模式用于实现多线程,命令对象可以在后台以线程单独允许,
  java.lang.Runnable就是一个命令接口