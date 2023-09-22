class Solution {
    class Pair{
        String word;
        int pathlen;
        Pair(String w,int len)
        {
            this.word=w;
            this.pathlen=len;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set= new HashSet<>(wordList);
        Queue<Pair> que= new LinkedList<>();

        que.add(new Pair(beginWord,1));

        while(!que.isEmpty())
        {
            Pair p=que.remove();
            // char[] curword=p.word.toCharArray();
            String word=p.word;int pathlen=p.pathlen;

            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] wordArr=word.toCharArray();
                    wordArr[i]=ch;
                    String curWord=new String(wordArr);
                    if(set.contains(curWord))
                    {
                        if(curWord.equals(endWord))return pathlen+1;
                        que.add(new Pair(curWord,pathlen+1));
                        set.remove(curWord);
                    }
                }
            }
        }
    return 0;
    }
}


// class Solution {
//     class Pair{
//         String word;
//         int pathlen;
//         Pair(String w,int len)
//         {
//             this.word=w;
//             this.pathlen=len;
//         }
//     }
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         HashSet<String> set= new HashSet<>(wordList);
//         Queue<Pair> que= new LinkedList<>();

//         que.add(new Pair(beginWord,1));

//         while(!que.isEmpty())
//         {
//             Pair p=que.remove();
//             // char[] curword=p.word.toCharArray();
//             String word=p.word;int pathlen=p.pathlen;

//             for(int i=0;i<word.length();i++)
//             {
//                 String curWord="";
//                 for(int j=0;j<26;j++)
//                 {
//                     curWord=word.substring(0,i)+((char)('a'+j))+word.substring(i+1);
//                     if(set.contains(curWord))
//                     {
//                         if(curWord.equals(endWord))return pathlen+1;
//                         que.add(new Pair(curWord,pathlen+1));
//                         set.remove(curWord);
//                     }
//                 }
//             }
//         }
//     return 0;
//     }
// }














