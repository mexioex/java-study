package se.common.system.api;

import java.io.IOException;

/**
 * Runtime 测试
 *
 * @author mexioex
 * @date 2023-06-12
 */
public class RuntimeTest {
    public static void main(String[] args) throws IOException {
        // 获取Runtime
        Runtime runtime = Runtime.getRuntime();
        // 退出虚拟机
//        runtime.exit(0);
        // 获取有效的处理器
        System.out.println(runtime.availableProcessors());
        // 获取虚拟机能获取的最大内存
        System.out.println(runtime.maxMemory());
        // 获取虚拟机已经获取的最大内存
        System.out.println(runtime.totalMemory());
        // 获取虚拟机剩余内存大小
        System.out.println(runtime.freeMemory());
        // 执行cmd命令
        System.out.println(runtime.exec("cmd"));
    }
}
