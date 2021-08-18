package hw6_1;
//***************************
//파일명: MyLinkedListTest.java
//작성자: 201625025 이제헌
//작성일: 2020.04.13
//설명: 연결 자료구조 프로그램
//***************************
class MyLinkedList {
	private Node start; // 맨처음노드를 가르킬 시작노드
	public MyLinkedList() { //생성자
		start = null;
	}

	public void printList() { // 리스트 출력 메소드
		Node temp = this.start;
		System.out.printf("L= (");
		while(temp != null) {  // 리스트의 마지막 노드까지 반복
			System.out.printf(temp.getData());
			temp = temp.link;
			if(temp != null) {
				System.out.printf(",");
			}
		}
		System.out.println(")");

	}
	public void insertLast(String data) { // 리스트의 마지막 노드 삽입 메소드
		Node newNode = new Node(data);
		if(start==null) { // 공백리스트
			this.start = newNode;
		}
		else {
			Node temp = start;
			while(temp.link != null) temp = temp.link; //마지막 노드를 찾기 위한 반복문
			temp.link = newNode;
		}
	}
	public void insertFirst(String data) { // 리스트의 첫번째 노드 삽입 메소드
		Node newNode = new Node(data);
		if(start==null) {// 공백리스트
			this.start = newNode;
		}
		else { // 순서 중요
			newNode.link=start;
			this.start= newNode;
		}

	}
	public void insertMiddle(String data1,String data2) { // 리스트의 중간 노드 삽입 메소드
		Node newNode = new Node(data2); // 삽입할려는 데이터
		Node pre = searchNode(data1);// 앞 노드(data1)를 찾기 위해
		if(pre == null)
			System.out.println("검색실패>>"+data1+" 이라는 데이터가 없습니다.");
		newNode.link =pre.link; // 순서중요
		pre.link = newNode;
	}
	public void deleteLast() { //리스트의 노드 삭제 메소드
		Node pre, temp;
		if(start == null) return; // 공백리스트라서 노드가 없음
		if(start.link == null) {// 노드가 1개밖에 없다.
			start = null;
		}
		else {
			pre = start; // 첫번째 노드의 주소
			temp = start.link; // 두번째 노드의 주소
			while(temp.link!=null) { //마지막 노드를 찾을 때까지 반복
				pre=temp;
				temp = temp.link;
			}
			pre.link = null; // null를 넣어 삭제
		}
	}
	public void reverseList() { //리스트의 순서를 반대로 만드는 메소드
		Node next =start;
		Node current=null;
		Node pre = null;
		while(next != null) {
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		start = current;
	}
	private Node searchNode(String data) { //그 값이 리스트에 있는지 검색해주는 서포트 메소드
		Node temp = this.start;
		while(temp != null) {
			if(data == temp.getData()) // 찾는 데이터와 일치하는지 화인
				return temp;
			else temp = temp.link;
		}
		return temp;
	}


	private class Node{  // 노드 생성 클래스
		private String data; // 데이터값
		public Node link; // 링크값 : 다음노드랑 연결하기 위한
		public Node() {
			this.data=null;
			this.link=null;
		}
		public Node(String data) {
			this.data=data;
			this.link=null;
		}
		public Node(String data,Node link) {
			this.data=data;
			this.link=link;
		}
		public String getData() {
			return this.data;
		}


	}

}


public class MyLinkedListTest {

	 public static void main(String[] args) {
		   System.out.println("hw6_1: 이제헌");

		   MyLinkedList list = new MyLinkedList();
		   System.out.println("공백리스트에 원소 3개 삽입");
		   list.insertLast("화");

		   list.insertLast("수");

		   list.insertLast("금");
		   list.printList();

		   System.out.println("리스트의 맨 앞에 월 삽입");
		   list.insertFirst("월");
		   list.printList();

		   System.out.println("수 다음에 목 삽입");
		   list.insertMiddle("수","목");
		   list.printList();

		   System.out.println("리스트의 마지막 원소 삭제");
		   list.deleteLast();
		   list.printList();

		   System.out.println("리스트를 역순으로 바꾸기");
		   list.reverseList();
		   list.printList();
		 }
}
