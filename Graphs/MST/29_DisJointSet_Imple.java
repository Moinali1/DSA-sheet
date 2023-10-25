// coding here only concept
public class DisJointSet_Imple {
    static class DisJoint {
        int n;
        int[] rank;
        int[] parent;

        DisJoint(int n)
        {
            this.n=n;
            rank= new int[n+1];
            parent= new int[n+1];
            for(int i=0;i<n;i++)parent[i]=i;
        }

       public int findPrnt(int node)
        {
            if(node==parent[node])return node;
            return parent[node]=findPrnt(parent[node]);
        }

        public void unionByRank(int u,int v)
        {
            int uniU=findPrnt(u),uniV=findPrnt(v);
            int rankU=rank[uniU],rankV=rank[uniV];

            if(rankU>rankV)
            {
                parent[uniV]=uniU;
            }
            else if(rankV>rankU)
            {
                parent[uniU]=uniV;
            }
            else
            {
                parent[uniV]=uniU;
                rank[uniU]++;
            }
        }
    }
    
    public static void main(String[] args)
    {
        DisJoint ds= new DisJoint(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        if(ds.findPrnt(5)==ds.findPrnt(6)) System.out.println("Yes 5 and 6 are in same component");
        else System.out.println("No 5 and 6 are not in same component");
        ds.unionByRank(5, 6);
        if(ds.findPrnt(5)==ds.findPrnt(6)) System.out.println("Yes 5 and 6 are in same component");
        else System.out.println("No 5 and 6 are not in same component");
        ds.unionByRank(3, 7);
    }

}

