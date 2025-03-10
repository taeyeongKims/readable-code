package cleancode.mission.day7.model.studycafepass;

public interface StudyCafePass {

    StudyCafePassType getPassType();

    int getDuration();

    int getPrice();

    String display();

    public double getDiscountRate();

}
