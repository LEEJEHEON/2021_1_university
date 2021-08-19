package hw8_2;
//*************************************
//파일명: Mypebble.java
//작성자: 201625025 이제헌
//작성일: 2020.05.28
//내용: 돌 놓기 문제(동적 프로그램 이용)
//*************************************
public class Mypebble {
	public static void main(String[] args) {
		System.out.println("hw8_2: 이제헌");
		int w [][] = {{5,2,10},{3,5,6},{-20,10,1},{10,5,-10},{10,-5,5}};
		int ped [][] = new int[5][4];
		int max;
		for(int i=0;i<4;i++)
			if(i==3)
				ped[0][i]=w[0][0]+w[0][2];
			else
				ped[0][i]=w[0][i];

		for(int i=1;i<5;i++)
			for(int j=0;j<4;j++) {
				if(j==0)// 패턴 2,3 번 중에서
					ped[i][j]=w[i][j]+((ped[i-1][1]>ped[i-1][2])? ped[i-1][1]:ped[i-1][2]);
				else if(j==1) { // 패턴 1,3,4번 중애서 큰값
					max = 0;
					if(max<ped[i-1][0])
						max=ped[i-1][0];
					if(max<ped[i-1][2])
						max=ped[i-1][2];
					if(max<ped[i-1][3])
						max=ped[i-1][3];

					ped[i][j]=w[i][j]+max;
				}
				else if(j==2)// 패턴 1,2 번 중에서 큰값
					ped[i][j]=w[i][j]+((ped[i-1][0]>ped[i-1][1])? ped[i-1][0]:ped[i-1][1]);
				else // 패턴 2 밖에 못옴
					ped[i][j]=w[i][0]+w[i][2]+ped[i-1][1];
			}

		max=0;
		for(int i=0;i<4;i++)
			if(max<ped[4][i])
				max=ped[4][i];


		System.out.println("돌 놓기 문제 최대 합은 = "+max);


	}

}
