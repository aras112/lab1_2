package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test public void simpleMultiplyMoney() {
        Money money = new Money(12, "EUR");
        Money money2 = new Money(24, "EUR");
        Assert.assertThat(money.multiplyBy(2), is(money2));
    }

    @Test public void multiplyMoneyWhenNumberIsLessThanZero() {
        Money money = new Money(-12, "EUR");
        Money money2 = new Money(-24, "EUR");
        Assert.assertThat(money.multiplyBy(2), is(money2));
    }

    @Test public void incorrectTypeCurrencyCode() {
        Money money = new Money(4, "EUR");
        Money money2 = new Money(4, "PLN");
        Assert.assertThat(money, not(money2));
    }

    @Test public void simpleAddTwoMoney() {
        Money money = new Money(4, "EUR");
        Money money2 = new Money(8, "EUR");
        Assert.assertThat(money.add(money), is(money2));
    }

    @Test(expected = IllegalArgumentException.class) public void addToMoneyButTypesAreIncorrect() {
        Money money = new Money(4, "EUR");
        Money money2 = new Money(4, "PLN");
        money.add(money2);
    }

    @Test(expected = IllegalArgumentException.class) public void subtractMoneyButTypesAreIncorrect() {
        Money money = new Money(4, "EUR");
        Money money2 = new Money(4, "PLN");
        money.subtract(money2);
    }

    @Test(expected = IllegalArgumentException.class) public void greaterThanWithExceptionBecauseOfIncorrectCurrencyType() {
        Money money = new Money(4, "EUR");
        Money money2 = new Money(3, "PLN");
        money.greaterThan(money2);
        //Assert.assertThat(money.greaterThan(money2), is(true)); now OK
    }

}
