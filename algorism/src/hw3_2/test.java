package hw3_2;

public class test {
	public static void main(String[] args) {
		String proposer = "가";
		String proposertow = "나";

		for(byte b : proposer.getBytes())
			System.out.println(b);
		for(byte b : proposertow.getBytes())
			System.out.println(b);


		System.out.println(" ");
		System.out.println(proposer.getBytes());
		System.out.println(proposertow.getBytes());

		System.out.println(" ");

		String str = "박길동";
		System.out.println(str.compareTo("김길동")); // 10253 // 616
		System.out.println(str.compareTo("남길동")); // 9637  //  0
		System.out.println(str.compareTo("박길동")); // 6712  // -2925
		System.out.println(str.compareTo("라길동")); // 7889  // -1747
		System.out.println(str.compareTo("홍길동"));			// -9637

		System.out.println(str.compareTo(""));




		if (str.compareTo("라하사")>str.compareTo("라사라")) {
			System.out.println("가");
		}
		else {
			System.out.println("나");
		}
		System.out.println(" ");
		String[] array = str.split("");

		for(int i=0;i<array.length;i++) {
		System.out.println(array[i]);
		}


	}


}
/*
for (int a=0;a<n;a++) {
	String[] array = student[a].getname().split("");
	for(int i=0;i<array.length;i++) {
		System.out.println(array[i]);
		}
}
*/

