package prac04;

public class TourGuide {
	
	// 필드
	private Tour tour;

	// 생성자
	public TourGuide(Tour tour) {
		super();
		this.tour = tour;
	}
	
	// 메소드
	public void sightseeing() {
		tour.sightseeing();		// Tour 클래스의 해당 메소드 호출
	}
	
	public void leisure() {
		tour.leisure();
	}

}
