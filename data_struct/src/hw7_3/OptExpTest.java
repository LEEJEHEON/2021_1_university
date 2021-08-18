package hw7_3;
import java.util.Scanner;
import java.util.Stack;
//***************************
//파일명: OptExpTest.java
//작성자: 201625025 이제헌
//작성일: 2020.05.05
//설명: 스택을 이용한 후위표기법 계산 프로그램
//***************************
public class OptExpTest {
	public static void main(String[] args) {
		System.out.println("hw7_3: 이제헌");
		Scanner sc = new Scanner(System.in);
		Stack<Double> stack = new Stack<>(); //자바에서 제공하는 stack 클래스 사용
		Double num1,num2, value; // num1 과 num2 는 계산을 위해 value는 push와 마지막에 출력을 위해


		System.out.print("실수형 후위표기 수식 입력: ");
		String exp = sc.nextLine();
		String[] testCh =exp.split(" "); //공백으로 분리되어 있어서 공백으로 split함
		for(int i=0; i<testCh.length;i++) {
			//연산자면 계산
			if(testCh[i].equals("+") || testCh[i].equals("-") || testCh[i].equals("*") || testCh[i].equals("/")) {
				try { //피연산자가 부족하여 에러가 뜨면 catch로 예외처리
				num2 = stack.pop(); // stack 에서 값을 하나씩 가져옴
				num1 = stack.pop();
				switch(testCh[i]) {
					case "+" : stack.push(num1+num2); break;
					case "-" : stack.push(num1-num2); break;
					case "*" : stack.push(num1*num2); break;
					case "/" : stack.push(num1/num2); break;
				}
				}catch(java.util.EmptyStackException e){ //pop을 할 스택에 피연산자가 없어서 오류
					System.out.println("ERROR: 후위표기 수식 형식 오류(피연산자 부족)");
					System.exit(0); //즉시 종료
				}

			}
			else { //피연산자 이면 stack에 push
				value =  Double.parseDouble(testCh[i]); //Double 형태로 변환
				stack.push(value);
			}
		}

		value = stack.pop(); // 마지막 값을 value에 넣고 삭제
		if(stack.empty()) { // 정상적이라면 stack에 아무런 값도 없어야 한다.
			System.out.println("계산 결과 = "+value);
		}
		else { //값이 또 있다는 것은 연산자가 부족하여 계산을 다 못한 수식임
			System.out.println("ERROR: 후위표기 수식 형식 오류(연산자 부족)");
		}
	}
}
