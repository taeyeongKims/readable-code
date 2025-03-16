package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.io.provider.LockerPassFileReader;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.provider.LockerPassProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StudyCafeLockerPassesTest {

    @Test
    @DisplayName("고정 패스권이 아닐 때, locker 패스를 가져오면 null이 반환된다.")
    void findLockerPassByNoFixed() {
        // given
        LockerPassProvider lockerPassProvider = new LockerPassFileReader();
        StudyCafeLockerPasses lockerPasses = lockerPassProvider.getLockerPasses();
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 12, 400000, 0.15);

        // when
        StudyCafeLockerPass lockerPass = lockerPasses.findLockerPassBy(seatPass).orElse(null);

        // then
        assertThat(lockerPass).isNull();
    }

    @Test
    @DisplayName("고정 패스권일 때, 기간에 맞는 locker 패스권이 반환된다.")
    void findLockerPassByFixed() {
        // given
        LockerPassProvider lockerPassProvider = new LockerPassFileReader();
        StudyCafeLockerPasses lockerPasses = lockerPassProvider.getLockerPasses();
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);

        // when
        StudyCafeLockerPass lockerPass = lockerPasses.findLockerPassBy(seatPass).orElse(null);

        // then
        StudyCafeLockerPass matchedLockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);
        assertThat(lockerPass).usingRecursiveComparison().isEqualTo(matchedLockerPass);
    }
}
