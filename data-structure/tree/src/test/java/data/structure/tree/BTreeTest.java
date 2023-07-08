package data.structure.tree;

import org.junit.Test;

/**
 * B树测试
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class BTreeTest {
    @Test
    public void test() {
        BTree<String, Integer> tree = new BTree<>();
        tree.put("1", 1);
        tree.put("2", 2);
        tree.put("3", 3);
        tree.put("4", 4);
        tree.put("5", 5);
    }
}
