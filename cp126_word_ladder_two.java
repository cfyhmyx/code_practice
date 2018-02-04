//Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
//from beginWord to endWord, such that:
//Only one letter can be changed at a time
//Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

import java.util.*;

public class Leetcode126 {
    public static void main(String args[]) {
        String beginWord = "magic"; //"hit";
        String endWord = "pearl"; //"cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        wordList.add("dog");
        wordList.add("maris");
        wordList.add("parks");
        wordList.add("marks");
        wordList.add("paris");
        wordList.add("magic");
        wordList.add("manic");
        wordList.add("mania");
        wordList.add("maria");
        wordList.add("marta");
        wordList.add("marty");
        wordList.add("party");
        wordList.add("marry");
        wordList.add("parry");
        wordList.add("merry");
        wordList.add("perks");
        wordList.add("perry");
        wordList.add("peaks");
        wordList.add("peary");
        wordList.add("pears");
        wordList.add("pearl");

        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;
        Set<String> startSet  = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        dict.remove(beginWord);
        dict.remove(endWord);
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        boolean find = false;
        boolean dir = true;
        while(!startSet.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for(String word : startSet) {
                for(int i=0; i<word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for(char c='a'; c<='z'; c++) {
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        if(endSet.contains(newWord) || dict.contains(newWord) && !visited.contains(newWord)) {
                            if(endSet.contains(newWord)) {
                                find = true;
                            } else {
                                temp.add(newWord);
                            //    dict.remove(newWord);     //cannot remove here, otherwise we will lose some path
                            }
                            if(dir) {
                                List<String> children = graph.getOrDefault(word, new ArrayList<>());
                                children.add(newWord);
                                graph.put(word, children);
                            } else {
                                List<String> children = graph.getOrDefault(newWord, new ArrayList<>());
                                children.add(word);
                                graph.put(newWord, children);
                            }
                        }
                    }
                }
            }
            if(find) break;
            visited.addAll(temp);
            if(temp.size()<= endSet.size()) {
                startSet = temp;
            } else {
                startSet = endSet;
                endSet = temp;
                dir = !dir;
            }
        }
        if(!find) {
            return res;
        }
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(res, path, graph, beginWord, endWord);
        return res;
    }

    private static void dfs(List<List<String>> res, List<String> path, Map<String, List<String>> graph, String beginWord, String endWord) {
        if(beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(!graph.containsKey(beginWord)) return;
        for(String start : graph.get(beginWord)) {
            path.add(start);
            dfs(res, path, graph, start, endWord);
            path.remove(path.size()-1);
        }
    }
}
