import math.Fraction;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FractionApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Egyptian Fraction Solver:");
        while(true) {

            System.out.print("p: ");
            long p = scan.nextLong();

            System.out.print("q: ");
            long q = scan.nextLong();

            Fraction frac = new Fraction(p, q);
            frac.reduce();
            frac.abs();

            List<Fraction> result = frac.toUnitFraction();
            System.out.println("Result:\n" + result.stream().map(Fraction::toString).collect(Collectors.joining(" + ")) + " ");
        }
    }
}
