//when compare strings use equal
public class EqualString {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		String p1="Uda";
		String p2="city";
		String complete=p1+p2;
		System.out.println(complete);
		System.out.println("Udacity");
		if (complete=="Udacity") {//
				System.out.println("OK");
		}
		if (complete.equals("Udacity")) {
			System.out.println("OK equal");
		}
		//complete.equals("no comment");   if the statement was "no comment"
		
		//complete.length()==0; if the statement was nothing at all
		
		//complete==null   if there is not statement
	}

}
