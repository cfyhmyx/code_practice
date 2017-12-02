//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord,
//such that:
//Only one letter can be changed at a time.
//Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

import java.util.*;

public class Leetcode127 {
    public static void main(String args[]) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        //wordList.add("cog");
        wordList.add("dog");
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> startSet  = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        if(dict.contains(endWord)) {
            endSet.add(endWord);
        }
        int result = 2;
        while(!startSet.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for(String word : startSet) {
                dict.remove(word);
                for(int i=0; i<word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for(char c='a'; c<'z'; c++) {
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        if(endSet.contains(newWord)) {
                            return result;
                        }
                        if(dict.contains(newWord)) {
                            temp.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                }
            }
            if(temp.size()< endSet.size()) {
                startSet = temp;
            } else {
                startSet = endSet;
                endSet = temp;
            }
            result++;
        }
        return 0;
    }

    /*public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dict.remove(beginWord);
        int result = 1;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0; i<n; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    return result;
                }
                for(int j=0; j<word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for(char ch = 'a'; ch<='z'; ch++) {
                        chars[j] = ch;
                        String newWord = String.valueOf(chars);
                        if(dict.contains(newWord)) {
                            queue.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }*/
}
