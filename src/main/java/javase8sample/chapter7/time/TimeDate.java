package javase8sample.chapter7.time;

import java.util.Calendar;

public class TimeDate {

	public static void main(String[] args) {
		Calendar birth = Calendar.getInstance();
		birth.set(1975, Calendar.MAY, 26);
		Calendar now = Calendar.getInstance();
		System.out.println(daysBetweenClone(birth, now));
		System.out.println(daysBetween(birth, now));
		System.out.println(daysBetween(birth, now)); // 显示 0？
	}

	public static long daysBetweenClone(Calendar begin, Calendar end) {
		Calendar calendar = (Calendar) begin.clone(); // 复制
		long daysBetween = 0;
		while (calendar.before(end)) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return daysBetween;
	}

	public static long daysBetween(Calendar begin, Calendar end) {
		long daysBetween = 0;
		while (begin.before(end)) {
			begin.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return daysBetween;
	}
}
