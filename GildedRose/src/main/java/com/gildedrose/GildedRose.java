package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }    

    public void sulfuras(int i){
        return;
    }

    public void agedBrie(int i){
        if(items[i].quality < 50){
            items[i].quality++;
        }
        items[i].sellIn--;
        if(items[i].sellIn < 0 && items[i].quality < 50){
            items[i].quality++;
        }
    }

    public void backstage(int i){
        if(items[i].quality < 50){
            items[i].quality++;
        }
        if(items[i].quality < 50 && items[i].sellIn < 11){
            items[i].quality++;
        } 
        if(items[i].quality < 50 && items[i].sellIn < 6){
            items[i].quality++;
        }
        items[i].sellIn--;
        if(items[i].sellIn < 0 ){
            items[i].quality = 0;
        }
        
    }

    public void other(int i){
        if (items[i].quality > 0) {
            items[i].quality--;
        }
    

                    
                 else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;

                        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (items[i].sellIn < 11) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }

                            if (items[i].sellIn < 6) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }
                        }
                    }
                }

                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].sellIn = items[i].sellIn - 1;
                }

                if (items[i].sellIn < 0) {
                    if (!items[i].name.equals("Aged Brie")) {
                        if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (items[i].quality > 0) {
                                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                    items[i].quality = items[i].quality - 1;
                                }
                            }
                        } else {
                            items[i].quality = 0;
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if(items[i].name == "Sulfuras, Hand of Ragnaros"){
                sulfuras(i);
            }
            else if(items[i].name == "Aged Brie"){
                agedBrie(i);
            }
            else if(items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                backstage(i);
                            
                
            }
            else {
                other(i);
                

                
            }
        }
    }
}