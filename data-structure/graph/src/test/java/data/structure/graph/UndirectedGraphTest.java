package data.structure.graph;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * 无向图测试
 *
 * @author mexioex
 * @date 2023-07-07
 */
public class UndirectedGraphTest {
    @Test
    public void testUndirectedGraph() {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.addVertex("v4");
        graph.addVertex("v5");
        graph.addVertex("v6");
        assertEquals("正确", graph.getVertexNum(), 6);
        graph.addEdge("v1", "v2", 1);
        graph.addEdge("v1", "v3", 2);
        graph.addEdge("v1", "v4", 3);
        assertEquals("正确", graph.getEdgeNum(), 3);
    }
}
