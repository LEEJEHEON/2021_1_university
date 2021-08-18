package hw_01;
import java.util.Scanner;

public class hw_01_01 {

	public static void main(String[] args) {
		System.out.println("hw0_1 : 이제헌");
		Scanner scanner=new Scanner(System.in);
		int a[]=new int[10];
		System.out.print("정수값10개입력 :");
		for(int n=0;n<10;n++)
			a[n]=scanner.nextInt();

		System.out.print("검색할 정수값 입력:");
		int b =scanner.nextInt();

		for(int n=0;n<10;n++) {
			if(a[n]==b) {
				System.out.print("인덱스 ="+ n);
				break;
			}
			else if(n==9){
				System.out.print("인덱스 = -1");
			}

		}

	}
}
