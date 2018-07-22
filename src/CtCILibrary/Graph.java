package CtCILibrary;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    public ArrayList<Node> nodes;

    public static class Node {
        public int data;
        public ArrayList<Node> adyacents = new ArrayList<>();

        public void connect(Node n) {
            adyacents.add(n);
            n.adyacents.add(this);
        }
    }

    public void add(Node n) {
        nodes.add(n);
    }
}
