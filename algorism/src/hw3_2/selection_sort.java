package hw3_2;
import java.util.Scanner;

//***************************
//파일명: selection_sort.java
//작성자: 201625025 이제헌
//작성일: 2020.04.10
//설명: 학생정보를 입력받아 선택정렬 알고리즘을 사용하여 성명기준 오름차순으로 정렬한 학생정보를 보여주는 프로그램
//***************************
class Student{
	private String name; //학생 이름
	private int student_number; // 학번
	private float grades; //학생 성적

	public Student(String name, int number, float grade) { // 생성자
		this.name = name;
		this.student_number = number;
		this.grades = grade;
	}
	public String getname() {
		return name;
	}
	public int getnumber() {
		return student_number;
	}
	public float getgrade() {
		return grades;
	}
}

public class selection_sort {
	public static void main(String[] args) {
		String name=""; // 학생이름을 입력받을 변수
		int number; // 학번
		float grade; // 성적
		Student temp;// 임시 저장소
		Scanner scanner=new Scanner(System.in);
		System.out.println("hw3_2:이제헌");
		System.out.print("학생 수 입력 :");
		int n = scanner.nextInt();
		Student student[] = new Student[n]; // 객체배열을 생성
		System.out.println(n+"명의 학생 정보를 입력하세요:");
		for (int a=0;a<n;a++) {
			name = scanner.next();
			number = scanner.nextInt();
			grade = scanner.nextFloat();
			student[a]=new Student(name,number,grade);
		}

		// 선택정렬 알고리즘
		for (int last=n-1;last>0;last--) { // 오름차순
			String max=student[last].getname();
			int index =last;
			for (int a=last;a>-1;a--) { //max 값 찾기
				if(max.compareTo(student[a].getname())<0) {
					max = student[a].getname();
					index = a;
				}
			}
			temp = student[last];
			student[last]=student[index];
			student[index]=temp;


		}
		System.out.println("성명 오름차순 정렬 결과 =");
		for (int a=0;a<n;a++ ) {
			System.out.print(student[a].getname()+" "+student[a].getnumber()+" "+student[a].getgrade());
			System.out.println();
		}
	}


}