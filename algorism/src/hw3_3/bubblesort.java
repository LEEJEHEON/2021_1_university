package hw3_3;
import java.util.Scanner;
//***************************
//파일명: hw3_3.java
//작성자: 201625025 이제헌
//작성일: 2020.04.10
//설명: 학생정보를 입력받아 버블정렬로 성적을 기준으로 내림차순 정렬을 하는 프로그램
//***************************
class Student{
	private String name; //학생 이름
	private int student_number; // 학번
	private float grades; //학생 성적

	public Student(String name, int number, float grade) { // 사용자가 입력한 학생정보를 class Student 변수에 넣는다.
		this.name = name;
		this.student_number = number;
		this.grades = grade;
	}
	public float getgrades() { // private grades을 추출하기 위한 메소드
		return grades;
	}
	public String getname() { // private name을 추출하기 위한 메소드
		return name;
	}
	public int getnumber() {
		return student_number;
	}

}


public class bubblesort {
	public static void main(String[] args) {
		Student temp; //임시저장을 위해 생성
		String name; //이름
		int number; // 학번
		float grade; // 성적
		Scanner scanner=new Scanner(System.in);
		System.out.println("hw3_3:이제헌");
		System.out.print("학생 수 입력 :");
		int n = scanner.nextInt();
		Student student[] = new Student[n]; // 객체배열을 생성
		System.out.println(n+"명의 학생 정보를 입력하세요:");
		for (int a=0;a<n;a++) {
			name = scanner.next();
			number = scanner.nextInt();
			grade = scanner.nextFloat();
			student[a]=new Student(name,number,grade); // 원소 객체 생성
		}
		//버블정렬 알고리즘
		for (int j=0;j<n;j++) {
			for (int i=0;i<n-1-j;i++) {
				if (student[i].getgrades()<student[i+1].getgrades()) { // 내림차순
					temp = student[i];
					student[i]=student[i+1];
					student[i+1]=temp;
				}
			}
		}

		System.out.println("성적 내림차순 정렬 결과 =");
		for (int a=0;a<n;a++ ) {
			System.out.print(student[a].getname()+" "+student[a].getnumber()+" "+student[a].getgrades());
			System.out.println();
		}





	}
}