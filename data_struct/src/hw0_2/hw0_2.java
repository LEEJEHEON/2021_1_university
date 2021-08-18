
package hw0_2;
import java.util.Scanner;


public class hw0_2 {
	public static void main(String[] args) {
		System.out.println("hw0_2:이제헌 ");
		Scanner scanner=new Scanner(System.in);
		int number[] = {0,0,0,0,0,0,0,0,0,0};   // 랜덤 넘버의 갯수를 저장한 배열 생성
		int count = 1 ; // 갯수를 증가시킬 변수
		System.out.print("생성할숫자의 개수를 입력하세요:");
		int a = scanner.nextInt();
		System.out.print(a+"개의 랜덤넘버=");
		for(int n=0;n<a;n++) {                // 사용자 입력한 숫자만큼 랜덤넘버를 생성
			int b =(int)(Math.random()*10)+1; // 1 ~ 10 범위의 랜덤한 정수값
			int m = 0;
			while(m<11) { //최댓값이 10이기 때문
				if (m==b-1) { //인덱스는 0부터 시작해서 b-1 , 같으먼 1을 추가
					number[m]=number[m]+count;
					break;
				}
				m+=1;
			}
			System.out.print(b+" " );
		}
		System.out.println();
		for(int n=1;n<11;n++) // 랜덤넘버의 갯수가 저장된 배열을 보여주기 위한 반복문
			System.out.println(n+"의 개수 ="+number[n-1]);
	}
}
