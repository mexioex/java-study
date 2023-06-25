package design.pattern.behavioral.interprter;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境角色类
 *
 * @author mexioex
 * @date 2023-06-26
 */
public class Context {
    /**
     * 存储变量和值
     */
    private final Map<Variable, Integer> map = new HashMap<>(16);

    /**
     * 添加变量
     *
     * @param variable 变量名
     * @param value    变量值
     */
    public void assign(Variable variable, Integer value) {
        map.put(variable, value);
    }

    /**
     * 获取变量的值
     *
     * @param variable {@link Variable}
     * @return map中存储的value
     */
    public Integer getValue(Variable variable) {
        return map.get(variable);
    }
}
