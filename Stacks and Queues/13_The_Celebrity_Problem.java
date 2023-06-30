class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> st= new Stack<>();
    	for(int i=0;i<n;i++) st.push(i);
    	
    	while(!st.isEmpty())
        {
            int i,j;
            if(st.size()<=1)break;
            i=st.pop();j=st.pop();
            
            if(M[i][j]==1 && M[j][i]==1)continue;
            else if(M[i][j]==1){
                 st.push(j);
            }
            else st.push(i);
        }
        if(st.isEmpty())return -1;
        int idx=st.pop();
        for(int i=0;i<n;i++)
        {
            if(idx==i)continue;
            if(M[idx][i]!=0 || M[i][idx]!=1)return -1;
        }
        return idx;
    }
}

// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1