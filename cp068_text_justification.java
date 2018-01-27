//https://leetcode.com/problems/text-justification/description/

import java.util.ArrayList;
import java.util.List;

public class Leetcode068 {
    public static void main(String args[]) {

    }

    public static List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);

            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index+1; i < last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff; //doesn't include that origin space we counted
                int r = (L - count) % diff;
                for(int i=index+1; i<last; i++) {
                    for(int k=spaces; k>0; k--) {
                        builder.append(" ");
                    }
                    if(r>0) {
                        builder.append(" ");
                        r--;
                    }
                    builder.append(" ");    //the origin space
                    builder.append(words[i]);
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }
}
