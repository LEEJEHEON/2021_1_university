package hw4_5;
import java.util.Scanner;
//***************************
//파일명: merge_sort.java
//작성자: 201625025 이제헌
//작성일: 2020.04.15
//내용: 원과 삼각형의 밑변과 높이를 입력하여 면적을 구하여 면적을 오름차순으로 병합정렬을 한 뒤에 출력하는 프로그램
//***************************
interface shape{ // 인터페이스
	abstract public double getarea();
}

class Circle implements shape {
	private double radius;  // 반지름
	final double Pl = 3.14; // 상수 파이값

	public Circle() {  // 생성자
	}
	public double get_radius() { // 반지름 출력 메소드
		return radius;
	}
	public void set_radius(double radius) { // 반지름 입력 메소드
		this.radius=radius;
	}
	@Override
	public double getarea() {  // 인터페이스 추상메소드 오버라이드  (넓이 구하는 메소드)
		return radius * radius * Pl;
	}
	@Override
	public String toString() {  // 오버라이드 (출력 메소드)
		return "원 반지름="+radius+" 면적="+ getarea();
	}
}

class Triangle implements shape{
	private double triangle_side; // 밑변
	private double height; // 높이

	public Triangle() { //생성자
	}
	public double get_triangle_side() {  //밑변 출력 메소드
		return triangle_side;
	}
	public void set_triangle_side(double side) { // 밑변 입력 메소드
		this.triangle_side=side;
	}
	public double get_height() { //높이 출력 메소드
		return height;
	}
	public void set_height(double height) {// 높이 입력 메소드
		this.height=height;
	}
	@Override
	public double getarea() { // 인터페이스 추상메소드 오버라이드  (넓이 구하는 메소드)
		return triangle_side*height/2;
	};
	@Override
	public String toString() { //  오버라이드 (출력 메소드)
		return "삼각형 밑변="+ triangle_side+" 높이="+height+" 면적="+getarea();
	}

}
class FigureSortService {
    public static void mergeSort(shape[] figureArray) {
       mergeSort(figureArray, 0, figureArray.length-1); //정렬할 하한인덱스 0 , 끝은 0부터 시작해서 -1
    }
    public static void mergeSort(shape[] figureArray, int start, int end) { // 원소가 1개가 될때까지 계속 나눔 그리고 병합 메소드로 보냄
         if (start == end) return; // 원소가 1개이면 return
         int middle = (start + end) / 2;  // 중앙을 구함
         mergeSort(figureArray, start, middle); //중앙을 기준으로 나눔 전반부 정렬
         mergeSort(figureArray, middle + 1, end); // 겹치면 안되니까 +1 후반부 정렬
         merge(figureArray, start, middle, end); // 병합
     }
    public static void merge(shape[] figureArray, int start, int middle, int end) { //병합 메소드
        int length = end - start + 1; //길이
        shape[] temp = new shape[length]; //처음 배열의 크기와 같은 임시배열 생성
        int n = 0;
        int index1 = start;
        int index2 = middle + 1;

        while (index1 <= middle && index2 <= end) {
            if (figureArray[index1].getarea() < figureArray[index2].getarea()) //오름차순 넓이 비교
                temp[n++] = figureArray[index1++];
            else
                temp[n++] = figureArray[index2++];
        }
        while (index1 <= middle)// 왼쪽부분 배열이 남은 경우
            temp[n++] = figureArray[index1++];
        while (index2 <= end) // 오른쪽 부분 배열이 남은 경우
            temp[n++] = figureArray[index2++];
        for (n = 0; n < temp.length; ++n)// 결과 저장
           figureArray[start + n] = temp[n];
    }

}


public class merge_sort {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("hw4_5:이제헌 \n");

		System.out.print("원 갯수 입력 :");
		int n1 = scanner.nextInt();

		System.out.print("삼각형 갯수 입력 :");
		int n2 = scanner.nextInt();

		shape figureArray [] = new shape[n1+n2]; //도형객체 배열 생성

		System.out.println(n1+"개의 원 정보(반지름)를 입력하세요:");
		for (int a=0;a<n1;a++) {
			 Circle circle = new Circle(); // 객체 생성
			 circle.set_radius(scanner.nextDouble()); // 반지름 입력
			 figureArray[a] = circle; // 원의 정보를 배열에 입력 저장
		}

		System.out.println(n2+"개의 삼각형 정보(밑변과 높이)를 입력하세요:");
		for (int a=0;a<n2;a++) {
			Triangle triangle=new Triangle(); // 객체 생성
			triangle.set_triangle_side(scanner.nextDouble()); //밑변 입력
			triangle.set_height(scanner.nextDouble()); // 높이 입력
			figureArray[n1+a]= triangle; // 삼각형의 정보를 배열에 저장
		}

		FigureSortService.mergeSort(figureArray); //병합정렬
		System.out.println("병합 정렬 결과 "+figureArray.length+"개의 도형정보와 면적 =");
		for (int a=0;a<figureArray.length;a++) {
			System.out.println(figureArray[a]); // 입력된 도형의 면적 출력
		}
	}

}
