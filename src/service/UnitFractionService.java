package service;

import math.Fraction;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UnitFractionService {

    private static UnitFractionService instance;

    public static UnitFractionService getInstance() {
        if(instance == null) {
            new UnitFractionService();
        }
        return instance;
    }

    private NumberFormat numberFormat;

    public UnitFractionService() {
         instance = this;
         numberFormat = NumberFormat.getInstance();
    }

    public List<Fraction> createUnitFraction(Fraction baseFraction) {
        if(baseFraction.isUnitFraction()) {
            return Collections.singletonList(baseFraction);
        }

        List<Fraction> fractions = new ArrayList<>();
        Fraction remaining = baseFraction;
        while(!remaining.isUnitFraction()) {
            Fraction largestExtractable = new Fraction(1, baseFraction.getDenominator().divide(baseFraction.getNumerator(), RoundingMode.CEILING));
            fractions.add(largestExtractable);
            remaining = remaining.subtract(largestExtractable);
        }
        fractions.add(remaining);
        return fractions;
    }

    public NumberFormat getNumberFormat() {
        return numberFormat;
    }
}
