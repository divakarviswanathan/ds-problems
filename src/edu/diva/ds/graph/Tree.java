package edu.diva.ds.graph;

public class Tree {


    Node root;
    Node commonRoot;

    public Tree( Node root ) {
        this.root = root;
        commonRoot = null;
    }

    public void addElement( String elementValue ) { 
        String[] list = elementValue.split("/");
        root.addElement(root.incrementalPath, list);

    }

    public void printTree() {
        getCommonRoot();
        commonRoot.printNode(0);
    }

    public Node getCommonRoot() {
        if ( commonRoot != null)
            return commonRoot;
        else {
            Node current = root;
            while ( current.leafs.size() <= 0 ) {
                current = current.childs.get(0);
            }
            commonRoot = current;
            return commonRoot;
        }

    }
}

