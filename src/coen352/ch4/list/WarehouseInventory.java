package coen352.ch4.list;

import java.util.Scanner;

public class WarehouseInventory {

    public static void main() {

        DLDict wInv = createDB();
        fillDB(wInv);
        int choice;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Choose one of the options:\n1.Insert\n2.Remove\n3.Clear DB\n4.Find\n5.Return the DB count\n6. Return the total value\n7.Quit\n");
            choice = in.nextInt();
            switch (choice){
                case 1:{
                    insert(wInv);
                }
                case 2:{
                    remove(wInv);
                }
                case 3:{
                    removeAll(wInv);
                }
                case 4:{
                    System.out.println("Enter the key number of the record you want to find (ignore 'IN')");
                    DLink findRes = find(wInv, in.nextInt());
                    if (findRes != null){
                        wInv.setCurrent(findRes);
                    }
                    else {
                        System.out.println("No record with that key found.");
                    }
                }
                case 5:{
                    System.out.println("Database count is " + invNum(wInv));
                }
                case 6:{
                    System.out.println("Total value is " + totalVal(wInv));
                }
                case 7:{
                    return;
                }
            }
        } while (choice != 7);
        return;
    }

    public static DLDict createDB(){
        DLDict inv = new DLDict();
        // LLDict inv = new LLDict();
        return inv;
    }

    public static void insert(DLDict inv){
        InventoryRecord invRec = new InventoryRecord();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the key number of the new record (ignore 'IN')");
        int num = scan.nextInt();
        inv.insert(new Key(num), invRec);
    }

    public static void remove(DLDict inv){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the key number you want to delete (ignore 'IN')");
        int num = scan.nextInt();
        inv.remove(num);
    }

    public static void removeAll(DLDict inv){
        inv.clear();
    }

    public static DLink find(DLDict inv, int k){
         return (DLink) inv.find(k);
    }

    public static void fillDB(DLDict i){
        int n = 1;
        i.setHead(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 51, 25, 1275, 29, 13, 50), null, null, n));
        n++;
        i.getHead().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 93, 132, 12276, 231, 4, 50), i.getHead(), null, n));
        i.setCurrent(i.getHead().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item 25", "Desc 25", 14, 28, 392, 21, 8, 50), i.getCurrent(), null, 25) );
        i.setTail(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 57, 151,8607, 114,11,150), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 19, 186, 3534, 158, 6,	50), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 75, 62,	4650, 39,	12, 50), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 11,	5, 55,	9, 13, 150), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 56, 58,	3248, 109, 7,	100, true), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 38,	101, 3838, 162, 3,	100), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 59, 122, 7198, 82, 3,	150), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 50, 175, 8750, 283, 8,	150), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 59, 176, 10384, 229, 1,	100), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 18, 22,	396, 36, 12, 50), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 26, 72,	1872, 102, 9,100), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 42, 62,	2604, 83,	2,100), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 32, 46,	1472, 23,	15,50), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 90, 96,	8640, 180,3,50), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 97, 57,	5529, 98,	12,	50, true), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 12, 6, 72, 7,	13, 50), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 82, 143, 11726, 164,12,150), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 16, 124, 1984, 113,14,50), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 19, 112, 2128, 75,11,50), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 24, 182, 4368, 132,15,	150), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 29, 106, 3074, 142,	1,	150, true), i.getCurrent(), null, n));
        n++;
        i.setCurrent(i.getCurrent().getNext());
        i.getCurrent().setNext(new DLink(new InventoryRecord("Item " + n, "Desc " + n, 75, 173, 12975, 127,	9,	100), i.getCurrent(), i.getTail(), n));
        n++;
        i.setCount(25);
        i.getTail().setPrev(i.getCurrent());
        i.setCurrent(i.getCurrent().getNext());
    }

    public static int invNum(DLDict inv){
        return inv.getCount();
    }

    public static int totalVal(DLDict inv){
        DLink temp = inv.getHead();
        int val = 0;
        while (temp.getNext() != null){
            val += temp.getValue().getValue();
            temp = temp.getNext();
        }
        val += inv.getTail().getValue().getValue();
        return val;
    }
}