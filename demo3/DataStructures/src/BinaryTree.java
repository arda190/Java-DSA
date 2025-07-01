public class BinaryTree {
    Node root;

    public void insert(int value){
        root=insertRec(root,value);
    }

    private Node insertRec(Node node,int value){
        if(node==null) return new Node(value);
        if(value<node.value) node.left = insertRec(node.left,value);
        else if(value>node.value) node.right = insertRec(node.right,value);
        return node;
    }





}
