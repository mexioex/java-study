# 常用api

## Math类,数学操作

- abs 在int的最小值会得不到取不到绝对值
- cell 采用进一法取整,11.1取整=12,-11.1取整=-11
- floor 采用去除尾法,11.1取整=11,-11.1取整=-12
- round 采用四舍五入
- max 取大的值
- min 取小的值
- pow a的b次幂
- sqrt 开平方
- cbrt 开立方
- random 获取[0.0,1.0)之间的随机数

## System类,系统操作

- exit 退出虚拟机,0正常退出,非0都不正常,exit之后的代码都不会在指向
- currentTimeMillis 获取当前时间毫秒值
- arraycopy
    - 原数组
    - 从第几个开始拷贝
    - 目标数组
    - 目标数组接收拷贝的索引
    - 拷贝的个数
- gc 通知垃圾回收执行,但仅仅只是通知了,执不执行取决于虚拟机

## Runtime,运行时环境

- getRuntime 获取运行环境
- exit 退出虚拟机
- availableProcessors 获取有效的处理器的个数
- maxMemory 获取虚拟机能获取的最大内存
- totalMemory 获取虚拟机已经获取的最大内存
- freeMemory 获取虚拟机剩余内存大小
- exec 执行cmd命令