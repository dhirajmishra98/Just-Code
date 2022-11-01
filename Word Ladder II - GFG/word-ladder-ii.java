//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList)
    {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.length;i++)
            set.add(wordList[i]);
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> usedLevel = new ArrayList<>();
        int level = 0;
        
        ArrayList<String> tempo = new ArrayList<>();
        tempo.add(beginWord);
        q.add(tempo);
        usedLevel.add(beginWord);
        while(!q.isEmpty()){
            ArrayList<String> words = q.peek();
            q.poll();
            
            if(words.size() > level){
                level++;
                for(String it : usedLevel){
                    set.remove(it);
                }
                usedLevel.clear();
            }
            
            String word = words.get(words.size()-1);
            
            if(words.get(words.size()-1).equals(endWord)){
                if(ans.size() == 0){
                    ans.add(words);
                }else if(ans.get(0).size()==words.size()){
                    ans.add(words);
                }
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] newWord = word.toCharArray();
                    newWord[i] = ch;
                    String str = new String(newWord);
                    
                    if(set.contains(str)){
                        words.add(str);
                        ArrayList<String> temp = new ArrayList<>(words);
                        q.add(temp);
                        usedLevel.add(str);
                        words.remove(words.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}