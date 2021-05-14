package random;

public class WordFrequencies {

	static int count(String word, String[]book) {
		if (word == "") return 1; //take NO word from the array as the 1 way to construct the empty target string
		int count = 0;
		
		for (int i = 0; i < book.length; i++) {
			if (word.indexOf(book[i]) == 0) {
				int currCount = count(word.substring(book[i].length()), book);
				count += currCount;
			}
		}
		return count;
	}
	
	public static void main(String[]args) {
		String word = "word";
		String[] book = {"this", "is", "just", "another", "word", "in", "a", "book"};
		System.out.println(count(word, book));
	}
}
