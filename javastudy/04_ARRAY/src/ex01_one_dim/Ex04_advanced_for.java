package ex01_one_dim;

public class Ex04_advanced_for {

	public static void main(String[] args) {
		
		// 일반 for문
		String[] friends = {"라이언", "프로도", "어피치"};
		
		for(int i = 0; i < friends.length; i++) {
			System.out.println((i+1) + "번째 친구 - " + friends[i]);
		}
		
		
		// 향상 for문	(인덱스 사용X)
		for(String friend : friends) {	// friends 배열의 모든 요소를 하나씩 String friend로 옮긴다.
			System.out.println(friend);
		}
		
		
		
		
		
		
		

	}

}