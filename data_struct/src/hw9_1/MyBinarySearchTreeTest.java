package hw9_1;
import java.util.Scanner;
//***************************
//파일명: MyBinarySearchTreeTest.java
//작성자: 201625025 이제헌
//작성일: 2020.05.20
//설명: 이진탐색트리를 사용하여 정수형 자료를 저장하고 검색하는 프로그램
//***************************
class MyBinarySearchTree{
	private Node root = null; //시작 루트 노드는 null 값을 가지게 함

	public boolean add(int data) { // 삽입하는 메소드
		Node p = root;
		Node q = null; //삽입할 노드의 부모노드

		while(p != null) {
			q=p;
			if(data == p.data) //키값이 중복되면 실패 (이진탐색트리 이기때문에 중복 x)
				return false;
			else if(data < p.data) //작으면 왼쪽 크면 오른쪽
				p=p.left;
			else
				p=p.right;
		}
		Node newNode = new Node(); //삽입할 노드 생성
		newNode.data = data;
		if(root==null) //이진탐색트리안에 아무런 값이 없음
			root =newNode;
		else if(data <q.data) // 작으면 왼쪽에 삽입 크면 오른쪽에 삽입
			q.left = newNode;
		else
			q.right=newNode;

		return true;
	}

	public boolean contains(int data) { //검색하는 메소드
		Node p= root;

		while(p!=null) {//p가 가르키는 값이 없을 때까지 순회
				if(data == p.data) {//입력한 값과 트리에 있는 값이 같으면 true
					return true;
				}
				else if(data < p.data){ // 사용자가 입력한 값이 더 작으면 왼쪽 자식노드로 이동함
					p = p.left;
				}
				else {
					p = p.right; //더 크면 오른쪽 자식 노드로 이동함
				}

			}
		return false;
	}


	public void print() { // 전체 출력하는 메소드
		inorder(root);  //중위 순회하는 메소드
		System.out.println();
	}

	private void inorder(Node p) {//중위 순회하는 메소드
		if(p != null) {
			inorder(p.left);
			System.out.print(" "+p.data);
			inorder(p.right);
		}
	}
	public int max() { // 최대값 출력 (매개변수가 없다.) - 루트노드가 시작이다.
		if(root == null) // 노드 자체가 없다. error
			throw new java.util.NoSuchElementException();

		Node p = root;
		int max ;
		while(p.right!=null) //제일 오른쪽에 있는 노드로 이동
				p = p.right;

		max = p.data;
		return max;

	}

	public boolean delete(int data) { //삭제하는 메소드
		Node p = root;
		Node q = null; //삭제할 노드의 부모노드
		int max ;
		if(!(contains(data))) //검색해서 삭제할 값이 트리에 있는지 확인
			return false;
		else if(p==null)  // 트리안에 아무런 노드가 없으니 실패
			return false;


		while(p!=null) {//p가 가르키는 값이 없을 때까지 순회
			if(data == p.data) {//입력한 값과 트리에 있는 값이 같으면 반복문에서 바로 나온다.
				break;
			}
			else if(data < p.data){ // 사용자가 입력한 값이 더 작으면 왼쪽 자식노드로 이동함
				q = p;
				p = p.left;
			}
			else { //더 크면 오른쪽 자식 노드로 이동함
				q = p;
				p = p.right;
			}
		}


		if(p.left == null && p.right ==null) { //단말 노드인 경우
			if(q != null) { //부모노드가 존재하면 부모노드의 왼쪽이나 오른쪽을 null로 만들어 삭제
				if(q.left==p)
					q.left = null;
				else
					q.right =null;
			}
			else // 노드가 한개 있었다.
				root = null;

		}
		else if(p.left == null || p.right ==null) { //하나의 자식 노드를 가짐
			if(q != null) { //부모노드가 존재하면
				if(p.left !=null) { // 삭제할 노드의 왼쪽 자식노드가 있다.
					if(q.left == p) //부모노드의 왼쪽 자식이면 왼쪽으로 자식노드를 이동시킴
						q.left = p.left;
					else // 오른쪽 자식이면 부모노드의 오른쪽에 이동시킨다.
						q.right = p.left;
				}
				else { // 삭제할 노드의 오른쪽에 자식노드 가 있다. (위에 것이랑 반대로 코딩)
					if(q.left ==p)
						q.left = p.right;
					else
						q.right = p.right;
				}
			}
			else //삭제할 노드가 root 노드 이다.
				if(p.left != null) //삭제할 노드의 왼쪽에 자식이 있다.
					root = p.left;
				else // 오른쪽에 자식이 있으니 왼쪽이랑 반대로 오른쪽을 연결
					root = p.right;
		}
		else { //삭제할 노드가 두개의 자식노드를 가진 경우
			Node s = p.left; // 왼쪽 서브트리에서 가장 큰 키값의 노드를 찾기 위해 변수노드 생성 (후계자 노드)
			Node s_q=null; // 후계자 노드의 부모노드

			while(s.right !=null ) { //가장 큰값을 찾기 위해 오른쪽으로 이동
				s_q =s;
				s= s.right;
			}
			if(s_q!=null) //후계자의 부모노드가 있으면
				if(s.left!=null) // 제일 오른쪽에 있는 노드이기 때문에 자식은 있다면 왼쪽만 있을 수 밖에 없음
					s_q.right = s.left; // 후계자노드의 왼쪽자식노드가 있으면 후계자 부모노드로 연결
				else
					s_q.right=null;
			else //삭제할 노드의 왼쪽 노드가 가장 큰값이다.
				if(s.left!=null) //후계자 노드의 왼쪽자식노드가 있으면 삭제할 노드의 왼쪽 노드로 연결
					p.left=s.left;
				else // 없으면 그냥 null값
					p.left=null;

			p.data = s.data; // 후계자 데이터값 이동
		}

		return true;

	}

	private class Node{
		int data;
		Node left =null;
		Node right =null;
	}
}


public class MyBinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("hw9_1: 이제헌");
		Scanner sc = new Scanner(System.in);
		int menu; // 메뉴 변수
		int key; // 트리에 넣을 int 값
		System.out.println("메뉴  번호를 입력하세요.");
		MyBinarySearchTree tree = new MyBinarySearchTree();
		do {
			System.out.print("1:삽입 2:검색 3:최대값조회 4:전체출력 5:삭제 6:종료 -->");
			menu=sc.nextInt();

			switch(menu) {
			case 1:
				System.out.print("삽입할 정수 입력:");
				key =sc.nextInt();
				if(tree.add(key))
					System.out.println(key + " 삽입 성공");
				else
					System.out.println(key + " 삽입 실패");
				break;

			case 2:
				System.out.print("검색할 정수 입력:");
				key = sc.nextInt();
				if(tree.contains(key))
					System.out.println(key + " 검색 성공");
				else
					System.out.println(key + " 검색 실패");
				break;

			case 3:
				System.out.print("최대값 =");
				System.out.println(tree.max());
				break;

			case 4:
				System.out.print("전체 출력 = ");
				tree.print();
				break;

			case 5:
				System.out.print("삭제할 정수 입력:");
				key = sc.nextInt();
				if(tree.delete(key))
					System.out.println(key + " 삭제 성공");
				else
					System.out.println(key + " 삭제 실패");
				break;

			case 6:
				System.out.println(" 프로그램을 종료 합니다. ");
				break;

			default:
				System.out.println("잘못입력하셨습니다. 1~6번중에서 입력해주세요.");
			}
		}while(!(menu==6)); //6이면 종료

	}

}
