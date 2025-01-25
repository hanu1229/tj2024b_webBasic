package parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        // 현재 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now : " + now);
        // 과거 시간 (예: 5일 전)
        //LocalDateTime pastTime = now.minusDays(5);
        LocalDateTime pastTime = now.minusSeconds(90);
        System.out.println("pastTime : " + pastTime);
        // 시간 차이 계산
        Duration duration = Duration.between(pastTime, now);

        // 결과 출력
        System.out.println("Days: " + duration.toDays());
        System.out.println("Hours: " + duration.toHours());
        System.out.println("Minutes: " + duration.toMinutes());
        System.out.println("Seconds: " + duration.getSeconds());
        
    }
}
