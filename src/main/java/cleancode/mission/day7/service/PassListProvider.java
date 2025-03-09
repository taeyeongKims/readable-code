package cleancode.mission.day7.service;

import cleancode.mission.day7.io.StudyCafeFileHandler;
import cleancode.mission.day7.model.StudyCafePass;

import java.util.List;

public interface PassListProvider {

    StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    List<StudyCafePass> getPassList();

}
