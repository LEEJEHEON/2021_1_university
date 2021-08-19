package algorism;
import java.util.Scanner;

public class hw0_1 {
	public static void main(String[] args) {
		System.out.println("hw0_1 : 이제헌");
		System.out.println("숫자맟추기 프로그램입니다.");
		Scanner scanner=new Scanner(System.in);
		int a[] = {-30,-15,1,40,50,200,315,800,9000,12345};
		int b[] = new int[10];
		int min=100;
		System.out.println("하나의 정수값을 입력하세요 :");
		int num = scanner.nextInt();
		for(int n=0;n<10;n++)
			b[n]=Math.abs(a[n]-num);
		for(int n=0;n<10;n++) {
			if(b[n]<min)
				min = b[n];
		}
		int count = 100-min;

		System.out.print("점수 ="+count );


	}
}
