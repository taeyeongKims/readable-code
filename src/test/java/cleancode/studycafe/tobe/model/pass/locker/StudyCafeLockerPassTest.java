package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafeLockerPassTest {

    @Test
    @DisplayName("locker pass의 타입이 맞을 때, true가 나오는지 확인한다.")
    void isSamePassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        boolean samePassType = lockerPass.isSamePassType(StudyCafePassType.FIXED);

        // then
        assertTrue(samePassType);
    }

    @Test
    @DisplayName("locker pass의 타입이 틀렸을 때, false가 나오는지 확인한다.")
    void isNotSamePassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        boolean samePassType = lockerPass.isSamePassType(StudyCafePassType.HOURLY);

        // then
        assertFalse(samePassType);
    }

    @Test
    @DisplayName("locker pass의 기간이 맞을 때, true가 나오는지 확인한다.")
    void isSameDuration() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        boolean samePassType = lockerPass.isSameDuration(12);

        // then
        assertTrue(samePassType);
    }

    @Test
    @DisplayName("locker pass의 기간이 틀렸을 때, false가 나오는지 확인한다.")
    void isNotDuration() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        boolean samePassType = lockerPass.isSameDuration(121212);

        // then
        assertFalse(samePassType);
    }
}
