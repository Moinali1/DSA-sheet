class Solution {
    public static int floor(Node root, int key) {
        Node preItr=root;
        int ans=-1;
        while(preItr!=null)
        {
        if(preItr.data>key) preItr=preItr.left;
        else if(preItr.data<=key){
          ans=preItr.data;
          preItr=preItr.right;
        }
        }
        return ans;
    }
}