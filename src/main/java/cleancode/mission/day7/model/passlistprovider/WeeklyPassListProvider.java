package cleancode.mission.day7.model.passlistprovider;

import cleancode.mission.day7.model.studycafepass.StudyCafePass;
import cleancode.mission.day7.model.studycafepass.StudyCafePassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePassType;

import java.util.List;

public class WeeklyPassListProvider implements PassListProvider {

    @Override
    public List<StudyCafePass> getPassList() {
        List<StudyCafePassImpl> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();

        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == StudyCafePassType.FIXED)
            .map(StudyCafePass.class::cast)
            .toList();
    }
}
