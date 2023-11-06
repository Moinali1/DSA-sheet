class Solution {
    public int getWinner(int[] arr, int k) {
        int winner=0,curele=0,count=0;
        int i=0,j=1;

        while(i<arr.length && j<arr.length)
        {
            if(arr[i]>arr[j])
            {
                if(curele==arr[i])count++;
                else 
                {
                    count=1;
                    curele=arr[i];
                }

                winner=arr[i];
                if(j>i)j++;
                else j=i+1;
            }
            else
            {
                if(curele==arr[j])count++;
                else 
                {
                    count=1;
                    curele=arr[j];
                }
                winner=arr[j];
                if(i>j)i++;
                else i=j+1;
            }
            if(count>=k)break;
        }

        return winner;
    }
}