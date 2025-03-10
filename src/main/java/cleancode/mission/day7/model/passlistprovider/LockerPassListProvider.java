package cleancode.mission.day7.model.passlistprovider;

import cleancode.mission.day7.io.InputHandler;
import cleancode.mission.day7.io.OutputHandler;
import cleancode.mission.day7.model.studycafepass.StudyCafeLockerPassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePass;

import java.util.List;

import static cleancode.mission.day7.model.passlistprovider.PassListProvider.studyCafeFileHandler;

public class LockerPassListProvider {
    private static StudyCafeLockerPassImpl getStudyCafeLockerPass(StudyCafePass selectedPass, List<StudyCafePass> lockerPassList) {
        return lockerPassList.stream()
            .filter(option ->
                option.getPassType() == selectedPass.getPassType()
                    && option.getDuration() == selectedPass.getDuration()
            )
            .map(StudyCafeLockerPassImpl.class::cast)
            .findFirst()
            .orElse(null);
    }

    public StudyCafeLockerPassImpl selectLockerPass(StudyCafePass selectedPass) {
        List<StudyCafePass> lockerPassList = getPassList();

        StudyCafeLockerPassImpl selectedLockerPass = getStudyCafeLockerPass(selectedPass, lockerPassList);

        if (existsLockerPass(selectedLockerPass)) {
            OutputHandler.askLockerPass(selectedLockerPass);

            if (isSelectedLocker()) {
                return selectedLockerPass;
            }
        }
        return null;
    }

    private List<StudyCafePass> getPassList() {
        List<StudyCafeLockerPassImpl> lockerPasses = studyCafeFileHandler.readLockerPasses();

        return lockerPasses.stream()
            .map(StudyCafePass.class::cast)
            .toList();
    }

    private boolean existsLockerPass(StudyCafeLockerPassImpl lockerPass) {
        return lockerPass != null;
    }

    private boolean isSelectedLocker() {
        return InputHandler.getLockerSelection();
    }
}
