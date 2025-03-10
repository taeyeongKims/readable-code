package cleancode.mission.day7.io;

import cleancode.mission.day7.exception.AppException;
import cleancode.mission.day7.model.studycafepass.StudyCafePass;
import cleancode.mission.day7.model.studycafepass.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return isSelectedLockerPass(userInput);
    }

    private static boolean isSelectedHourlyPass(String userInput) {
        return "1".equals(userInput);
    }

    private static boolean isSelectedWeeklyPass(String userInput) {
        return "2".equals(userInput);
    }

    private static boolean isSelectedFixedPass(String userInput) {
        return "3".equals(userInput);
    }

    private static boolean isSelectedLockerPass(String userInput) {
        return "1".equals(userInput);
    }

    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();

        if (isSelectedHourlyPass(userInput)) {
            return StudyCafePassType.HOURLY;
        }
        if (isSelectedWeeklyPass(userInput)) {
            return StudyCafePassType.WEEKLY;
        }
        if (isSelectedFixedPass(userInput)) {
            return StudyCafePassType.FIXED;
        }
        throw new AppException("잘못된 입력입니다.");
    }

    public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        return passes.get(selectedIndex);
    }
}
