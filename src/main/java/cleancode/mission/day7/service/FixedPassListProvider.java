package cleancode.mission.day7.service;

import cleancode.mission.day7.model.StudyCafePass;
import cleancode.mission.day7.model.StudyCafePassImpl;
import cleancode.mission.day7.model.StudyCafePassType;

import java.util.List;

public class FixedPassListProvider implements PassListProvider {

    @Override
    public List<StudyCafePass> getPassList() {
        List<StudyCafePassImpl> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();

        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == StudyCafePassType.FIXED)
            .map(StudyCafePass.class::cast)
            .toList();
    }

}
