package hw7_2;
import java.util.Scanner;
//***************************
//파일명: MyHashtableChaining.java
//작성자: 201625025 이제헌
//작성일: 2020.05.13
//내용: 학번과 성적을 저장하고 학번을 통해서 검색하는 해시테이플 프로그램
//***************************
class MyHashtable{
	private Node table[]; // 테이블
	private int table_size; // 테이블 크기

	public MyHashtable(int size) { //생성자
		this.table_size = size;
		this.table = new Node[size]; //입력받은 크기의 Node 배열 생성
	}

	public void put(int key, int grade) {// 삽입 메소드
		Node newnode = new Node(key,grade); //새로운 노드를 생성
		int j=Division(key); //해시함수를 활용하여 주소값을 얻음
		if(get(key)==-1) { //-1 이면 값이 없다는 뜻 (새롭게 삽입을 해야한다.)

			if(table[j]==null) {// 공백이라서 새로운 노드 연결만 시키면 된다.
				this.table[j] = newnode;
			}
			else { // 맨앞으로 넣는다.
				newnode.link=table[j];
				this.table[j]= newnode;
			}

		}
		else { //학번이 있다는 뜻이라서 갱신을 해야한다.
			Node temp = table[j]; //찾기 위해 만든 변수 노드의 루트노드를  넣음
			while(temp!=null) {//공백까지
				if(temp.getkey()==key) { //사용자가 입력한 key와 테이블의 있는 key값이 같으면
					temp.grade = grade; //사용자가 입력한 grade값으로 변경
					return; //변경하였으니 바로 return 굳이 끝까지 갈 필요가없다.
				}
				else // 아니면 한칸씩 전진
					temp = temp.link;
			}

		}


	}

	public int get(int key) { //검색한 키의 성적을 return하는 메소드
		int j = Division(key); //해시함수를 활용하여 주소값을 얻음
		Node temp = table[j]; //찾기 위해 temp node를 이용하여 접근

		while(temp!=null) { //temp가 null이 될때까지 반복
			if(key == temp.getkey()) //키값이 같으면 성적 return
				return temp.getgrade();
			temp = temp.link; // 아니면 앞으로 전진
		}

		return -1; //키값이 테이블의 없다는 뜻임
		}

	public boolean remove(int key) { // 삭제 메소드
		int j = Division(key); //해시함수를 활용해서 주소값을 얻음
		Node pre; // 삭제할 노드의 앞노드
		Node temp=table[j]; // 삭제할 노드

		if(get(key)==-1)  //-1이면 값이 없다는 뜻이므로 사용자가 입력한 key값이 테이블의 없음
				return false;
		else {
			if(temp == null) return false; // 공백이라서 노드가 없음
			if(temp.link == null) {// 노드가 1개밖에 없다.
				table[j] = null;
			}
			else {// 같은 주소값을 가지는 노드가 2개이상이다.
				if(temp.getkey()==key) { //맨 앞 노드일 경우
					table[j]=temp.link;
					return true;
				}
				pre = temp; // 첫번째 노드
				temp = temp.link; // 두번째 노드
				while(temp!=null) {
					if(temp.getkey()==key) {
						pre.link=temp.link; //삭제할 노드의 전 노드를 삭제할 노드 다음 노드로 연결시킴
						return true;
					}
					// 한칸씩 앞으로 전진
					pre=temp;
					temp = temp.link;
				}
			}
			return true;
		}
	}


	public void print() { //출력 메소드
		System.out.println("해시테이블 내용:");
		for(int i=0;i<table_size;i++) {
			if(table[i]==null) // null 이면 값이 없다는 뜻
				System.out.println("["+i+"]");
			else {// 값이 있다는 것
				Node temp = table[i]; // temp를 이용하여 순회
				System.out.print("["+i+"]");
				while(temp!=null) { // temp가 null이 될때 까지
					System.out.print("학번 :"+ temp.getkey()+" 성적 :"+temp.getgrade());
					temp=temp.link; // 한칸 전진
					System.out.print("/"); // 구분하기 위해
				}
				System.out.println();
			}
		}
	}

	private int Division(int number) { //해시 함수  메소드
		return number%table_size; // Division Method
	}

	private class Node{ // 충돌해결 방법이 chaining이라서 노드 메소드 생성
		Node link =null;
		int key;
		int grade;
		public int getgrade() {
			return this.grade;
		}
		public int getkey() {
			return this.key;
		}
		public Node(int key,int grade) {
			this.key=key;
			this.grade=grade;
			this.link=null;
		}

	}


}


public class MyHashtableChaining {
	public static void main(String[] args) {
		System.out.println("hw7_2: 이제헌");
		Scanner sc = new Scanner(System.in);
		System.out.print("해시테이블 크기 입력:");
		MyHashtable student = new MyHashtable(sc.nextInt()); //MyHashtable 객체생성
		int menu=0;
		while (menu!=5) { // 5번이면 종료
			System.out.print("1:삽입 2:검색 3:삭제 4:테이블출력 5:종료 --->");
			menu = sc.nextInt();
			switch(menu) {
				case 1: //삽입
					System.out.print("삽입할 학번과 성적을 입력하세요: ");
					int key=sc.nextInt();
					int grade = sc.nextInt();
					if(key > 0)
						student.put(key,grade);
					else
						System.out.println("학번은 양의 정수만 올 수 있습니다.");
					break;
				case 2:// 검색
					System.out.print("검색할 학번(정수값)을 입력하세요: ");
					key=sc.nextInt();
					if(student.get(key)==-1) // boolean형으로 return
						System.out.println(key+"의 학생은 없습니다.");
					else
						System.out.println(key+"의 성적은 "+student.get(key));
					break;

				case 3: //삭제
					System.out.print("삭제할 학번(정수값)을 입력하세요: ");
					key=sc.nextInt();
					if(student.remove(key))//boolean형으로 return
						System.out.println(key+" 삭제 성공");
					else
						System.out.println(key+" 삭제 실패");
					break;
				case 4://Hashtable 출력
					student.print();
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					break;
				default :
					System.out.print("잘못 입력하셨습니다. 1~5번중에서 골라주세요.");
			}

		}

	}
}