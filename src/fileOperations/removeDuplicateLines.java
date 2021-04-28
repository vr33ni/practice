package fileOperations;

	import java.io.File;
	import java.io.FileWriter;
	import java.util.HashSet;
	import java.util.Scanner;
	import java.util.Set;
	public class removeDuplicateLines {
	   public static void main(String args[]) throws Exception {
	      String filePath = "C:\\Users\\vreee\\DEV\\Java\\exampleInputs\\lines.txt";
	      String input = null;
	      //Instantiating the Scanner class
	      Scanner sc = new Scanner(new File(filePath));
	      //Instantiating the FileWriter class
	      FileWriter writer = new FileWriter("C:\\Users\\vreee\\DEV\\Java\\exampleInputs\\output.txt");
	      //Instantiating the Set class
	      Set set = new HashSet();
	      while (sc.hasNextLine()) {
	         input = sc.nextLine();
	         if(set.add(input)) {
	            writer.append(input+"\n");
	            System.out.println("non duplicate lines: " + input);
	         }
	      }
	      writer.flush();
	      System.out.println("Contents added to output file.");
	   }
	}

