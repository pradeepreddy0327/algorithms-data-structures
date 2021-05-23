package string;

import java.util.HashMap;
import java.util.Map;

// Leetcode #819
public class MostCommonWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
		Map<String, Integer> wordFreqMap = new HashMap<>();
		Map<String, String> bannedWordsMap = new HashMap<>();
		int currentMax = 0;
		String currentWord = null;
		for (String bannedWord : banned) {
			bannedWordsMap.put(bannedWord.toLowerCase(), bannedWord.toLowerCase());
		}
		for (String word : words) {
			if (bannedWordsMap.get(word) == null) {
				Integer freq = wordFreqMap.get(word);
				if (freq == null) {
					freq = 0;
				}
				freq = freq + 1;
				wordFreqMap.put(word, freq);
				if (freq > currentMax) {
					currentWord = word;
					currentMax = freq;
				}
			}
		}
		return currentWord;
	}
}
