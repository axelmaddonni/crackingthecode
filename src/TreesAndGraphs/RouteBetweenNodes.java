package TreesAndGraphs;

import CtCILibrary.Graph;

import java.util.HashSet;
import java.util.Stack;

public class RouteBetweenNodes {

    public static Boolean checkRouteUsingDFS(Graph.Node start, Graph.Node end) {
        HashSet<Graph.Node> visited = new HashSet<>();
        visited.add(start);
        return checkRouteUsingDFS(start, end, visited);
    }

    private static Boolean checkRouteUsingDFS(Graph.Node start, Graph.Node end, HashSet<Graph.Node> visited) {
        System.out.println(start.data);
        for (Graph.Node n : start.adyacents) {
            visited.add(n);
            if (n.equals(end)) {
                return true;
            } else if (checkRouteUsingDFS(n, end, visited)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkRouteUsingBFS(Graph.Node start, Graph.Node end) {

        HashSet<Graph.Node> visited = new HashSet<>();
        Stack<Graph.Node> stack = new Stack<>();
        stack.push(start);
        visited.add(start);

        while (! stack.empty()) {
            Graph.Node node = stack.pop();
            System.out.println(node.data);
            for (Graph.Node ady : node.adyacents) {
                if (! visited.contains(ady)) {
                    if (ady.equals(end)) {
                        return true;
                    }
                    stack.push(ady);
                    visited.add(ady);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph.Node start = new Graph.Node();
        start.data = 1;

        Graph.Node ady1 = new Graph.Node();
        ady1.data = 2;

        Graph.Node ady2 = new Graph.Node();
        ady2.data = 3;

        start.adyacents.add(ady1);
        start.adyacents.add(ady2);

        Graph.Node end = new Graph.Node();
        end.data = 4;
        ady1.adyacents.add(end);

        Graph.Node other = new Graph.Node();
        other.data = 5;

        System.out.println(checkRouteUsingDFS(start, end));
        System.out.println(checkRouteUsingDFS(start, other));

        System.out.println(checkRouteUsingBFS(start, end));
        System.out.println(checkRouteUsingBFS(start, other));
    }
}
