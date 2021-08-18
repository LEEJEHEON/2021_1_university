package hw10_1;
import java.util.Scanner;
//***************************
//파일명: DirectedMatrixGraphTest.java
//작성자: 201625025 이제헌
//작성일: 2020.05.31
//설명: 방향그래프를 인접행렬로 구현하는 프로그램
//***************************
class DirectedMatrixGraph{
	private int matrix[][]; //인접행렬 배열을 가르킬 변수
	private int n; // 정점 수

	public DirectedMatrixGraph(int num) { //생성자 (사용자가 입력한 정점 수로 초기 그래프 생성)
		this.matrix = new int[num][num];
		this.n = num;
	}
	public void addEdge(int v1, int v2) {//간선 삽입 메소드
		if(v1>n-1 || v2>n-1) //입력한 정점 번호가 그래프의 정점번호보다 같거나 크면 오류
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">");
		else if (v1 == v2) { //입력한 정점 번호가 같으면 오류
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">");
		}
		else {
			if(matrix[v1][v2]==1) //1이라는 것은 이미 간선이 있다는 뜻
				System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다. <"+v1+","+v2+">");
			else
				matrix[v1][v2]=1;
		}
	}
	public void removeEdge(int v1, int v2) {//간선 삭제 메소드
		if(v1>n-1 || v2>n-1)
			System.out.println("간선 삭제 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">");
		else if (v1 == v2) {
			System.out.println("간선 삭제 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">");
		}
		else {
			if(matrix[v1][v2]==0) // 0이라는 것은 이미 간선이 없다는 뜻
				System.out.println("간선 삭제 오류 - 존재하지 않는 간선입니다. <"+v1+","+v2+">");
			else
				matrix[v1][v2]=0;
		}
	}
	public void printAdjacentVertices(int v1) { //출력메소드
		if(v1>n-1) {// 입력한 정점 번호가 그래프의 정점번호보다 크거나 같으면 오류
			System.out.println("잘못된 정점 번호입니다. <"+v1+">");
		}
		for(int a=0;a<n;a++)
			if(matrix[v1][a]==1) // 입력한 정점 번호의 인접한 정점이면 1이다.
				System.out.print(a +" ");

	}




}

public class DirectedMatrixGraphTest {
	public static void main(String[] args) {
		System.out.println("hw10_1: 이제헌");
		Scanner sc = new Scanner(System.in);
		int n1; // 삽입한 간선 수와 삭제할 간선 수를 입력할 변수
		System.out.print("정점 수 입력:");
		int n = sc.nextInt();
		DirectedMatrixGraph graph = new DirectedMatrixGraph(n); //객체 생성
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
