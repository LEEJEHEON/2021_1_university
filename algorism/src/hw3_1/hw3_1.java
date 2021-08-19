package hw3_1;
import java.util.Scanner;
//***************************
//파일명: hw3_1.java
//작성자: 201625025 이제헌
//작성일: 2020.04.06
//설명: 학생정보를 입력받아 성적의 평균을 구하고 수석 학생의 이름을 구하는 프로그램
//***************************
class Student{
	private String name; //학생 이름
	private int stdent_number; // 학번
	private float grades; //학생 성적

	public Student(String name, int number, float grade) { // 사용자가 입력한 학생정보를 class Student 변수에 넣는다.
		this.name = name;
		this.stdent_number = number;
		this.grades = grade;
	}
	public float getgrades() { // private grades을 추출하기 위한 메소드
		return grades;
	}
	public String getname() { // private name을 추출하기 위한 메소드
		return name;
	}

}


public class hw3_1 {
	public static void main(String[] args) {
		float max=0;  // 최대값을 구하기 위한 변수
		float average=0; // 평균을 구하기 위한 변수
		String name=""; // 학생이름을 입력받고 , 수석학생이름을 구하기 위한 변수
		int number; // 학번
		float grade; // 성적
		Scanner scanner=new Scanner(System.in);
		System.out.println("hw3_1:이제헌");
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

		for (int a=0;a<n;a++) // 평균 성적을 구함
			average += student[a].getgrades();

		average = average/n;
		System.out.println("\n성적 평균 = "+Math.round(average*100)/100.0); //소수점 둘째자릿수까지 출력

		for(int a=0;a<n;a++) { //수석 학생 이름을 구함
			if(max < student[a].getgrades()) {  // 성적이 같아도 먼저 입력했던 학생으로 저장됨
				max = student[a].getgrades();
				name = student[a].getname();
			}
		}
		System.out.println("\n수석 학생 성명 ="+name);

	}


}
