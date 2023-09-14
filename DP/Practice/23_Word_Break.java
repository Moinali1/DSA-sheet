//using memoization in dp
class Solution {
    private Map<String, Boolean> dp;

    public boolean solve(String s, Set<String> m) {
        if (s.length() == 0) {
            return true;
        }
        if (dp.containsKey(s))
            return dp.get(s);
        for (int i = 0; i < s.length(); i++) {
            String r = s.substring(0, i + 1);
            if (m.contains(r)) {
                if (solve(s.substring(i + 1), m)){
                    dp.put(s,true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> m = new HashSet<>(wordDict);
        dp = new HashMap<>();
        return solve(s, m);
    }
}


//Using Tries Getting TLE
class Solution {
    class Node{
        Node[] nodes= new Node[26];
        boolean eos=false;
        Node(){}
        Node(boolean eos){
            this.eos=eos;
        }
        
    }
    
    void insert(String s,Node head)
    {
        Node cur=head;
        for(int i=0;i<s.length();i++)
        {
            if(cur.nodes[s.charAt(i)-'a']==null)
                cur.nodes[s.charAt(i)-'a']=new Node();
            cur=cur.nodes[s.charAt(i)-'a'];
        }
        cur.eos=true;
    }

    boolean search(String s,Node head)
    {
        Node cur=head;
        for(int i=0;i<s.length();i++)
        {
            if(cur.nodes[s.charAt(i)-'a']==null)return false;
            cur=cur.nodes[s.charAt(i)-'a'];
        }
        return cur.eos==true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        
        Node head=new Node();
        for(String i:wordDict)
            insert(i,head);
        return getWordBreak(s,head);
    }
    
    boolean getWordBreak(String s,Node head)
    {
        if(s.length()==0)return true;
        Node cur=head;
        for(int i=1;i<=s.length();i++)
        {
            if(search(s.substring(0,i),head))
            {
                if(getWordBreak(s.substring(i),head))return true;
            }
        }
        return false;
    }

}