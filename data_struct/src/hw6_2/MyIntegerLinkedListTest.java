package hw6_2;
import java.util.Scanner;
//***************************
//파일명: MyIntegerLinkedListTest.java
//작성자: 201625025 이제헌
//작성일: 2020.04.22
//설명: 리스트에 사용자가 메뉴를 선택하여 정수 리스트의 맨앞삽입을 하거나,맨앞삭제을 하거나,원하는 원소를 삭제하거나,조회를 하는 프로그램
//***************************
class MyIntegerLinkedList{
	private Node start; // 맨처음노드를 가르킬 시작노드

	public MyIntegerLinkedList() { //생성자
		start = null; // 맨처음에는 null값을 가짐
	}

	public void addFirst(int data) { // 리스트의 맨앞삽입을 하는 메소드
		Node newNode = new Node(data);
		if(start==null) {// 공백리스트
			this.start = newNode;
		}
		else {
			newNode.link=start;
			this.start= newNode;
		}

	}

	public int removeFirst() { //리스트 맨앞삭제 메소드
		Node temp;

		if(start == null)  // 공백리스트라서 에러메세지 출력
			 throw new java.util.NoSuchElementException();

		if(start.link == null) { //노드가 1개밖에 없다.
			temp = start;
			start = null;
			return temp.getData();
		}
		else {
			temp = start; //첫번째 노드의 주소
			start = temp.link; // 두번째 노드의 주소
			return temp.getData();
		}
	}

	public boolean remove(int data) { //원하는 데이터 삭제하는 메소드
		Node pre = this.start; // 삭제할 노드의 앞 노드
		Node temp = this.start; // 삭제할 노드
		if(start == null) { // 공백리스트
			return false;
		}
		else if(contains(data)) { // 검색 메소드로 확인 있으면 true
			while(temp != null) {
				if(data == temp.getData()) { // 찾는 데이터와 일치하는지 화인
					if(start==temp) { // start가 가르키는 첫번째 노드이면 start를 조정
						start =temp.link;
						return true;
					}
					else {
						pre.link=temp.link;
						return true;
					}
				}
				else {
					pre = temp;
					temp = temp.link;
				}
			}
			return false; // 데이터가 없음
		}
		else
			return false; // 데이터가 없음
	}

	public boolean contains(int data) { //그 값이 리스트에 있는지 검색해주는 메소드
		Node temp = this.start;
		while(temp != null) {
			if(data == temp.getData()) // 찾는 데이터와 일치하는지 화인
				return true;
			else temp = temp.link;
		}
		return false;
	}

	@Override
	public String toString() { // 리스트 출력 메소드
		Node temp = this.start;
		String list="";
		while(temp != null) {  // 리스트의 마지막 노드까지 반복
			list  += (Integer.toString(temp.getData()));
			temp = temp.link;
			list +=" ";
		}
		return "list = "+ list;
	}

	private class Node{  // 노드 생성 클래스
		private int data; // 데이터값
		public Node link; // 링크값 : 다음노드랑 연결하기 위한
		public Node() {
			this.data=0;
			this.link=null;
		}
		public Node(int data) {
			this.data=data;
			this.link=null;
		}
		public Node(int data,Node link) {
			this.data=data;
			this.link=link;
		}
		public int getData() {
			return this.data;
		}


	}
}


public class MyIntegerLinkedListTest {

	public static void main(String[] args) {
		System.out.println("hw6_2: 이제헌");
		System.out.println("정수 단순연결리스트 프로그램입니다. 메뉴를 선택하세요.");
		MyIntegerLinkedList list = new MyIntegerLinkedList(); //MyIntegerLinkedList 객체생성
		Scanner sc = new Scanner(System.in);
		boolean num = true; //무한 반복을 위한 변수
		while(num) {
			System.out.print("1:맨앞삽입 2:맨앞삭제 3:값삭제 4:값조회 5:전체조회 6:종료 --> ");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.print("맨 앞에 삽입할 정수 입력:");
					list.addFirst(sc.nextInt());
					break;
				case 2:
					System.out.println("삭제한 맨 앞 정수 ="+list.removeFirst());
					break;
				case 3:
					System.out.print("삭제할 정수 입력:");
					int delete = sc.nextInt();
					if(list.remove(delete)) //true를 반납하므로
						System.out.println(delete+ " 삭제 성공");
					else
						System.out.println(delete +" 삭제 실패");
					break;
				case 4:
					System.out.print("조회할 정수 입력:");
					int search = sc.nextInt();
					if(list.contains(search))//true를 반납하므로
						System.out.println( search+" 검색 성공");
					else
						System.out.println("입력하신 데이터가 없습니다.");
					break;
				case 5:
					System.out.println(list.toString());
					break;
				case 6:
					System.out.println("프로그램을 종료합니다.");
					num = false; // 반복 중지 -> 시스템 종료
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 1~6 번중에서 다시 골라주새요.");

			}
		}
	}
}
