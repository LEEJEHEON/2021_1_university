package hw5_2;
import java.util.Scanner;
//***************************
//파일명: MyArrayListTest_2.java
//작성자: 201625025 이제헌
//작성일: 2020.04.08
//설명: 리스트에 사용자가 메뉴를 선택하여 삽입을 하거나, 원하는 자리에 삽입을 하거나, 원하는 자리의 원소를 삭제하거나, 조회를 하는 프로그램
//***************************
class MyArrayList{
	private int a[];
	private int array_len;
	private int shape=10; // 배열의 크기를 유동적으로 움직일 변수
	private int add_shape=10; // 정수배열을 두배로 증가시켜줄 변수

  public MyArrayList() {// 생성자
  	this.a = new int[shape];  // 처음 크기는 10
  	this.array_len = 0;
  }
  public boolean add(int num) {
  	if(array_len < shape) {
  		a[array_len] = num;
  		array_len ++;
  		return true;
  	}
  	else {
  		System.out.println("배열이 가득차 크기를 2배로 늘립니다.");
  		 int b[] = new int[shape+add_shape]; // 옵션 1 : 두배로 확장한 배열을 생성
		  for (int m=0;m<array_len;m++) // 값을 다 옮긴다
			  b[m]=a[m];
		  shape +=add_shape; // 두배 값을 shape에 넣는다.
		  add_shape = shape; // 늘릴 때 또 두번로 하기 위해
		  a = b; // 배열 b를 a로 덮음
		  a[array_len]=num;
		  array_len ++;
  		return true;
  	}
  }
  @Override
	public String toString(){
  	String list ="";
  	for(int m=0;m<array_len;m++) {
  		list += a[m];
  		list += " ";
  	}
  	return "list = "+list;
  }
  //overloading
  public boolean add(int index, int num) {  // 사용자 입력한 인덱스 자리에 사용자가 입력한 정수값을 넣는 메소드
	  if(index>array_len||index<0) { // 옵션 2 : 사용자가 입력한 index가 리스트 길이보다 크거나 0보다 작으면 에러 발생
		  throw new ArrayIndexOutOfBoundsException();
	  }
	  if(array_len!=shape) { // 옵션 1 : 배열이 가득찼는지 확인
		array_len ++;
		for(int m=array_len-1;m>index;m--) { // 마지막 값부터 한칸씩 다 뒤로 이동
			a[m]=a[m-1];
		}
		a[index]=num;
		return true;
		}
	  else { // 배열이 가득 차 있는 상태
		  System.out.println("배열이 가득차 크기를 2배로 늘립니다.");
		  int b[] = new int[shape+add_shape];
		  for (int m=0;m<array_len;m++)
			  b[m]=a[m];
		  shape +=add_shape;
		  add_shape = shape;
		  a = b;
		  array_len ++;

		  for(int m=array_len-1;m>index;m--) // index 자리를 제외하고 한칸씩 다 뒤로 이동
			  a[m]=a[m-1];
		  a[index]=num;
		  return true;
	  }

  }

  public int remove(int index) { // 입력한 인덱스 값에 있는 원소를 삭제하는 메소드
	  if(index>=array_len||index<0) { // 옵션2 : 에러 발생
		  throw new ArrayIndexOutOfBoundsException();
	  }

	  int data =  a[index]; // 출력하기 위해 삭제할 원소를  data 변수에 넣음
	  array_len --;

	  if (array_len!=index) {// 같으면 인덱스 마지막 값만 삭제 하면 된다.
		  for(int m=index;m<array_len;m++) // 사용자가 입력한 인덱스 값 + 1 의 위치에 있는원소들부터 다 앞으로 한칸씩 당긴다.
			  a[m]=a[m+1];
		  }
	  return data;
  }
}

public class MyArrayListTest_2 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("hw5_2:이제헌");
		System.out.println("정수 리스트 프로그램입니다. 메뉴를 선택하세요.");
		MyArrayList Alist = new MyArrayList(); //객체 생성

		while(true) {  // 5 를 입력하기 까지 무한 반복
			System.out.print("1:삽입 2:인덱스 삽입 3:인덱스 삭제 4:전체조회 5:종료 -->");
			int n = scanner.nextInt();
			switch(n){
				case 1 :
					System.out.print("삽입할 정수 입력:");
					Alist.add(scanner.nextInt());
					break;
				case 2 :
					System.out.print("인덱스와 삽입할 정수 입력:");
					try {
					Alist.add(scanner.nextInt(), scanner.nextInt());
					}
					catch (ArrayIndexOutOfBoundsException e){
						System.out.println("인덱스를 잘못 입력 하셨습니다.");
					}
					break;
				case 3 :
					System.out.print("삭제할 리스트의 인덱스를 입력:");
					try {
					System.out.println("삭제한 정수: "+Alist.remove(scanner.nextInt()));
					}
					catch (ArrayIndexOutOfBoundsException e){
						System.out.println("인덱스를 잘못 입력 하셨습니다.");
					}
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
