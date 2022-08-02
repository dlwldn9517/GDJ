package library;

import java.util.Scanner;

public class Library {

	private Scanner sc;
	private Book[] books;
	private int idx;
	
	public Library() {
		sc = new Scanner(System.in);
		books = new Book[100];
	}
	
	private void addBook() {
		if(idx > 99) {
			return;
		}
		System.out.println("===== 책 등록 =====");
		System.out.print("제목 입력 >>> ");
		String title = sc.next();
		System.out.print("저자 입력 >>> ");
		String author = sc.next();
		Book book = new Book(idx + 1, title, author);
		books[idx++] = book;
		
	}
	
	private void removeBook() {
		System.out.println("===== 책 삭제 =====");
	}
	
	private void findBook() {
		System.out.println("===== 책 조회 =====");
	}
	
	private void printAllBooks() {
		System.out.println("===== 전체 조회 =====");
	}
	
	public void manage() {

		while(true) {
			System.out.print("1.추가 2.삭제 3.조회 4.전체목록 0.프로그램종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();	// 1(choice)→저장O, Enter(sc.nextLine())→저장X 버리는거
			switch(choice) {
			case 1: addBook(); break;
			case 2: removeBook(); break;
			case 3: findBook(); break;
			case 4: printAllBooks(); break;
			case 0: System.out.println("Library 프로그램을 종료합니다. 감사합니다.");
					return;	 // manage() 메소드 종료
			default: System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");
			}
			
		}
		
	}
	
}
