package hw0_2;
import java.util.Scanner;

public class hw0_2 {
	public static void main(String[] args) {
		System.out.println("hw0_1 : 이제헌");
		System.out.println("양의 정수 집합을 비교하는 프로그램입니다");
		int count[] = {0,0};  // 두 개의 집합의 길이를 비교
		int a[]=new int[100];
		int b[]=new int[100];
		int index=0;   //배열의 인덱스
		Scanner scanner=new Scanner(System.in);
		System.out.print("첫번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 정수를 입력하세요 :");
		// 입력 반복문
		while(true){  // 음수가 없는한 최대 100개 까지 무한반복
			if (index == 100) {  // 원소 100개 차서 100개까지만 저장하고 break
				System.out.println("집합의 원소는 최대 100개 까지 가능합니다. 다음 집합으로 넘어갑니다.");
				break;
			}
			a[index]=scanner.nextInt();
			if (a[index] < 0)  // 음수가 입력되면 break
				break;
			count[0] +=1; // a 배열에서 입력된 정수만큼의 길이를 저장
			index +=1;
		}

		index=0;
		System.out.print("두번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 정수를 입력하세요 :");
		while(true){
			if (index == 100) { // 첫번째와 똑같이 100개까지만 저장하고 break
				System.out.println("집합의 원소는 최대 100개 까지 가능합니다. 비교로 넘어갑니다.");
				break;
			}
			b[index]=scanner.nextInt();
			if (b[index] < 0) // 음수가 입력되면 break
					break;
			count[1] +=1; // b 배열에서 입력되 정수만큼의 길이를 저장
			index +=1;
		}
		//비교 반복문
		if (count[0] == count[1]) { // 두 집합의 길이가 같다.
			for (index=0;index<count[0];index++) { // 입력된 길이만큼 반복
				for(int index_two=0;index_two<count[1];index_two++) // 첫번째 집합을 기준으로 두번째와 같은지 비교
					if (a[index]==b[index_two]) // 같은 것이 있으면 break
						break;
					else if(index_two+1 == count[1]) {  // 두번째 집합에 마지막까지 찾아보았는데 없었으니 서로 다른걸 확인
						System.out.println("두 집합은 서로 다릅니다.");
						System.exit(0); // 바로 종료
				}
			}
			for (index=0;index<count[0];index++) {
				for(int index_two=0;index_two<count[1];index_two++) // 두번째 집합을 기준으로 첫번째와 같은지 비교
					if (b[index]==a[index_two])
						break;
					else if(index_two+1 == count[1]) { // 첫번째 집합의 마지막까지 찾아보았는데 없었으니 서로 다른 걸 확인함
						System.out.println("두 집합은 서로 다릅니다.");
						System.exit(0); // 바로 종료
				}
			}

		}
		else //길이가  같지 않으면 두 집합은 서로 다름
			System.out.println("두 집합이 서로 다릅니다.");

		System.out.println("두 집합은 서로 같습니다.");
	}
}
