class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans= new ArrayList<>();
        if(digits.isEmpty())return ans;
        phone("",digits,ans);
        return ans;
    }
    public void phone(String p,String up,ArrayList<String> ans)
    {
        if(up.isEmpty())
        {   ans.add(p);
            return;
        }
        int digit=up.charAt(0)-'0';
        int st=3*((digit)-2);
        if(digit>7) st++;
        int e= st+3;
        if(digit==7 || digit==9) e++;
        for(int i=st;i<e;i++)
        {
            phone(p+(char)('a'+i),up.substring(1),ans);
        }
    }
}

//line 15
// 3*(2-2)=0----->[0-3)
// 3*(3-2)=3----->[3-6)
// 3*(4-2)=6----->[6-9)

//for    7           8             9
//    15 16 17     18 19 20      21 22 23      24 25
//   15 16 17 18   19 20 21     22 23 24 25
// ?   s,e++         s++           s++ e++