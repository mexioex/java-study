package data.structure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 无向图实现
 *
 * @author mexioex
 * @date 2023-07-06
 */
public class UndirectedGraph<E> {
    /**
     * 变得数量
     */
    private int edgeNum;

    private final List<Vertex<E>> vertices;

    /**
     * 向图中添加节点
     *
     * @param name 节点的名称
     */
    public void addVertex(String name) {
        for (Vertex<E> vertex : this.vertices) {
            if (name.equals(vertex.name)) {
                return;
            }
        }
        vertices.add(new Vertex<>(name));
    }

    /**
     * 获取奠定个数
     *
     * @return vertexNum
     */
    public int getVertexNum() {
        return this.vertices.size();
    }

    /**
     * 获取顶点的集合
     *
     * @return vertices
     */
    public List<Vertex<E>> getVertices() {
        return vertices;
    }

    /**
     * 给途中任意两个顶点之间加一条边
     *
     * @param srcName  开始顶点
     * @param descName 结束顶点
     * @param weight   边的权重
     */
    public void addEdge(String srcName, String descName, E weight) {
        // 起点终点不能相同
        if (srcName.equals(descName)) {
            return;
        }
        Vertex<E> srcVertex = null;
        Vertex<E> descVertex = null;
        // 找到起点和终点
        for (Vertex<E> vertex : this.vertices) {
            if (srcName.equals(vertex.name)) {
                srcVertex = vertex;
            }
            if (descName.equals(vertex.name)) {
                descVertex = vertex;
            }
        }
        // 起点和终点都不能为空
        if (srcVertex == null || descVertex == null) {
            return;
        }
        // 找到起点与终点之间是否有一条边
        for (Edge<E> edge : srcVertex.edges) {
            // 如果这条边存在,不允许添加
            if (edge.linked == descVertex) {
                return;
            }
        }
        srcVertex.edges.add(new Edge<>(descVertex, weight));
        edgeNum++;
    }

    /**
     * 获取边的数目
     *
     * @return edgeNum
     */
    public int getEdgeNum() {
        return edgeNum;
    }

    public UndirectedGraph() {
        this.edgeNum = 0;
        this.vertices = new ArrayList<>();
    }


    /**
     * 顶点
     */
    static class Vertex<E> {
        String name;
        List<Edge<E>> edges;

        public Vertex(String name) {
            this.name = name;
            this.edges = new ArrayList<>();
        }
    }

    /**
     * 边
     */
    static class Edge<E> {
        Vertex<E> linked;
        E weight;

        public Edge(Vertex<E> linked, E weight) {
            this.linked = linked;
            this.weight = weight;
        }
    }
}
