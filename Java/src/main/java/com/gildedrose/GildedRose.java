package com.gildedrose;

import com.gildedrose.items.*;

class GildedRose {
    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public final static String CONJURED_ITEM = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name) {
                case BRIE:
                    new AgedBrie(item).updateStatus();
                    break;
                case SULFURAS:
                    new Sulfuras(item).updateStatus();
                    break;
                case BACKSTAGE_PASSES_ITEM:
                    new BackstagePasses(item).updateStatus();
                    break;
                case CONJURED_ITEM:
                    new Conjured(item).updateStatus();
                    break;
                default:
                    new StandardItem(item).updateStatus();
            }
            checkAndUpdateItemQuality(item);
        }
    }

    public void checkAndUpdateItemQuality(Item item) {
        int MIN_QUALITY = 0;
        int MAX_QUALITY = 50;
        if(item.quality < MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        } else if (item.quality > MAX_QUALITY) {
            int SULFURAS_MAX_QUALITY = 80;
            item.quality = item.name.equals(SULFURAS) ? SULFURAS_MAX_QUALITY : MAX_QUALITY;
        }
    }
}
