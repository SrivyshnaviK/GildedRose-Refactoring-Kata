package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePasses extends CustomItem {
    private Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }
    @Override
    public void updateStatus() {
        item.sellIn -= 1;
        if (hasSellByDayCrossed(10)) {
            item.quality += 1;
        } else if (hasSellByDayCrossed(5)) {
            item.quality += 2;
        } else if (hasSellByDayCrossed(0)) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }
    }


    private boolean hasSellByDayCrossed(int dayNumber) {
        return item.sellIn > dayNumber;
    }
}
