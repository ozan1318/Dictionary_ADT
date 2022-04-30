package coen352.ch4.list;

public class Key {
    private String in = "IN";
    private int num;

    Key(int c){
        num = c;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
