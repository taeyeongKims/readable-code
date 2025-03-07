package cleancode.mission.day4;

import java.util.List;
import java.util.logging.Logger;

// 주문 도메인
public class Order {

    private final OutputHandler outputHandler = new OutputHandler();

    private Customer customer;
    private List<Item> items;
    private final int totalPrice;

    public Order(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
        this.totalPrice = items.stream().mapToInt(Item::getPrice).sum();
    }

    public boolean validateOrder(Order order) {
        if (order.hasNoItems()) {
            outputHandler.printErrorMessage("주문 항목이 없습니다.");
            return false;
        }

        if (order.hasNoCustomerInfo()) {
            outputHandler.printErrorMessage("사용자 정보가 없습니다.");
            return false;
        }

        if (order.isNotTotalPricePositive()){
            outputHandler.printErrorMessage("올바르지 않은 총 가격입니다.");
            return false;
        }

        return true;
    }

    // 구매 물품이 존재하지 않는지 확인
    private boolean hasNoItems() {
        return this.items.isEmpty();
    }

    // 사용자 정보가 존재하지 않는지 확인
    private boolean hasNoCustomerInfo() {
        if(customer == null){
            return true;
        }
        return customer.isNullName();
    }

    // 구매 가격이 0보다 큰지 (정상 구매)인지 확인
    private boolean isNotTotalPricePositive() {
        return !(this.totalPrice > 0);
    }
}

// 상품 도메인
class Item {
    private String name;
    private int price;

    public int getPrice() {
        return price;
    }
}

// 사용자 도메인
class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public boolean isNullName() {
        return name == null;
    }
}

// 출력 핸들러
class OutputHandler {

    private final Logger log = Logger.getLogger(OutputHandler.class.getName());

    public void printErrorMessage(String message) {
        log.info(message);
    }
}