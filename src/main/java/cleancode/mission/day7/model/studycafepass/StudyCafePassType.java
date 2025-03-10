package cleancode.mission.day7.model.studycafepass;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권"),
    WEEKLY("주 단위 이용권"),
    FIXED("1인 고정석"),
    LOCKER("라커 이용권");

    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }

}
