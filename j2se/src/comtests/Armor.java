package comtests;

import charater.Item;

public class Armor extends Item {
    int ac;
 
    public static void main (String[] args) {
        Armor cloth = new Armor();
        cloth.name = "²¼¼×";
        cloth.price = 300;
        cloth.ac = 15;
 
        Armor chain = new Armor();
        chain.name = "Ëø×Ó¼×";
        chain.price = 500;
        chain.ac = 40;
    }
}