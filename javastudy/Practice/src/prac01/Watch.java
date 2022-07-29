package prac01;

public class Watch {

	String addHour(int hour) {
		return hour + "시간 후 (" + hour % 24 + "시간)";
	}
	
	String addMinute(int minute) {
		return minute + "분 후 (" + (minute / 60) + "시간 " + (minute % 60) + "분)";
	}
	
	String addSecond(int second) {
		return second + "초 후 (" + (second / 3600) + "시간 " + (second / 60) + "분 " + second + "초)";
	}
	
	//String see() {
		
	//}
	
}
