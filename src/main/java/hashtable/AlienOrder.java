package hashtable;

// leetcode 953  tags: Facebook
public class AlienOrder {

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[26];
        for(int i=0;i<order.length();i++){
            orderArray[order.charAt(i)-'a'] = i;
        }
        for(int i=1;i<words.length;i++){
            if(!isOrdered(words[i-1], words[i], orderArray))
                return false;
        }
        return true;
    }

    private boolean isOrdered(String word1, String word2, int[] orderArray){
        int i=0;
        while(i < word1.length() && i < word2.length()){
            int word1CharOrder = orderArray[word1.charAt(i)-'a'];
            int word2CharOrder = orderArray[word2.charAt(i)-'a'];
            if(word1CharOrder < word2CharOrder) return true;
            if(word1CharOrder > word2CharOrder) return false;
            i++;
        }
        return word1.length() <= word2.length();
    }
}
