package com.example.jeweller;

import java.util.Comparator;

public class Necklace {
    private Stone stone = new Stone();
    private int amount=0;

    public Necklace(Stone stone, int amount) {
        this.stone = stone;
        this.amount = amount;
    }

    public Stone getStone() {
        return stone;
    }

    public void setStone(Stone stone) {
        this.stone = stone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Necklace{" +
                "stone=" + stone +
                ", amount=" + amount +
                '}';
    }

    public static Comparator<Necklace> rankComparator = new Comparator<Necklace>() {
        @Override
        public int compare(Necklace e1, Necklace e2) {
            return (int) (e1.getStone().getRank() - e2.getStone().getRank());
        }
    };
}
