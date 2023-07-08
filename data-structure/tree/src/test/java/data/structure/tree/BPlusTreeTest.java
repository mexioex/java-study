package data.structure.tree;

import org.junit.Test;

/**
 * B+树测试
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class BPlusTreeTest {
    @Test
    public void test() {
        BPlusTree<String, Integer> tree = new BPlusTree<>();
        tree.put("1", 1);
        tree.put("2", 2);
        tree.put("3", 3);
        tree.put("4", 4);
        tree.put("5", 5);
        tree.put("6", 6);
    }
}
