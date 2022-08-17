package ex02_thread;

public class Main {

	public static void main(String[] args) {

		Soldier s1 = new Soldier("김상사", new Gun(6));
		Soldier s2 = new Soldier("장병장", new Gun(10));
		
		s1.shoot();
		s2.shoot();
		
	}

}
