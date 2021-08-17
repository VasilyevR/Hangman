package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWord {
    private final List<Character> characters = new ArrayList<>();

    public RandomWord() {
        Random r=new Random();
        int randomNumber=r.nextInt(WordEnum.words.length);
        String randomWord = WordEnum.words[randomNumber];
        for (char chr : randomWord.toCharArray()) {
            this.characters.add(chr);
        }
    }
    public String toString() {
        StringBuilder builder = new StringBuilder(this.characters.size());
        for(Character ch: this.characters)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    public String show(List<Character> foundChars) {
        StringBuilder wordForDisplay = new StringBuilder();
        for (char charOfWord : this.characters) {
            if (foundChars.contains(charOfWord)) {
                wordForDisplay.append(charOfWord);
                continue;
            }
            wordForDisplay.append("_");
        }

        return wordForDisplay.toString();
    }

    public boolean isSolved(List<Character> foundChars) {
        return foundChars.containsAll(this.characters);
    }

    public boolean isContainChar(char chr) {
        return this.characters.contains(chr);
    }
}
