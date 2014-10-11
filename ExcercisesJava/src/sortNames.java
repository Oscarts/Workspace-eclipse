import java.util.Scanner;

public class sortNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String temporal="";
		String[] names = new String[10];
		System.out.println("write 10 names");
		Scanner name=new Scanner(System.in);
		
		for (int i = 0; i < names.length; i++) {
			names[i]=name.next();
		}
		
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

}
