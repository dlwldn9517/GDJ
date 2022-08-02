package library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor	// new Book()
@AllArgsConstructor	// new Book(1, "어린왕자", "생텍쥐베리")
@Getter	// getBookNo(), getTitle(), getAuthor()
@Setter	// setBookNo(1), setTitle("어린왕자"), setAuthor("생텍쥐베리")
public class Book {
	private int bookNo;
	private String title;
	private String author;
	

}
