import java.util.Scanner;


public class Unscrabble {

	String[] names = new String[10];

	public void alphabeticalOrder(String[] word){
	
		String temporal="";
		names=word;		
		
		for (int i = 0; i <  names.length; i++) {
			for (int j = 0; j < names.length-1; j++) {
				if (names[i].compareTo(names[j])<0) {
					temporal=names[j];
					names[j]=names[i];
					names[i]=temporal;
				}
			}
		}
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("write a word to sort it by characters");
		
		Scanner in=new Scanner(System.in);
		String word=in.nextLine();
		String[] characters= new String[word.length()];
		
		for (int i = 0; i < characters.length; i++) {
			characters[i]=word.substring(i,i+1);
			System.out.println(characters[i]);
		}
		
		Unscrabble w=new Unscrabble();
		w.alphabeticalOrder(characters);
		
	}
}
