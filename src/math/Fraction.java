package math;

import service.UnitFractionService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

public class Fraction {

    private BigDecimal numerator;
    private BigDecimal denominator;

    public Fraction(BigDecimal numerator, BigDecimal denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(long numerator, long denominator) {
        this.numerator = new BigDecimal(numerator);
        this.denominator = new BigDecimal(denominator);
    }

    public Fraction(long numerator, BigDecimal denominator) {
        this.numerator = new BigDecimal(numerator);
        this.denominator = denominator;
    }

    public Fraction(BigDecimal numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = new BigDecimal(denominator);
    }

    public BigDecimal getNumerator() {
        return numerator;
    }

    public BigDecimal getDenominator() {
        return denominator;
    }

    public boolean isUnitFraction() {
        return numerator.equals(BigDecimal.ONE);
    }

    public BigDecimal calculateGCD(BigDecimal numerator, BigDecimal denominator) {
        if (numerator.remainder(denominator).equals(BigDecimal.ZERO)) {
            return denominator;
        }
        return calculateGCD(denominator, numerator.remainder(denominator));
    }

    public void reduce() {
        BigDecimal gcd = calculateGCD(numerator, denominator);
        numerator = numerator.divide(gcd, RoundingMode.CEILING);
        denominator = denominator.divide(gcd, RoundingMode.CEILING);
    }

    public void abs() {
        numerator = numerator.abs();
        denominator = denominator.abs();
    }

    public Fraction subtract(Fraction fractionTwo) {
        BigDecimal newNumerator = (numerator.multiply(fractionTwo.denominator)).subtract(fractionTwo.numerator.multiply(denominator));
        BigDecimal newDenominator = denominator.multiply(fractionTwo.denominator);
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.reduce();
        result.abs();
        return result;
    }

    public List<Fraction> toUnitFraction() {
        return UnitFractionService.getInstance().createUnitFraction(this);
    }

    @Override
    public String toString() {
        return String.format("%.0f/%.0f", numerator, denominator);
    }

}

