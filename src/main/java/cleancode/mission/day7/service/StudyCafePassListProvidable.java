package cleancode.mission.day7.service;

import cleancode.mission.day7.model.StudyCafePassType;

public interface StudyCafePassListProvidable {

    boolean supports(StudyCafePassType passType);

    PassListProvider provide();

}
