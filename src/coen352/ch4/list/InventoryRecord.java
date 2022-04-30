package coen352.ch4.list;

import java.util.Scanner;

public class InventoryRecord {
    private String name;
    private String desc;
    private int price;
    private int stockQuant;
    private int value;
    private int reorderLevel;
    private int reorderTime;
    private int reorderQuant;
    private boolean disc;

    InventoryRecord(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter all inventory values starting from name.");
        name = scan.nextLine();
        desc = scan.nextLine();
        price = Integer.parseInt(scan.nextLine());
        stockQuant = Integer.parseInt(scan.nextLine());
        value = Integer.parseInt(scan.nextLine());
        reorderLevel = Integer.parseInt(scan.nextLine());
        reorderTime = Integer.parseInt(scan.nextLine());
        reorderQuant = Integer.parseInt(scan.nextLine());
        disc = false;
    }

    InventoryRecord(String n, String d, int p, int sq, int v, int rl, int rt, int rq){
        name = n;
        desc = d;
        price = p;
        stockQuant = sq;
        value = v;
        reorderLevel = rl;
        reorderTime = rt;
        reorderQuant = rq;
        disc = false;
    }

    InventoryRecord(String n, String d, int p, int sq, int v, int rl, int rt, int rq, boolean discontinued){
        name = n;
        desc = d;
        price = p;
        stockQuant = sq;
        value = v;
        reorderLevel = rl;
        reorderTime = rt;
        reorderQuant = rq;
        disc = true;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuant(){
        return stockQuant;
    }

    public int getValue() {
        return value;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public int getReorderQuant() {
        return reorderQuant;
    }

    public int getReorderTime() {
        return reorderTime;
    }

    public boolean isDisc() {
        return disc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStockQuant(int stockQuant) {
        this.stockQuant = stockQuant;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public void setReorderQuant(int reorderQuant) {
        this.reorderQuant = reorderQuant;
    }

    public void setReorderTime(int reorderTime) {
        this.reorderTime = reorderTime;
    }

    public void setDisc(boolean disc) {
        this.disc = disc;
    }
}
