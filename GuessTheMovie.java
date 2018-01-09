
import java.util.*;
import java.io.File;

public class GuessTheMovie {

	public static void main(String[] args) throws Exception {

		File movies = new File("/Users/heikevandervliet/Documents/Java Oracle cursus/movies.txt");
		Scanner moviesScanner = new Scanner(movies);
		ArrayList<String> list = new ArrayList<>();
		while (moviesScanner.hasNextLine() == true) {
			list.add(moviesScanner.nextLine());
		}
		list.size();

		Object[] objectArray = list.toArray();
		int line = (int) (Math.random() * list.size());

		
		Title titel = new Title(objectArray[line].toString().toLowerCase().trim());
		
		
		char[] charArray = new char[titel.getTitle().length()];
		Arrays.fill(charArray, '_');
		String empty = new String(charArray);
		
		
		System.out.println("Guess the movie or series title. You start with ten points \n and loose one for each wrong character you guess.");

		Game game = new Game();

		StringBuilder fout = new StringBuilder(" ");
		StringBuilder strb = new StringBuilder (empty);
		
		
		game.playGame(titel.getTitle(), fout, strb);
		
		game.gameEnds(titel.getTitle().toLowerCase());

		moviesScanner.close();
	}

}
