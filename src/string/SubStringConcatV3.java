package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringConcatV3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SubStringConcatV3 obj = new SubStringConcatV3();
        System.out.println(obj.findSubstring("barfoothefoobarman",
                new String[] { "foo", "bar" }));
        System.out.println(obj.findSubstring("wordgoodgoodgoodbestword",
                new String[] { "word", "good", "best", "word" }));
        System.out.println(obj.findSubstring("aaa", new String[] { "a", "a" }));
        System.out.println(obj.findSubstring("barfoofoobarthefoobarman",
                new String[] { "bar", "foo", "the" }));

    }


    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        int wordLength = words.length > 0 ? words[0].length() : 0;
        List<Integer> ans = new ArrayList<>();
        if (s.length() < wordLength * words.length) {
            return ans;
        }
        for (int i = 0; i < words.length; i++) {
            if (freqMap.get(words[i]) != null) {
                freqMap.put(words[i], freqMap.get(words[i]) + 1);
            } else {
                freqMap.put(words[i], 1);
            }
        }
        System.out.println(freqMap.toString());
        for (int i = 0; i <= s.length() - wordLength * words.length; i++) {
            Map<String, Integer> curFreqMap = new HashMap<>();
            int current = i;
            int count = 0;
            while (current + wordLength <= s.length()) {
                String sub = s.substring(current, current + wordLength);
                Integer expectedFreq = freqMap.get(sub);
                if (expectedFreq == null) {
                    break;
                }
                count++;

                Integer currentFreq = curFreqMap.get(sub);
                if (currentFreq == null) {
                    currentFreq = 0;
                }
                currentFreq++;
                curFreqMap.put(sub, currentFreq);
                if (currentFreq > expectedFreq) {
                    break;
                }
                if (count == words.length) {
                    ans.add(i);
                    break;
                }
                current = current + wordLength;
            }


        }
        return ans;
    }


}