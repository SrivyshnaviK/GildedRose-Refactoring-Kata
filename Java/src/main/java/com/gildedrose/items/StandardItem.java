package com.gildedrose.items;

import com.gildedrose.Item;

public class StandardItem extends CustomItem{
    private Item item;
    public StandardItem(Item item) {
        this.item = item;
    }
    public void updateStatus() {
        this.item.sellIn -=1;
        int qualityValueToBeDecreased = item.name.equals("Conjured") ? 2 : 1;
        if (sellByDayValueIsOverZero()) {
            this.item.quality -= qualityValueToBeDecreased;
        } else {
            this.item.quality -= qualityValueToBeDecreased * 2;
        }
    }

    public int decreasingValueOverZeroDaysToSell() {
        return 1;
    }

    private boolean sellByDayValueIsOverZero() {
        return item.sellIn > 0;
    }
}
