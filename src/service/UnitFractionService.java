package service;

import math.Fraction;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnitFractionService {

    private static UnitFractionService instance;

    public static UnitFractionService getInstance() {
        if(instance == null) {
            new UnitFractionService();
        }
        return instance;
    }

    public UnitFractionService() {
         instance = this;
    }

    public List<Fraction> createUnitFraction(Fraction baseFraction) {
        if(baseFraction.isUnitFraction()) {
            return Collections.singletonList(baseFraction);
        }

        List<Fraction> fractions = new ArrayList<>();
        Fraction remaining = baseFraction;
        while(!remaining.isUnitFraction()) {
            Fraction largestExtractable = new Fraction(1, remaining.getDenominator().divide(remaining.getNumerator(), RoundingMode.CEILING));
            fractions.add(largestExtractable);
            remaining = remaining.subtract(largestExtractable);
        }
        fractions.add(remaining);
        return fractions;
    }

}
