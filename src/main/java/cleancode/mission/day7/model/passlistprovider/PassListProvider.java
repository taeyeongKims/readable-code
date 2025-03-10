package cleancode.mission.day7.model.passlistprovider;

import cleancode.mission.day7.io.StudyCafeFileHandler;
import cleancode.mission.day7.model.studycafepass.StudyCafeLockerPassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePass;

import java.util.List;

public interface PassListProvider {

    StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    List<StudyCafePass> getPassList();

    StudyCafeLockerPassImpl selectLockerPass(StudyCafePass selectedPass);

}
