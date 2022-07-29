package prac01;

public class Watch {

	private int hour;
	private int minute;
	private int second;
	
	public Watch(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void addHour(int hour) {
		if(hour < 0)
			return;
	}
	
	public void addMinute(int minute) {
		
		return;
	}
	
	String addSecond(int second) {
		return second + "초 후 (" + (second / 3600) + "시간 " + (second / 60) + "분 " + second + "초)";
	}
	
	//String see() {
		
	//}
	
}
