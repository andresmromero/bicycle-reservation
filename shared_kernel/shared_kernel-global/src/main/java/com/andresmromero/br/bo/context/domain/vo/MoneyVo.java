package com.andresmromero.br.bo.context.domain.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MoneyVo {


    public static final MoneyVo ZERO = new MoneyVo(BigDecimal.ZERO);
    private final BigDecimal amount;

    public MoneyVo(BigDecimal amount) {

        this.amount = amount;
    }

    public BigDecimal getAmount() {

        return amount;
    }

    public boolean isGreaterThanZero() {

        return Objects.nonNull(this.amount) && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(MoneyVo other) {

        return Objects.nonNull(this.amount) && this.amount.compareTo(other.amount) > 0;
    }

    public MoneyVo subtract(MoneyVo other) {

        return new MoneyVo(setScale(this.amount.subtract(other.getAmount())));
    }

    public MoneyVo add(MoneyVo money) {

        return new MoneyVo(setScale(this.amount.add(money.getAmount())));
    }

    public MoneyVo multiply(int multiplier) {

        return new MoneyVo(setScale(this.amount.multiply(new BigDecimal(multiplier))));
    }

    private BigDecimal setScale(BigDecimal input) {

        return input.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoneyVo money = (MoneyVo) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount);
    }

}
