package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends CustomItem{

    private Item item;
    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateStatus() {
        this.item.sellIn -= 1;
        this.item.quality += 1;
    }
}
