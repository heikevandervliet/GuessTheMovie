import java.util.*;

public class Game {

	private String title;
	private boolean hasWon = false;
	private int points = 10;

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points - 1;
	}

	public boolean getHasWon() {
		return hasWon;
	}

	public void Win(boolean won) {
		this.hasWon = won;
	}

	public void playGame (String title, StringBuilder fout, StringBuilder strb) {
		if(title.contains(" ")) {
			char space = ' ';
			for (int s = 0; s < (title.length()); s++) {
				if (space == title.charAt(s)) {
					strb.setCharAt(s, space);
				}
			}
		}
		Scanner inputScanner = new Scanner(System.in);
		for (int i = 50; i > 0; i--) {
			System.out.println("You are guessing: " + strb + "\n Guess a character:");
			String guess = inputScanner.nextLine();
			if (guess.equalsIgnoreCase(title)) {
				Win(true);
				break;
			} else if (title.contains(guess)) {
				char takeGuess = guess.charAt(0);
				for (int j = 0; j < (title.length()); j++) {
					if (takeGuess == title.charAt(j)) {
						strb.setCharAt(j, takeGuess);
					}
				}
				if (strb.toString().equalsIgnoreCase(title)){
					Win(true);
					break;
					}
			System.out.println("Correct character!");
			System.out.println("You have " + points + " points left.");
			System.out.println((10-points)+" wrong gues(ses): " + fout);
				
			} else {
				fout.append(guess.charAt(0));
				points--;
				System.out.println("Wrong character.");
				System.out.println((10-points)+" wrong gues(ses): " + fout);
				System.out.println("You have " + points + " points left.");
				if(points==0) {
				break;
				}
			}
		}
		inputScanner.close();
	}

	public void gameEnds(String title) {
		if (hasWon) {
			System.out.println("'" + title + "' was correct! You win!");
		} else if (points < 1) {
			System.out.println("You loose...");
			System.out.println("The correct answer was '" + title + "'.");
		}

	}

}