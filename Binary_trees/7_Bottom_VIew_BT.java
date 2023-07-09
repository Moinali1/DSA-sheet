{
    //Function to return a list containing the bottom view of the given tree.
    
    public ArrayList <Integer> bottomView(Node root)
    {
        TreeMap<Integer,Node> Vlevel= new TreeMap<>();
        ArrayList <Integer> ans=new ArrayList<>();
        root.hd=0;
        getBottomView(root,0,Vlevel);
        for(Map.Entry<Integer,Node> entry:Vlevel.entrySet()){
         ans.add(entry.getValue().data);
     }

        return ans;
    }
    public void getBottomView(Node node,int curlevel,TreeMap<Integer,Node> Vlevel)
    {
        if(node==null)return;
        if(!Vlevel.containsKey(curlevel))Vlevel.put(curlevel,node);
        else if(Vlevel.get(curlevel).hd<=node.hd)
        {
            Vlevel.put(curlevel,node);
        }
        if(node.left!=null)
        {
            node.left.hd=node.hd+1;
            getBottomView(node.left,curlevel-1,Vlevel);
        }
        if(node.right!=null)
        {
            node.right.hd=node.hd+1;
            getBottomView(node.right,curlevel+1,Vlevel);
        }
    }
}