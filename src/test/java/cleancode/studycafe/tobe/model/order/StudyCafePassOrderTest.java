package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StudyCafePassOrderTest {

    @Test
    @DisplayName("고정석이 아닐 때, 할인 금액을 얻는다.")
    void getDiscountPriceNoFixed() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 12, 400000, 0.15);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int discountPrice = studyCafePassOrder.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(60000);
    }

    @Test
    @DisplayName("고정석일 때, 할인 금액을 얻는다.")
    void getDiscountPriceWithFixed() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12,700000,0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED,12,30000);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int discountPrice = studyCafePassOrder.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(105000);
    }

    @Test
    @DisplayName("고정석이 아닐 때, 전체 금액을 얻는다.")
    void getTotalPriceNoFixed() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 12, 400000, 0.15);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int totalPrice = studyCafePassOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(340000);
    }

    @Test
    @DisplayName("고정석일 때, 전체 금액을 얻는다.")
    void getTotalPriceWithFixed() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12,700000,0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED,12,30000);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = studyCafePassOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(625000);
    }

    @Test
    @DisplayName("입력한 seat pass를 얻는다.")
    void getSeatPass() {
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12,700000,0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED,12,30000);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        StudyCafeSeatPass receivedSeatPass = studyCafePassOrder.getSeatPass();

        // then
        assertThat(receivedSeatPass).isEqualTo(seatPass);
    }
}
