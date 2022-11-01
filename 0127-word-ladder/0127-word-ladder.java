class Solution {
    class Pair{
        String word;
        int step;
        Pair(String word, int step){
            this.word=word;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(q.size()>0){
            String word = q.peek().word;
            int step = q.peek().step;
            q.poll();
            
            if(word.equals(endWord)) return step;
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char[] temp = word.toCharArray();
                    temp[i] = ch;
                    String check_word = new String(temp);
                    if(set.contains(check_word)){
                        q.add(new Pair(check_word,step+1));
                        set.remove(check_word);
                    }
                }
            }  
        }
        return 0;
    }
}