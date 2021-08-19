package hw10_2;
import java.util.Scanner;
import java.util.Stack;
//***************************
//파일명: TopologicalSort.java
//작성자: 201625025 이제헌
//작성일: 2020.06.10
//설명: DAG에 대해 topological sort를 수행하는 프로그램
//***************************
class DirectedGraph{
	private Node list[]; //인접리스트 배열을 가르킬 변수
	private int n; // 정점 수
	private boolean visited[]; // 깊이우선탐색하면서 정점에 방문한적 있는지 확인하기 위한 boolean 배열
	private Stack<Integer> topological = new Stack<>(); //위상정렬 stack
	private class Node{
		int vertex;
		Node link=null;
	}
	public DirectedGraph(int num) { //생성자 (사용자가 입력한 정점 수로 초기 그래프 생성)
		this.list = new Node[num]; //정점수만큼의 크기를 가진 노드배열 생성
		this.n = num;
		this.visited = new boolean[num];
		for(int i=0;i<num;i++) //다 false로 초기화
			visited[i]=false;
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

	public void topological() { //위상정렬 알고리즘 2 메소드
		for(int i=0;i<list.length;i++) {
			if(visited[i]==false) // 방문한적 없으면 dfs 실행
				dfs(i);
		}

		while(!(topological.isEmpty())) { // 출력
			System.out.print(" "+topological.pop());
		}
	}

	private void dfs(int v) { //깊이우선탐색
		Stack<Integer> st = new Stack<>(); //인접되어 정점들을 임시 저장하여 topological에 보내기 위한 st
		Node temp = list[v];
		if(temp==null) { //진출차수가 없다.
			visited[v]=true; //방문한적이 있으니까 true로 변경
			topological.push(v);
		}
		else {
			st.push(v); //임시 스택에 저장
			while(temp!=null) { // null이 될 때 까지 push
				st.push(temp.vertex);
				temp=temp.link;
			}

			while(!(st.isEmpty())) {//임시 스택이 비어질때까지 반복
				int x = st.pop();
				if(visited[x]==false) {//방문학적 없는 정점이면 위상정렬 stack에 넣는다.
					visited[x]=true;
					topological.push(x);
				}

			}
		}

	}


}


public class TopologicalSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("hw10_2: 이제헌");
		System.out.println("\n위상 정렬을 수행합니다. DAG를 입력하세요.");
		System.out.print("정점 수 입력:");
		int n = sc.nextInt();
		DirectedGraph graph = new DirectedGraph(n); //정점 수가 n인 방향그래프 생성
		System.out.print("간선 수 입력:");
		int n1 = sc.nextInt();

		System.out.println("\n2개의 간선 입력(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
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

		System.out.print("\n위상정렬 결과: ");

		graph.topological();




	}
}
