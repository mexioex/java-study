package data.structure.tree;

import org.junit.Test;

/**
 * 二叉查找树测试
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class BinarySearchTreeTest {
    @Test
    public void test() {
        BinarySearchTree<String, String> tree = new BinarySearchTree<>();
        tree.put("5", "5");
        tree.put("4", "4");
        tree.put("3", "3");
        tree.put("2", "2");
        tree.put("1", "1");
        System.out.println(tree.getMax());
        System.out.println(tree.getMin());
    }
}
