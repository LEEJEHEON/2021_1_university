package hw6_1;
import java.util.Scanner;
//***************************
//파일명: MyBinarySearchTreeTest.java
//작성자: 201625025 이제헌
//작성일: 2020.05.01
//내용: 아이디를 관리하는 이진검색트리 프로그램
//***************************

class MyBinarySearchTree{
	private Node root;
	private int ID_num ;

	public void MyBinarySearchTree() { //생성자
		this.root = null;
		this.root.right=null;
		this.root.left=null;
		this.ID_num=0;
	}

	public void print() { //트리의 저장된 ID값들을 출력하는 메소드
		inorder(root); //중순위하는 private메소드 출력
		System.out.println();
	}

	public int size() { //트리의 ID가 몇개가 저장이 되어있는지 출력하는 메소드
		return this.ID_num;
	}

	public boolean contains(String id) { //사용자가 입력한 id가 트리안에 있는지 검색하는 메소드
		Node temp = root;
		if(ID_num==0) { //갯수가 0개 이므로 트리안에 값이 없음
			return false;
		}
		while(temp!=null) {//temp가 가르키는 값이 없을 때까지 순회
				if(id.compareTo(temp.id)==0) {//입력한 id값과 트리에 있는 id값이 같으면 true
					return true;
				}
				else if(id.compareTo(temp.id)<0){ // 사용자가 입력한 값이 더 작으면 왼쪽 자식노드로 이동함
					temp = temp.left;
				}
				else {
					temp = temp.right; //더 크면 오른쪽 자식 노드로 이동함
				}

			}
		return false; //같은 값이 없다.
	}


	public boolean add(String id) { //삽입하는 메소드
		Node newnode = new Node(id); //객체생성
		if(contains(id)) { // 중복된 값이 있으므로 false
			return false;
		}
		else if(root==null) {//root가 null값이라는 것은 트리에 아무런 값이 없다는 뜻
			root=newnode;
			this.ID_num++;
			return true;
		}
		Node temp =root; //삽입할 곳을 가르키는 노드
		Node parent;//삽입할 노드의 부모노드
		while(true){ //무한반복
			parent = temp;

			if(id.compareTo(root.id)<0) { //값이 작으면 왼쪽으로 이동
				temp = temp.left;
				if(temp==null) {//노드가 비어있으면 부모노드인 parent를 이용하여 연결
					parent.left=newnode;
					this.ID_num++; //갯수 증가
					return true; //성공
				}
			}
			else {//크면 오른쪽으로 이동
				temp = temp.right;
				if(temp==null) {
					parent.right=newnode;
					this.ID_num++;
					return true;
				}
			}
		}
	}

	private void inorder(Node root) { //중순위하는 private 메소드 (오름차순으로 출력된다.)
		if(root!=null) { //null이면 값이 없으므로 end
			inorder(root.left); // 작은 값부터 출력
			System.out.print(root.id+" "); //가운데 값
			inorder(root.right); //큰값
		}
	}


	private class Node{
		Node right;
		Node left;
		String id;

		private Node(String id) {
			this.id = id;
			this.left=null;
			this.right=null;
		}
	}

}

public class MyBinarySearchTreeTest {

	public static void main(String[] args) {
		System.out.println("hw6_1: 이제헌");
		System.out.println("아이디를 관리하는 이진검색트리 프로그램입니다.");
		int menu=0;
		Scanner sc = new Scanner(System.in);
		MyBinarySearchTree BST = new MyBinarySearchTree();
		while(menu != 5 ) { //5번은 종료
			System.out.println("1:삽입 2:검색  4:전체조회 5:종료");
			menu = sc.nextInt();
			switch(menu) {
				case 1:
					System.out.println("삽입할 아이디(문자열)를 입력하시오");
					if(BST.add(sc.next()))
						System.out.println("삽입 성공");
					else
						System.out.println("삽입 실패");

					break;

				case 2:
					System.out.println("검색할 아이디(문자열)를 입력하시오");
					if(BST.contains(sc.next()))
						System.out.println("입력하신 아이디가 있습니다");
					else
						System.out.println("입력하신 아이디가 없습니다.");
					break;

				case 4:
					System.out.print("트리에 저장된 ID 갯수 : "+BST.size() +"\n트리에 있는 아이디들 : ");
					BST.print();
					break;

				case 5:
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 1~5사이의 정수를 입력해주세요.");
			}



		}



	}
}


