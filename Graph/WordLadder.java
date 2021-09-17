package Graph;

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class WordLadder {
    // Driver code
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] WordList = {"hot","lot","dog","log","dot","cog"};
        System.out.println("Word ladder length : "+wordLadder(beginWord,endWord,WordList));
    }

    // Function to return shortest length between begin word and end word .
    private static int wordLadder(String beginWord,String endWord,String[] WordList) {
        // using hashset to keep word searching time constant .
        HashSet<String> set = new HashSet<>();
        // traversing the word list and storing words in hash set .
        for(String word : WordList) {
            set.add(word);
        }

        // if endWord is not present in set , it means wordladder is not possible hence return 0.
        if(!set.contains(endWord))
            return 0;

        // Using queue to store words
        Queue<String> queue = new LinkedList();
        int level = 1;
        queue.offer(beginWord);

        // Processing words in queue
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i<size;i++) {

                String current_word = queue.poll();
                char[] word_chars = current_word.toCharArray();

                for(int j=0;j<word_chars.length;j++) {
                    char original_char = word_chars[j];
                    for(char c='a';c<='z';c++) {
                        if(word_chars[j] == c)
                            continue;
                        word_chars[j] = c;

                        String new_word = String.valueOf(word_chars);
                        if(new_word.equals(endWord))
                            return level+1;

                        if(set.contains(new_word)) {
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }

                    word_chars[j] = original_char;
                }
            }

            level++;
        }

        return 0;

    }
}
