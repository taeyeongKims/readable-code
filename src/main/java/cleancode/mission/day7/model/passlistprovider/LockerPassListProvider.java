package cleancode.mission.day7.model.passlistprovider;

import cleancode.mission.day7.model.studycafepass.StudyCafeLockerPassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePass;
import cleancode.studycafe.asis.model.StudyCafeLockerPass;

import java.util.List;

public class LockerPassListProvider implements PassListProvider {
    @Override
    public List<StudyCafePass> getPassList() {
        List<StudyCafeLockerPassImpl> lockerPasses = studyCafeFileHandler.readLockerPasses();

        return lockerPasses.stream()
            .map(StudyCafePass.class::cast)
            .toList();
    }

    public StudyCafeLockerPassImpl getLockerPass(StudyCafePass pass) {
        List<StudyCafePass> lockerPassList = getPassList();

        return lockerPassList.stream()
            .filter(option ->
                option.getPassType() == pass.getPassType()
                    && option.getDuration() == pass.getDuration()
            )
            .map(StudyCafeLockerPassImpl.class::cast)
            .findFirst()
            .orElse(null);
    }
}
