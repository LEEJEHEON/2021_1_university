package hw7_1;
import java.util.Scanner;
//***************************
//파일명: MyHashtableTest.java
//작성자: 201625025 이제헌
//작성일: 2020.05.12
//내용: 학번을 저장하고 검색하는 해시테이플 프로그램
//***************************
class MyHashtable{
	private int table[]; // 테이블
	private int table_size; // 테이블 크기

	public MyHashtable(int size) { //생성자
		this.table_size = size;
		this.table = new int[size]; //입력받은 크기의 table 생성
		for(int i=0;i<table_size;i++)
			table[i]=-1;  // int형 배열은 맨 처음에 다 0이 들어가 있음 그래서 -1로 다 채워넣는다. (학번은 양의정수)
	}

	public boolean put(int number) {// 삽입 메소드
		if(contains(number)) //검색했는데 값이 있으면 실패 (중복값x)
			return false;


		int j=Division(number); //해시함수를 활용하여 주소값을 얻음
		int i=0; // 충돌해결 linear probing을 위한 변수
		do { // i가 테이블을 다 돌때까지 반복 (다 돌았으면 테이블의 빈 자리가 없다는 뜻)
			j = Division(j,i); // 해시함수를 활용하여 주소값 선정
			if((table[j]==-1)||(table[j]==-2)) { //-1 은 맨처음에 -1로 바꾸었으므로 값이 없다는 뜻 , -2는 Delete 값이므로 빈칸임
				table[j]=number;
				return true;
			}
			else// 아니면 linear probing 방식이므로 +1씩 주소값 증가
				i++;
		}while(!(i==table_size));
		return false;
	}

	public boolean contains(int number) { //검색 메소드
		int j = Division(number); //해시함수를 활용하여 주소값을 얻음
		int i = 0; // 충돌해결 linear probing을 위한 변수
		do { //주소값 있는 곳이 빈칸이거나 i가 테이블 사이즈만큼 다 돌았으면 없는 것
			j=Division(j,i); // 처음은 i가 0이므로 j는 변함이 없음
			if(table[j]==number) // 찾는 값과 같으면 검색성공
				return true;
			else // 아니면 linear probing 이므로 다음주소값의 값이 있을 수 있어서 i++
				i++;
		}while(!((table[j]==-1)||(i==table_size)));
		return false;
		}

	public boolean remove(int number) { // 삭제 메소드
		if(contains(number)) { //검색메소드로 입력한 값이 없으면 삭제 실패
			int j = Division(number); // 해시함수를 활용하여 주소값 얻음
			int i = 0; //충돌해결을 위한 변수

			do { //무한히 반복 어차피 검색에서 값을 찾았기에 테이블안에는 무조건 값이 있음
				if(table[Division(j,i)]==number) { //데이터값을 찾으면 그 주소값의 -2를 넣음 (-2 = delete)
					table[Division(j,i)]=-2;
					return true;
				}
				else
					i++; // 값이 없으면 +1 하여 다음 주소칸으로 이동
			}while(true);
		}

		else
			return false;


	}


	public void print() { //출력 메소드
		System.out.println("해시테이블 내용:");
		for(int i=0;i<table_size;i++) {
			if(table[i]==-1) // -1 이면 값이 없다는 뜻
				System.out.println("["+i+"]");
			else if(table[i]==-2) // -2 이면 값을 삭제했다는 것으로 DELETED
				System.out.println("["+i+"] DELETED");
			else // 둘다 아니면 값이 있다는 것
				System.out.println("["+i+"] "+table[i]);
		}
	}

	private int Division(int number) { //해시 함수  메소드
		return number%table_size; // Division Method
	}
	//오버로딩
	private int Division(int number, int i) { //충돌해결 open addressing 중에서 linear probing
		return (Division(number)+i)%table_size;
	}

}


public class MyHashtableTest {
	public static void main(String[] args) {
		System.out.println("hw7_1: 이제헌");
		Scanner sc = new Scanner(System.in);
		System.out.print("해시테이블 크기 입력:");
		MyHashtable student = new MyHashtable(sc.nextInt()); //MyHashtable 객체생성
		int menu=0;
		while (menu!=5) { // 5번이면 종료
			System.out.print("1:삽입 2:검색 3:삭제 4:테이블출력 5:종료 --->");
			menu = sc.nextInt();
			switch(menu) {
				case 1: //삽입
					System.out.print("삽입할 학번(정수값)을 입력하세요: ");
					int number=sc.nextInt();
					if(student.put(number)) //boolean 형으로 return 된다.
						System.out.println(number+" 삽입 성공");
					else
						System.out.println(number+" 삽입 실패");
					break;
				case 2:// 검색
					System.out.print("검색할 학번(정수값)을 입력하세요: ");
					number=sc.nextInt();
					if(student.contains(number)) // boolean형으로 return
						System.out.println(number+" 학생을 찾았습니다.");
					else
						System.out.println(number+" 학생을 찾을 수 없습니다..");
					break;

				case 3: //삭제
					System.out.print("삭제할 학번(정수값)을 입력하세요: ");
					number=sc.nextInt();
					if(student.remove(number))//boolean형으로 return
						System.out.println(number+" 삭제 성공");
					else
						System.out.println(number+" 삭제 실패");
					break;
				case 4://Hashtable 출력
					student.print();
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					break;
				default :
					System.out.print("잘못 입력하셨습니다. 1~5번중에서 골라주세요.");
			}

		}

	}
}
