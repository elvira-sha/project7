package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    // Тест для зарегистрированного пользователя, бонус ниже лимита
    @Test
    void shouldCalculateBonusForRegisteredAndBelowLimit() {
        BonusService bonusService = new BonusService();

        // Данные для теста
        long purchaseAmount = 1500; // Сумма покупки
        boolean isRegisteredUser = true; // Пользователь зарегистрирован
        long expectedBonus = 45; // Ожидаемый бонус

        // Вызываем метод и проверяем результат
        long actualBonus = bonusService.calculateBonus(purchaseAmount, isRegisteredUser);
        assertEquals(expectedBonus, actualBonus);
    }

    // Тест для зарегистрированного пользователя, бонус превышает лимит
    @Test
    void shouldCalculateBonusForRegisteredAndAboveLimit() {
        BonusService bonusService = new BonusService();

        // Данные для теста
        long purchaseAmount = 2_000_000; // Сумма покупки
        boolean isRegisteredUser = true; // Пользователь зарегистрирован
        long expectedBonus = 500; // Ожидаемый бонус

        // Проверяем результат
        long actualBonus = bonusService.calculateBonus(purchaseAmount, isRegisteredUser);
        assertEquals(expectedBonus, actualBonus);
    }

    // Тест для незарегистрированного пользователя, бонус ниже лимита
    @Test
    void shouldCalculateBonusForUnregisteredAndBelowLimit() {
        BonusService bonusService = new BonusService();

        // Данные для теста
        long purchaseAmount = 2000; // Сумма покупки
        boolean isRegisteredUser = false; // Пользователь не зарегистрирован
        long expectedBonus = 20; // Ожидаемый бонус

        // Проверяем результат
        long actualBonus = bonusService.calculateBonus(purchaseAmount, isRegisteredUser);
        assertEquals(expectedBonus, actualBonus);
    }

    // Тест для незарегистрированного пользователя, бонус превышает лимит
    @Test
    void shouldCalculateBonusForUnregisteredAndAboveLimit() {
        BonusService bonusService = new BonusService();

        // Данные для теста
        long purchaseAmount = 5_000_000; // Сумма покупки
        boolean isRegisteredUser = false; // Пользователь не зарегистрирован
        long expectedBonus = 500; // Ожидаемый бонус

        // Проверяем результат
        long actualBonus = bonusService.calculateBonus(purchaseAmount, isRegisteredUser);
        assertEquals(expectedBonus, actualBonus);
    }
}
