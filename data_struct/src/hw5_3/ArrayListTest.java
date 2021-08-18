package hw5_3;
import java.util.ArrayList;
import java.util.Scanner;
//***************************
//파일명: ArrayListTest.java
//작성자: 201625025 이제헌
//작성일: 2020.04.13
//설명: 리스트에 사용자가 메뉴를 선택하여 삽입을 하거나, 원하는 자리에 삽입을 하거나, 원하는 자리의 원소를 삭제하거나, 조회를 하는 프로그램
//***************************
public class ArrayListTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> Alist = new ArrayList<>(); // 정수형 ArrayList 객체 생성
		System.out.println("hw5_3:이제헌");
		System.out.println("정수 리스트 프로그램입니다. 메뉴를 선택하세요.");
		while(true) {  // 5 를 입력하기 까지 무한 반복
			System.out.print("1:삽입 2:인덱스 삽입 3:인덱스 삭제 4:전체조회 5:종료 -->");
			int choice = scanner.nextInt();
			switch(choice){
				case 1 : // list에 삽입
					System.out.print("삽입할 정수 입력:");
					Alist.add(scanner.nextInt());
					break;
				case 2 : // 인덱스와 삽입할 정수를 입력하여 원하는 인덱스 자리에 삽입
					System.out.print("인덱스와 삽입할 정수 입력:");
					try {
					Alist.add(scanner.nextInt(), scanner.nextInt());
					}
					catch (IndexOutOfBoundsException e){//예외처리
						System.out.println("인덱스를 잘못 입력 하셨습니다.");
					}
					break;
				case 3 :// 삭제할 정수의 인덱스를 입력하여 삭제
					System.out.print("삭제할 리스트의 인덱스를 입력:");
					try {
					System.out.println("삭제한 정수: "+Alist.remove(scanner.nextInt()));
					}
					catch (IndexOutOfBoundsException e){//예외처리
						System.out.println("인덱스를 잘못 입력 하셨습니다.");
					}
					break;
				case 4 : //list 안에 들어있는 원소들 출력
					System.out.print("list= ");
					for (int i : Alist) {
						System.out.print(i+" ");
					}
					System.out.println();
					break;

				case 5 : // 프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);  // 프로그램 종료
			}
		}
	}


}
