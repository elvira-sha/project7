package com.example;

public class BonusService {

    // Метод для расчета бонуса
    public long calculateBonus(long purchaseAmount, boolean isRegisteredUser) {
        // Устанавливаем процент бонуса в зависимости от регистрации
        int bonusPercentage = isRegisteredUser ? 3 : 1;

        // Рассчитываем бонус на основе суммы покупки и процента
        long calculatedBonus = purchaseAmount * bonusPercentage / 100;

        // Ограничение максимального бонуса
        long maxBonus = 500;

        // Если бонус больше максимума, устанавливаем его на уровне максимума
        return Math.min(calculatedBonus, maxBonus);
    }
}
