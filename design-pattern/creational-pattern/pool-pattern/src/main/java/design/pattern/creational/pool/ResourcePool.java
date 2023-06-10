package design.pattern.creational.pool;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 资源池,用于封装逻辑,永凯保存和管理资源列表
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class ResourcePool {
    private final CopyOnWriteArrayList<Resource> available;

    public ResourcePool() {
        this.available = new CopyOnWriteArrayList<>();
    }

    public Resource acquire() {
        if (available.size() == 0) {
            Resource resource = new Resource();
            available.add(resource);
        }
        return available.remove(0);
    }

    public void release(Resource resource) {
        available.add(resource);
    }
}
