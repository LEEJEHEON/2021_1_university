package hw11_1;
import java.util.Scanner;
//***************************
//파일명: MyInsertionSortTest.java
//작성자: 201625025 이제헌
//작성일: 2020.06.14
//설명: 삽입정렬 알고리즘을 이용하여 영어단어를 대소문자 구분없이 오름차순으로 정렬하는 프로그램
//***************************
public class MyInsertionSortTest {

	static void insertionSort(String a[]) { //삽입정렬 메소드
		String temp; // 삽입을 할 문자를 위해 잠시 저장해서 옮기는 변수
		int index;  // temp가 삽입될 위치를 저장하는 변수

		for(int i=1;i<a.length;i++) { //0 이랑 비교를 하기 때문에 1부터 시작
			temp=a[i];
			index=i; //만약 이동이 없다면 a[i]의 자리는 그대로 a[i] 이다.
			for(int j=i-1;j>-1;j--) { //i-1 부터 i랑 하나씩 비교
				if((a[j].toLowerCase()).compareTo((temp.toLowerCase()))>0) { //소문자로 변환 후 compareTo 메소드를 활요하여 비교 (안정정렬+대소문자구분x)
					a[index]=a[j]; // move
					index=index-1; // move를 했으니 -1
				}
			}
			a[index]=temp;
		}
	}

	public static void main(String[] args) {
		String word_list[]; //단어들을 저장한 배열
		int word; // 단어 갯수
		Scanner sc = new Scanner(System.in);
		System.out.println("hw11_1: 이제헌");

		System.out.print("단어 갯수 입력 : ");
		word = sc.nextInt();
		word_list = new String[word];
		System.out.print(word+"개의 단어 입력 : ");
		for(int i=0;i<word;i++) {
			word_list[i]=sc.next();
		}

		System.out.print("정렬 전 = ");
		for(int i=0;i<word;i++) {
			System.out.print(word_list[i]+" ");
		}

		insertionSort(word_list); //삽입정렬

		System.out.print("\n정렬 후 = ");
		for(int i=0;i<word;i++) {
			System.out.print(word_list[i]+" ");
		}
	}


}
