
class convert{
	public String convertToWords(int n){
	    
    	HashMap<Integer,String> map= new HashMap<>();
    	inputMap(map);
    	int[] places=new int[5];
    	String[] wPlaces={"crore","lakh","thousand","hundred",""};
        int num=n,pos=0;       
        for(int i=10000000;i!=1;)
        {
            if(i==10)i=100;
            places[pos]=(int)num/i;
            num=num-(places[pos++]*i);
            i=i/100;
        }
        places[pos]=num;
        
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<4;i++)
        {
            int digits=places[i];
            if(digits==0)continue;
            if(map.containsKey(digits))
            {
                ans.append(map.get(digits)+" "+wPlaces[i] +" ");
            }
            else
            {
                int tens=digits-(digits%10);
                int ones=digits%10;
                if(tens!=0)ans.append(map.get(tens) +" ");
                ans.append(map.get(ones) +" "+wPlaces[i] +" ");
            }
        }
        int digits=places[4];
        if(map.containsKey(digits))
        {
            ans.append("and "+map.get(digits));
            return ans.toString();
        }
        if(digits==0)return ans.toString().substring(0,ans.length()-1);
        int tens=digits-(digits%10);
        int ones=digits%10;
        ans.append("and ");
        if(tens!=0)ans.append(map.get(tens) +" ");
        if(ones!=0)ans.append(map.get(ones));
        
    return ans.toString();

	}
	public void inputMap(HashMap<Integer, String> map) {
    map.put(1, "one"); map.put(2, "two");
    map.put(3, "three"); map.put(4, "four");
    map.put(5, "five"); map.put(6, "six");
    map.put(7, "seven"); map.put(8, "eight");
    map.put(9, "nine"); map.put(10, "ten");
    map.put(11, "eleven"); map.put(12, "twelve");
    map.put(13, "thirteen"); map.put(14, "fourteen");
    map.put(15, "fifteen"); map.put(16, "sixteen");
    map.put(17, "seventeen"); map.put(18, "eighteen");
    map.put(19, "nineteen"); map.put(20, "twenty");
    map.put(30, "thirty"); map.put(40, "forty");
    map.put(50, "fifty");map.put(60, "sixty");
    map.put(70, "seventy");map.put(80, "eighty");
    map.put(90, "ninety");
}

}


