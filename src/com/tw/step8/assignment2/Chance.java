package com.tw.step8.assignment2;

import java.util.Objects;

public class Chance {
    private final double probability;

    private Chance(double probability) {
        this.probability = probability;
    }

    public static Chance create(double probability) throws InvalidProbabilityException {
        if (probability < 0 || probability > 1) {
            throw new InvalidProbabilityException(probability);
        }
        return new Chance(probability);
    }

    public Chance complement() throws InvalidProbabilityException {
        return Chance.create(1 -  probability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance = (Chance) o;
        return Double.compare(chance.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(probability);
    }

    public Chance combine(Chance otherChance) throws InvalidProbabilityException {
        double combinedProbability = this.probability * otherChance.probability;
        return Chance.create(combinedProbability);
    }
}
