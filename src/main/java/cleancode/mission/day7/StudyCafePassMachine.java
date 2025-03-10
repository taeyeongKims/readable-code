package cleancode.mission.day7;

import cleancode.mission.day7.exception.AppException;
import cleancode.mission.day7.io.InputHandler;
import cleancode.mission.day7.io.OutputHandler;
import cleancode.mission.day7.model.passlistprovider.PassListProvider;
import cleancode.mission.day7.model.passlistprovider.StudyCafePassListProvider;
import cleancode.mission.day7.model.studycafepass.StudyCafeLockerPassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePass;
import cleancode.mission.day7.model.studycafepass.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

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

            StudyCafeLockerPassImpl lockerPass = passListProvider.selectLockerPass(selectedPass);
            outputHandler.showPassOrderSummary(selectedPass, lockerPass);

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }
}
