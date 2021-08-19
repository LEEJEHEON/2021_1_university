package hw12_1;
import java.util.HashMap;
import java.util.Scanner;
//***************************
//파일명: BoyerMooreHorspool.java
//작성자: 201625025 이제헌
//작성일: 2020.06.18
//설명: 보이어-무어-호스풀 알고리즘을 이용한 문자열 매칭 프로그램
//***************************
public class BoyerMooreHorspool {
	public static void main(String[] args) {
		System.out.println("hw12_1: 이제헌");
		Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> jump = new HashMap<>(); //hashmap 이용 (딕셔너리 역할)
		int jump_count =0; //점프수를 출력할 변수

		System.out.print("패턴 입력 : ");
		String str1 = sc.next();
		String[] jumptext = str1.split(""); //패턴문자열을 문자로 나눠서 배열에 넣는다.
		for(int i=0;i<jumptext.length;i++) { //점프정보 입력 (같은 문자는 자동으로 덮어씌어준다.)
			if(i == jumptext.length-1) //마지막 문자
				if(jump.get(jumptext[i])==null) //마지막 문자가 새로운 값이면 PUT
					jump.put(jumptext[i],jumptext.length);
				else // 마지막 문자가 이미 put한 문자라면 그대로 나간다.
					break;
			else
				jump.put(jumptext[i],jumptext.length-(i+1));
		}
		jump.put("기타",jumptext.length); //마지막 기타 추가


		int n = jumptext.length-1; //텍스트 문자와 비교하면서 리드할 변수 (초기값은 오른쪽부터 비교하기 때문에 패턴의 끝 값 인덱스)

		System.out.print("텍스트 입력: ");
		String str2 = sc.next();
		String[] text =str2.split(""); //split 하여 배열로 만듬

		System.out.print("매칭 위치 = ");

		while(n < text.length) { //n 변수가 text 보다 크면 범위를 벗어났다는 뜻이므로 종료


			for(int i =0 ;i <= jumptext.length ;i++) { //패턴과 텍스트를 비교하는 반복문

				if(i==jumptext.length) { //i와 패턴 길이가 같다는 것은 그 패턴이 텍스트에 있다는 뜻
					System.out.print((n-i+1)+" "); // 매칭위치 출력
				}
				else if(text[n-i].equals(jumptext[jumptext.length-i-1])) { //비교해서 같으면  바로 continue해서 다음 문자열
					continue;
				}

				for(int j=0;j<jumptext.length;j++) { //점프 정보 값을 n에 넣기 위한 반복문
					if(text[n].equals(jumptext[j])) { //점프정보 안에 n인덱스의 값이 있다면 점프정보의 키값을 이용해서 n을 더함
						n = n+jump.get(text[n]);
						jump_count ++;//점프수
						break;
					}
					if(j+1==jumptext.length) { // 점프정보안에 없는 문자라면 기타로 더한다.
						n=n+jump.get("기타");
						jump_count ++;//점프수
					}
				}
				break;
			}
		}
		System.out.print("\n점프 수 = "+jump_count);
	}
}
