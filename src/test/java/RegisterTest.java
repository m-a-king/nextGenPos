package org.nextGenPos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {
    private Register register;
    private ProductCatalog productCatalog;
    private Sale sale;

    @BeforeEach
    void setUp() {
        productCatalog = new ProductCatalog(); // 실제 ProductCatalog 사용
        sale = new Sale(); // 실제 Sale 사용
        register = new Register(productCatalog);
    }

    @Test
    void testMakeNewSale() {
        register.makeNewSale();
        // Sale 객체가 생성되었는지 확인
        // ... 검증 코드 작성 ...
    }

    @Test
    void testEnterItem() {
        ItemID itemId = new ItemID(1);
        Money price = new Money(1000);
        // ProductCatalog에 상품 가격 설정
        productCatalog.setPrice(itemId, price);

        register.makeNewSale();
        register.enterItem(itemId, 2);

        // Sale 객체에 항목이 추가되었는지 검증
        // ... 검증 코드 작성 ...
    }

    @Test
    void testEndSale() {
        register.makeNewSale();
        register.endSale();

        // Sale 객체가 완료 상태인지 검증
        // ... 검증 코드 작성 ...
    }

    @Test
    void testMakePayment() {
        Money cashTendered = new Money(1000);
        register.makeNewSale();
        register.makePayment(cashTendered);

        // Payment가 올바르게 처리되었는지 검증
        // ... 검증 코드 작성 ...
    }
}
