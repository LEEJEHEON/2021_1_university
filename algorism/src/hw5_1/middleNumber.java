package hw5_1;
import java.util.Scanner;
//***************************
//파일명: middleNumber.java
//작성자: 201625025 이제헌
//작성일: 2020.04.23
//설명: 사용자가 입력한 정수들의 중앙값을 찾는 프로그램 (partition을 이용한 선택정렬)
//***************************
class select{
	public int select_go(int data[],int start, int end, int middle) { //입력한 정수 배열
		if(start==end) //배열안에 값이 1개 있다.
			return data[start];
		int target = partition(data,start,end); //기준을 정하기 위해 partition 함수 사용
		if(target>middle) //원하는 타켓(중앙값 인덱스)보다 기준이 더 값이 큼 --> 기준을 마지막 인덱스로 하여 다시 기준을 정함
			return select_go(data,start,target-1,middle);
		else if(target==middle) // 기준과 원하는 타켓(중앙값 인덱스)이 같으면 그게 중앙값
			return data[target];
		else//원하는 타켓(중앙값 인덱스)이 기준보다 더 값이 큼 --> 시작을 기준으로 잡고 다시 기준을 정한다.
			return select_go(data,target+1,end,middle);

	}

public int partition(int data[],int start,int end){ //퀵정렬과 같음 --> 오름차순으로 정렬
		int i =start-1; //1구역 끝 (기준보다 작거나 같은 원소들)
		int j= start;  // 3구역의 시작 (아직 정해지지 않은 원소들)
		int temp; //swap 하기 위해 필요한 변수

		while (j < data.length) {
			if (data[end] >= data[j]) { // 처음 기준은 마지막 값으로 잡음 --> 기준값보다 작거나 같으면 1구역으로 보냄
 				temp = data[j];
				i++;
				data[j] = data[i];
				data[i] = temp;
			}
			j++;
		}
		if(j==data.length) { // 기준값이 가장 큰값
			j--;
		}
		if(data[i]>data[j]) { // 최종위치로 이동시키기 위해 변경
			temp=data[j];
			data[j]=data[i];
			data[i]=temp;
		}
		return i; //새로운 기준 return
	}


}

public class middleNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i; //중앙값 인덱스
		System.out.println("hw5_1 : 이제헌 \n");
		System.out.print("정수갯수 입력:");
		int num = sc.nextInt();
		int data[] = new int[num];
		System.out.print(num+"개의 정수 입력:");
		for (int n=0;n<num;n++) {
			data[n]= sc.nextInt();
		}

		if(num %2 ==0)  //num 이 짝수면 num/2 번째 작은 수
			i=(num/2)-1;
		else // 홀수면 딱 중앙에 있는값 int라서 내림으로 됨
			i=num/2;

		select se = new select(); //select 객체 생성
		int middle = se.select_go(data, 0, num-1, i); //(입력한 정수배열, 시작인덱스, 마지막인덱스, 중앙값)
		System.out.print("중앙값 = "+ middle);

	}
}
