package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

	private boolean running = true;
	private final RandomWord randomWord = new RandomWord();
	private final List<Character> foundCharacters = new ArrayList<>();
	private final List<Character> wrongCharacters = new ArrayList<>();
	private int attempts = 15;

	public void run() {
		char userChar;
		do {
			displayRandomWord();
			userChar = getUserInputChar();
			checkUserInput(userChar);
		} while (this.running);
	}

	private void checkUserInput(char userChar) {
		if (!this.running) {
			return;
		}
		if (this.foundCharacters.contains(userChar) || this.wrongCharacters.contains(userChar)) {
			return;
		}
		if (!this.randomWord.isContainChar(userChar)) {
			this.wrongCharacters.add(userChar);
			this.attempts--;
			if (this.attempts == 0) {
				this.showGameOver();
				this.running = false;
				return;
			}
			this.showAttempts();
			return;
		}
		this.foundCharacters.add(userChar);
		if (this.randomWord.isSolved(this.foundCharacters)) {
			this.showWin();
			this.running = false;
			return;
		}
		this.showAttempts();
	}

	private void showAttempts() {
		System.out.println("Attempts: " + this.attempts);
		System.out.println("Wrong chars: " + this.wrongCharacters);
	}

	private void showGameOver() {
		System.out.println("IT WAS " + this.randomWord);
		System.out.println("GAME OVER!");
	}

	private char getUserInputChar() {
		Scanner scanner = new Scanner(System.in);
		String chr = scanner.next();
		return chr.charAt(0);
	}

	void displayRandomWord() {
		System.out.println("Guess the word! Input a char!");
		System.out.println(this.randomWord.show(this.foundCharacters));
	}

	private void showWin() {
		System.out.println("IT WAS " + this.randomWord);
		System.out.println("YOU WIN!");
	}
}
