class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[]= new int[graph.length];
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                que.add(i);
                color[i]=-1;//-1 blue 1 red
                while(!que.isEmpty())
                {
                    int ele=que.remove();
                    vis[ele]=true;
                    int getColor=color[ele]==-1?1:-1;

                    for(int j=0;j<graph[ele].length;j++)
                    {
                        if(!vis[graph[ele][j]]){
                            int childColor=color[graph[ele][j]];
                            if(childColor==-1*(getColor))return false;
                            color[graph[ele][j]]=getColor;
                            que.add(graph[ele][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}