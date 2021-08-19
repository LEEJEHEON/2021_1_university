package hw8_1;
import java.util.Scanner;
//*************************************
//파일명: MymatrixPath.java
//작성자: 201625025 이제헌
//작성일: 2020.05.24
//내용: 행렬 경로 문제를 푸는 프로그램(동적 프로그램 이용)
//*************************************
public class MymatrixPath {
	public static void main(String[] args) {
		System.out.println("hw8_1: 이제헌");
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 입력 : ");
		int n = sc.nextInt();
		int c[][] =new int[n+1][n+1]; // 행렬 경로 문제를 풀기 위한 배열
		int temp[][]= new int[n][n]; //입력한 원소들을 저장할 배열
		System.out.println(n+" x "+n+"크기의 행렬 원소 입력:");
		for(int i=0;i<temp.length;i++)
			for(int j=0;j<temp.length;j++)
				temp[i][j]=sc.nextInt(); //입력한 정수들 temp 배열의 저장

		for(int i=1;i<c.length;i++)
			for(int j=1;j<c.length;j++) {
				c[i][j]= temp[i-1][j-1]+((c[i-1][j]>c[i][j-1]) ?c[i-1][j] : c[i][j-1]); //비교후 큰 값이랑 기존의 값이랑 더함
			}

		System.out.println("\n최대 점수 ="+c[n][n]);

		//선택과제
		System.out.print("최대 점수 경로=");
		int i=1,j=1; // (1,1) 부터 시작
		while((i!=n+1) && (j!= n+1)) { // 최대 점수 인덱스까지 반복
			System.out.print("("+i+","+j+")");
			if(i==n) // i,n 이 같다는 것은 위치가 배열 맨 밑에 있으니까 오른쪽으로 이동만 하면 된다.
				j +=1;
			else if(j==n) //j,n 이 같다는 것은 위치가 배열 제일 오른쪽에 있으니 밑으로 이동만 하면 된다.
				i +=1;
			else {
				if(c[i+1][j]>c[i][j+1]) //오른쪽 원소와 밑 원소중 큰 값 비교
					i += 1;
				else
					j += 1 ;
			}

	}
}
}