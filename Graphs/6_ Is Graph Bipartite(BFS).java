class Solution {
    public boolean isBipartite(int[][] graph) {
        int vis[]= new int[graph.length];
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0;i<graph.length;i++)
        {
            if(vis[i]==0)
            {
                que.add(i);
                vis[i]=-1;
                while(!que.isEmpty())
                {
                    int ele=que.remove();
                    for(int j=0;j<graph[ele].length;j++)
                    {
                        if(vis[graph[ele][j]]==0){
                            vis[graph[ele][j]]=-vis[ele];
                            que.add(graph[ele][j]);
                        }
                        else if(vis[graph[ele][j]]==vis[ele])return false;
                    }
                }
            }
        }
        return true;
    }