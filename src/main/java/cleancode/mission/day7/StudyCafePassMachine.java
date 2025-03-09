package cleancode.mission.day7;

import cleancode.mission.day7.exception.AppException;
import cleancode.mission.day7.io.InputHandler;
import cleancode.mission.day7.io.OutputHandler;
import cleancode.mission.day7.model.StudyCafeLockerPassImpl;
import cleancode.mission.day7.model.StudyCafePass;
import cleancode.mission.day7.model.StudyCafePassType;
import cleancode.mission.day7.service.LockerPassListProvider;
import cleancode.mission.day7.service.PassListProvider;
import cleancode.mission.day7.service.StudyCafePassListProvider;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    private static boolean existsLockerPass(StudyCafeLockerPassImpl lockerPass) {
        return lockerPass != null;
    }

    private static boolean isFixedStudyCafePass(StudyCafePassType studyCafePassType) {
        return studyCafePassType == StudyCafePassType.FIXED;
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            PassListProvider passListProvider = StudyCafePassListProvider.findStudyCafeManger(studyCafePassType);
            List<StudyCafePass> passes = passListProvider.getPassList();

            outputHandler.showPassListForSelection(passes);
            StudyCafePass selectedPass = inputHandler.getSelectPass(passes);

            if (isFixedStudyCafePass(studyCafePassType)) {
                LockerPassListProvider studyCafeManager = StudyCafePassListProvider.findStudyCafeManger(StudyCafePassType.LOCKER);
                StudyCafeLockerPassImpl lockerPass = studyCafeManager.getLockerPass(selectedPass);

                if (existsLockerPass(lockerPass)) {
                    outputHandler.askLockerPass(lockerPass);

                    if (isSelectedLocker()) {
                        outputHandler.showPassOrderSummary(selectedPass, lockerPass);
                        return;
                    }
                }
            }

            outputHandler.showPassOrderSummary(selectedPass, null);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private boolean isSelectedLocker() {
        return inputHandler.getLockerSelection();
    }
}
