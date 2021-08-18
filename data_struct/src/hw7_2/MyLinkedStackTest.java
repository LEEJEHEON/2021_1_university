package hw7_2;
import java.util.Scanner;
//***************************
//파일명: MyLinkedStackTest.java
//작성자: 201625025 이제헌
//작성일: 2020.04.28
//설명: 스택구조를 연결 자료구조 방식으로 만든 프로그램
//***************************
class MyLinkedStack{
	private Node top; // 스택 맨 위에 원소를 가르키는 변수

	public MyLinkedStack() { // 생성자
		top = null; // 맨 처음에는 아무 원소도 없어서 null
	}

	public boolean isEmpty() { //스택이 비어있는지 확인
		return (top==null);
	}

	public void push(float item) { // 스택에 원소를 삽입하는 메소드
		Node newNode = new Node(); // 새로운 실수값을 넣기 위해 노드객체 생성
		newNode.data=item;
		newNode.link=top; // top이 가르키는 노드를 가르킴 (처음에는 null)
		top= newNode; // top 은 새로운 노드를 가르킴
	}

	public float pop() { //스택에 원소를 삭제하며 삭제한 원소를 출력하는 메소드
		if(isEmpty()) { // 스택이 비어 있으면 예외 발생
			throw new java.util.EmptyStackException();
		}
		else {
			float item = top.data; // 출력할 데이터를 item에 넣음
			top = top.link; // top.link를 top이 가르키게 함으로써 top이 가르킨 맨 앞 노드를 삭제
			return item;
		}
	}

	public float peek() { //스택에서 맨 앞 원소를 조회하는 메소드
		if(isEmpty()) { //스택이 비어 있으면 예외 발생
			throw new java.util.EmptyStackException();
		}
		else {
			return top.data; //top이 가르키고 있는 데이터가 맨 앞 데이터
		}
	}

	private class Node {
		float data;
		Node link;
	}
}

public class MyLinkedStackTest {
	public static void main(String[] args) {
		System.out.println("hw7_2: 이제헌");
		Scanner sc = new Scanner(System.in);
		boolean num = true; // 5번을 누르기 전까지 계속 무한반복을 하기 위해
		int choice; // menu 선택
		System.out.println("스택 연산 프로그램입니다.");
		MyLinkedStack st = new MyLinkedStack();
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