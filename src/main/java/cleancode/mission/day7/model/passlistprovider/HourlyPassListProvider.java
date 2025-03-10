package cleancode.mission.day7.model.passlistprovider;

import cleancode.mission.day7.model.studycafepass.StudyCafeLockerPassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePass;
import cleancode.mission.day7.model.studycafepass.StudyCafePassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePassType;

import java.util.List;

public class HourlyPassListProvider implements PassListProvider {

    @Override
    public List<StudyCafePass> getPassList() {
        List<StudyCafePassImpl> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();

        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == StudyCafePassType.HOURLY)
            .map(StudyCafePass.class::cast)
            .toList();
    }

    @Override
    public StudyCafeLockerPassImpl selectLockerPass(StudyCafePass selectedPass) {
        return null;
    }
}
