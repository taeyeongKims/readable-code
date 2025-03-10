package cleancode.mission.day7.model.passlistprovider;

import cleancode.mission.day7.model.studycafepass.StudyCafePassType;

public interface StudyCafePassListProvidable {

    boolean supports(StudyCafePassType passType);

    PassListProvider provide();

}
