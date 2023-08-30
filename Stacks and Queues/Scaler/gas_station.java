class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasReq=0,gasHave=0;
        int s=0,e=0;

        for(e=0;e<gas.length;e++)
        {
            gasHave+=gas[e]-cost[e];
            if(gasHave<0)
            {
                gasReq+=gasHave;
                gasHave=0;
                s=e+1;
            }
        }
        if(gasReq+gasHave>=0)return s;
        return -1;
    }
}