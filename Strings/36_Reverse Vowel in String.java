class Solution {
    public String reverseVowels(String s) {
    HashSet<Character> set= new HashSet<>();
    set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
    set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');

    int i=0,j=s.length()-1;
    char[] sArray=s.toCharArray();

    while(i<j)
    {
        while(i<j &&!set.contains(sArray[i]))i++;
        while(i<j && !set.contains(sArray[j]))j--;
        char temp=sArray[i];
        sArray[i++]=sArray[j];
        sArray[j--]=temp;
    }

    return new String(sArray);
    }
}