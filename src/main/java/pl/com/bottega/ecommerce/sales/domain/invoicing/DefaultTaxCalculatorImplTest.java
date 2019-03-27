package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DefaultTaxCalculatorImplTest {

    @Test public void simpleUseCalculate() {
        DefaultTaxCalculatorImpl defaultTaxCalculator = new DefaultTaxCalculatorImpl();
        TaxInfoForCountry taxInfo = defaultTaxCalculator.calculate(ProductType.DRUG);
        Assert.assertThat(taxInfo.getRatio(), is(new BigDecimal("0.05")));
    }

    @Test(expected = IllegalArgumentException.class) public void calculateIncorrectProductType() {
        DefaultTaxCalculatorImpl defaultTaxCalculator = new DefaultTaxCalculatorImpl();
        TaxInfoForCountry taxInfo = defaultTaxCalculator.calculate(ProductType.valueOf("123"));
    }

    @Test(expected = NullPointerException.class) public void calculateNullProductType() {
        DefaultTaxCalculatorImpl defaultTaxCalculator = new DefaultTaxCalculatorImpl();
        TaxInfoForCountry taxInfo = defaultTaxCalculator.calculate(null);
    }
}
