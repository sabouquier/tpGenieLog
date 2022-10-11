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
            items[i].quality++;
        }
        items[i].sellIn--;
        if (items[i].sellIn < 0 && items[i].quality > 0) {
            items[i].quality--;
        } else {
            items[i].quality = 0;
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