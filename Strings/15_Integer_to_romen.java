//optimized
class Solution
{
	String convertToRoman(int n) {
		int num[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String roman[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		int x=n;
		String ans="";
		for(int i=0;i<13;i++)
		{
		    while(x>=num[i])
		    {
		        ans+=roman[i];
		        x-=num[i];
		    }
		}
		return ans;
	}
}


//navie approch
class Solution
{
	String convertToRoman(int n) {
	    TreeMap<Integer,String> map= new TreeMap<>();
	    insert(map);
	    
		int num=n,cur=0;
		String curS="",ans="";
		
		for(int i=1;i<=Math.log10(n) + 1;i++)
		{
		    cur=(int)(num%Math.pow(10,i));
		    num=num-cur;
		    while(cur!=0)
		    {
		        if(map.containsKey(cur)){
		            curS=curS+map.get(cur);break;
		        }
		        else{
		           int pre=0;
		           for(int j:map.keySet())
		           {
		                if(cur<j)break;
		                pre=j;
		           }
		           curS=curS+map.get(pre);
		           cur-=pre;
		        }
		    }
		    ans= curS+ans;
		    curS="";
		}
		return ans;
	}
	void insert(TreeMap<Integer,String> map)
	{
	    map.put(1,"I");
	    map.put(2,"II");
	    map.put(3,"III");
	    map.put(4,"IV");
	    map.put(5,"V");
	    map.put(6,"VI");
	    map.put(7,"VII");
	    map.put(8,"VIII");
	    map.put(9,"IX");
	    map.put(10,"X");
	    map.put(40,"XL");
	    map.put(50,"L");
	    map.put(90,"XC");
	    map.put(100,"C");
	    map.put(400,"CD");
	    map.put(500,"D");
	    map.put(900,"CM");
	    map.put(1000,"M");
	}
}