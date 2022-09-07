package repository;

public class ContactDAO {
	
	// DAO는 하나의 객체만 생성할 수 있도록
	// Singleton Pattern으로 생성
	
	// ContactDAO 객체를 하나 만들어 둔다.
	private ContactDAO contactDAO = new ContactDAO();
	
	// 외부에서는 ContactDAO 객체를 못 만들도록 제한한다.
	// private 생성자
	private ContactDAO() {
		
	}
	
	// 만들어 둔 ContactDAO 객체를 외부에 반환한다.
	public ContactDAO getInstance() {
		return contactDAO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
