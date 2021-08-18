package hw10_2;
import java.util.Scanner;
//***************************
//파일명: DirectedListGraphTest.java
//작성자: 201625025 이제헌
//작성일: 2020.05.31
//설명: 방향그래프를 인접리스트로 구현하는 프로그램
//***************************
class DirectedListGraph{
	private Node list[]; //인접리스트 배열을 가르킬 변수
	private int n; // 정점 수

	private class Node{
		int vertex;
		Node link=null;
	}
	public DirectedListGraph(int num) { //생성자 (사용자가 입력한 정점 수로 초기 그래프 생성)
		this.list = new Node[num]; //정점수만큼의 크기를 가진 노드배열 생성
		this.n = num;
	}
	public void addEdge(int v1, int v2) {//간선 삽입 메소드

		if(v1>n-1 || v2>n-1) //입력한 정점 번호가 그래프의 정점번호보다 같거나 크면 오류
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">");
		else if (v1 == v2) { //입력한 정점 번호가 같으면 오류
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">");
		}
		else {
			Node temp=list[v1]; //존재하는 간선이 있는지 찾기 위한 임시변수
			while(temp!=null) { //존재하는 간선이 있는지 찾음
				if(temp.vertex ==v2) {
					System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다. <"+v1+","+v2+">");
					return; //오류를 발생하였으므로 밑에 있는 것을 실행할 필요가 없어서 return
				}
				if(temp!=null)
					temp=temp.link;
			}
			Node newNode = new Node(); //새로운 노드(v2)를 생성
			newNode.vertex = v2;
			if(list[v1]!=null) //v1이 가르키고 있는 다른 간선이 있다면 그 앞에 노드를 삽입
				newNode.link=list[v1]; //앞에 삽입
			list[v1]=newNode;
		}
	}


	public void removeEdge(int v1, int v2) {//간선 삭제 메소드
		if(v1>n-1 || v2>n-1)
			System.out.println("간선 삭제 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">");
		else if (v1 == v2) {
			System.out.println("간선 삭제 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">");
		}
		else {
			Node temp = list[v1]; //삭제할 노드
			Node p = null; //삭제할 노드의 부모노드
			while(temp != null) { // v2의 값을 가진 노드를 찾기 위한 반복문
				if(temp.vertex==v2) {
					if(p==null) //그 정점이 한개의 간선만 가지고 있으면 p = null
						list[v1]=null;
					else // 아니면 삭제할 노드가 가르키고 있는 것을 부모노드가 가르키게 함
						p.link = temp.link;
				return;
				}
				p = temp;
				temp= temp.link;
			}
			// 반복문 후에도 값을 못찾았으면 오류
			System.out.println("간선 삭제 오류 - 존재하지 않는 간선입니다. <"+v1+","+v2+">");

		}
	}
	public void printAdjacentVertices(int v1) { //출력메소드
		if(v1>n-1) {// 입력한 정점 번호가 그래프의 정점번호보다 크거나 같으면 오류
			System.out.println("잘못된 정점 번호입니다. <"+v1+">");
		}
		Node temp = list[v1];
		while(temp!=null) {
			System.out.print(temp.vertex+" ");
			temp=temp.link;
		}

	}




}

public class DirectedListGraphTest {
	public static void main(String[] args) {
		System.out.println("hw10_2: 이제헌");
		Scanner sc = new Scanner(System.in);
		int n1; // 삽입한 간선 수와 삭제할 간선 수를 입력할 변수
		System.out.print("정점 수 입력:");
		int n = sc.nextInt();
		DirectedListGraph graph = new DirectedListGraph(n); //객체 생성
		System.out.print("간선 수 입력:");
		n1 = sc.nextInt();
		System.out.println("\n"+n1+"개의 간선 입력(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
		for(int a =0; a<n1;a++) {
			System.out.print("간선"+(a+1)+" 입력:");
			graph.addEdge(sc.nextInt(),sc.nextInt()); // 삽입
		}

		System.out.println();
		for(int a=0;a<n;a++) {
			System.out.print("정점 "+a+"에 인접한 정점 =");
			graph.printAdjacentVertices(a); //출력
			System.out.println();
		}

		System.out.print("\n삭제할 간선 수 입력:");
		n1 = sc.nextInt();
		System.out.println("삭제할 "+n1+"개의 간선 입력(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
		for(int a =0; a<n1;a++) {
			System.out.print("간선"+(a+1)+" 입력:");
			graph.removeEdge(sc.nextInt(),sc.nextInt()); //삭제
		}

		System.out.println();
		for(int a=0;a<n;a++) {
			System.out.print("정점 "+a+"에 인접한 정점 =");
			graph.printAdjacentVertices(a); //출력
			System.out.println();
		}
	}
}
