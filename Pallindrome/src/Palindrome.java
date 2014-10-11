import java.util.Scanner;


public class Palindrome {
	
	public static void main(String[] args) {
		
		String word;
		System.out.println("write a word and i will tell you if it«s pallindrome:");
		Scanner in=new Scanner(System.in);
		word=in.next();
		
		int count=word.length();
		int countCo=0; //count the number of coincidences...
				
		for (int i = 0; i <(word.length()+1)/2; i++) {
			
			count=count-1;	
			
			System.out.print(word.substring(i, i+1)+"=");
			System.out.println(word.substring(count, count+1));
			
			if (word.substring(i, i+1).compareTo(word.substring(count, count+1))==0) {
				countCo=countCo+1;
			}
		}
		if (countCo==Math.round((word.length()+1)/2.0)){
			System.out.println("it«s pallindrome");
			System.out.println(countCo);
		}else {
			System.out.println("it is«n pallindrome");
			System.out.println(countCo);
		}
	}
}
