class Solution {

    void mirror(Node node) {
        getMirror(node);
    }
    Node getMirror(Node node){
        if(node==null) return null;
        Node left=getMirror(node.left);
        Node right=getMirror(node.right);
        
        node.right=left;
        node.left=right;
        return node;
    }
}