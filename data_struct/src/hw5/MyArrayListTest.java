package hw5;
import java.util.Scanner;
//***************************
//파일명: MyArrayListTest.java
//작성자: 201625025 이제헌
//작성일: 2020.04.03
//설명: 최대길이가 10인 리스트에 사용자가 메뉴를 선택하여 삽입을 할 수도 있고, 전체조회를 할 수 있는 프로그램
//***************************
class MyArrayList{
	private int a[];
    private int array_len;

    public MyArrayList() {
    	this.a = new int[10];
    	this.array_len = 0; // 입력된 리스트의 길이
    }
    public boolean add(int num) {
    	if(array_len < 10) {  // 입력된 리스트의 길이가 10 미만이면 입력
    		a[array_len] = num;
    		array_len ++;  // 입력되었으니 1을 증가
    		return true;
    	}
    	else { // 최대갯수 10개를 초과하여 에러
    		System.out.println("ERROR:"+num+ "삽입 실패");
    		return false;
    	}
    }
    @Override
	public String toString(){
    	String list ="";  // 리스트를 출력하기 위한 문자열
    	if(array_len==0)  // array_len이  0이라는것은 아무것도 입력을 안한 상태
	    		return "list = ";

    	for(int m=0;m<array_len;m++) { // 길이만큼 반복을 하여 배열의 값을 list문자열변수에 값을 넣는다.
    		list += a[m];
    		list += " ";
    	}
    	return "list = "+list;
    }

}

public class MyArrayListTest {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("hw5_1:이제헌");
		System.out.println("정수 리스트 프로그램입니다. 메뉴를 선택하세요.");
		MyArrayList Alist = new MyArrayList(); //객체 생성

		while(true) {  // 5 를 입력하기 까지 무한 반복
			System.out.print("1:삽입 4:전체조회 5:종료 -->");
			int n = scanner.nextInt();
			switch(n){
				case 1 :
					System.out.print("삽입할 정수 입력:");
					Alist.add(scanner.nextInt());
					break;
				case 4 :
					System.out.println(Alist.toString());
					break;

				case 5 :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);  // 프로그램 종료
			}
		}
	}
}
