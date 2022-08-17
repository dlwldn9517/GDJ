package ex02_thread;

public class Soldier {

	private String name;
	private Gun gun;
	
	public Soldier(String name, Gun gun) {
		super();
		this.name = name;
		this.gun = gun;
	}
	
	public void shoot() {
		System.out.print("[" + name + "]" + " : ");
		gun.shoot();
	}
	
}
