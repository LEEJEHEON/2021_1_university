package hw7_1;
import java.util.Scanner;
//***************************
//파일명: MyArrayStackTest.java
//작성자: 201625025 이제헌
//작성일: 2020.04.26
//설명: 배열로 구현한 스택을 이용하여 삽입, 삭제, 조회, 전체 삭제를 할 수 있는 프로그램
//***************************

class MyArrayStack{
	private float stack_test[];
	private int top; // 스택 맨 위에 원소를 가르키는 뱐수

	public MyArrayStack(int num) { // 생성자
		this.stack_test=new float[num]; // 배열 크기 선정
		top = -1; // 맨 처음에는 아무 원소도 없기에 -1
	}

	public boolean isEmpty() { //스택이 비어있는지 확인
		return (top==-1);
	}

	public boolean isFull() { //스택이 가득 찼는지 확인
		return (top==this.stack_test.length-1);
	}

	public void push(float item) { // 스택에 원소를 삽입하는 메소드
		if(isFull()) {
			System.out.println("스택이 가득 찼습니다.");
		}
		else {
			stack_test[++top]=item;
		}
	}

	public float pop() { //스택에 원소를 삭제하며 삭제한 원소를 출력하는 메소드
		if(isEmpty()) {
			throw new java.util.EmptyStackException();
		}
		else {
			return stack_test[top--];
		}
	}

	public float peek() { //스택에서 맨 위에 있는 원소를 조회하는 메소드
		if(isEmpty()) {
			throw new java.util.EmptyStackException();
		}
		else {
			return stack_test[top];
		}
	}

}

public class MyArrayStackTest {
	public static void main(String[] args) {
		System.out.println("hw7_1: 이제헌");
		Scanner sc = new Scanner(System.in);
		boolean num = true; // 5번을 누르기 전까지 계속 무한반복을 하기 위해
		int choice; // menu 선택
		System.out.println("스택 연산 프로그램입니다.");
		System.out.print("스택의 크기를 입력하시오 : ");
		MyArrayStack st = new MyArrayStack(sc.nextInt());
		while(num) {
			System.out.println("1:삽입 2:삭제 3:조회 4:전체삭제 5:종료");
			choice = sc.nextInt();
			switch(choice){
				case(1):
					System.out.print("삽입할 실수값을 입력하시오 : ");
					st.push(sc.nextFloat());
					break;
				case(2):
					System.out.println("삭제한 원소 :"+st.pop());
					break;
				case(3):
					System.out.println("조회한 원소 :"+st.peek());
					break;
				case(4):
					System.out.print("스택의 모든 원소를 삭제 = ");
					while(!st.isEmpty()) {  // 스택이 비어질 때 까지 반복
						System.out.print(st.pop()+" ");
					}
					System.out.println();
					break;
				case(5):
					System.out.print("시스템을 종료합니다.");
					num =false;
					break;
				default:
					System.out.println("번호를 잘못입력하셨습니다. 다시 입력하세요.");

			}


		}


	}

}
