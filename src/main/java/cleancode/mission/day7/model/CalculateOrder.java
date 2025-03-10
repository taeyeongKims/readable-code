package cleancode.mission.day7.model;

import cleancode.mission.day7.model.studycafepass.StudyCafeLockerPassImpl;
import cleancode.mission.day7.model.studycafepass.StudyCafePass;

public class CalculateOrder {

    public int getDiscountPrice(StudyCafePass pass){
        double discountRate = pass.getDiscountRate();
        return (int) (pass.getPrice() * discountRate);
    }

    public int getTotalPrice(StudyCafePass pass, int discountPrice, StudyCafePass lockerPass){
        return pass.getPrice() - discountPrice + (lockerPass != null ? lockerPass.getPrice() : 0);

    }
}
