class Solution {
    public String simplifyPath(String path) {
        Deque<String> que= new LinkedList<>();

        for(String s : path.split("/"))
        {
            if(s.equals("") || s.equals("."))continue;
            else if(s.equals("..")){if(!que.isEmpty())que.removeLast();}
            else que.addLast(s);
        }
  
        StringBuilder sb= new StringBuilder("");
        while(!que.isEmpty())
        {
            sb.append("/"+que.removeFirst());
        }
        return sb.length()==0?"/":sb.toString();
    }
}

