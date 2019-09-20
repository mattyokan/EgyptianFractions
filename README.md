# EgyptianFractions
Simple programming exercise that I was dared to do by @Quantum64.

## The Premise

A unit fraction is any fraction whose numerator is 1 and denominator is any positive integer. This application will take any fraction and convert it into a form of a sum of unit fractions.

## Strategy

To solve this, I took the simplest approach possible: While the last fraction in a list is not a unit fraction, find the largest unit fraction (1/ceil(denominator/numerator)) possible for itself. Then add that unit fraction to the list and set the last fraction to be itself minus the largest unit fraction.

## Why did I make this?

I had 30 minutes free and felt like it.
