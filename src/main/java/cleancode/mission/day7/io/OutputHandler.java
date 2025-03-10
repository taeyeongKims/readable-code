package cleancode.mission.day7.io;

import cleancode.mission.day7.model.CalculateOrder;
import cleancode.mission.day7.model.studycafepass.StudyCafeLockerPassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePass;

import java.util.List;

public class OutputHandler {

    private final CalculateOrder calculateOrder = new CalculateOrder();

    public static void askLockerPass(StudyCafeLockerPassImpl lockerPass) {
        System.out.println();
        String askMessage = String.format(
            "사물함을 이용하시겠습니까? (%s)",
            lockerPass.display()
        );

        System.out.println(askMessage);
        System.out.println("1. 예 | 2. 아니오");
    }

    private static void showPassInfo(StudyCafePass selectedPass, StudyCafeLockerPassImpl lockerPass) {
        System.out.println("이용 내역");
        System.out.println("이용권: " + selectedPass.display());
        if (lockerPass != null) {
            System.out.println("사물함: " + lockerPass.display());
        }
    }

    private static boolean exitsDiscountPrice(int discountPrice) {
        return discountPrice > 0;
    }

    public void showWelcomeMessage() {
        System.out.println("*** 프리미엄 스터디카페 ***");
    }

    public void showAnnouncement() {
        System.out.println("* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)");
        System.out.println("* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)");
        System.out.println();
    }

    public void askPassTypeSelection() {
        System.out.println("사용하실 이용권을 선택해 주세요.");
        System.out.println("1. 시간 이용권(자유석) | 2. 주단위 이용권(자유석) | 3. 1인 고정석");
    }

    public void showPassListForSelection(List<StudyCafePass> passes) {
        System.out.println();
        System.out.println("이용권 목록");
        for (int index = 0; index < passes.size(); index++) {
            StudyCafePass pass = passes.get(index);
            System.out.println(String.format("%s. ", index + 1) + pass.display());
        }
    }

    public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPassImpl lockerPass) {
        System.out.println();

        showPassInfo(selectedPass, lockerPass);
        int discountPrice = showDiscountPrice(selectedPass);
        showTotalPrice(selectedPass, lockerPass, discountPrice);

        System.out.println();
    }

    public void showSimpleMessage(String message) {
        System.out.println(message);
    }

    private void showTotalPrice(StudyCafePass selectedPass, StudyCafeLockerPassImpl lockerPass, int discountPrice) {
        int totalPrice = calculateOrder.getTotalPrice(selectedPass, discountPrice, lockerPass);
        System.out.println("총 결제 금액: " + totalPrice + "원");
    }

    private int showDiscountPrice(StudyCafePass selectedPass) {
        int discountPrice = calculateOrder.getDiscountPrice(selectedPass);
        if (exitsDiscountPrice(discountPrice)) {
            System.out.println("이벤트 할인 금액: " + discountPrice + "원");
        }
        return discountPrice;
    }

}
