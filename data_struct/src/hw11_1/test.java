package hw11_1;

public class test {

	public static void main(String[] args) {
		String a= "apple" ;
		String b= "banana";
		String a1= "apPle" ;
		String b1= "BAnana";
		String a2= "a" ;
		String b2= "b";

		System.out.println(a2.compareTo(b2));

		System.out.println((a1.toLowerCase()).compareTo((b1.toLowerCase())));
		System.out.println((a1.toLowerCase())+" "+((b1.toLowerCase())));

		System.out.println(b2.compareTo(a2));
	}
}
