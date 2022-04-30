package coen352.ch4.list;

/** Doubly linked list node */
public class DLink<E> {

	private Key key;

	private InventoryRecord value; // Value for this node
	
	private DLink<E> next; // Pointer to next node in list
	
	private DLink<E> prev; // Pointer to previous node
	
	/** Constructors */
	DLink(InventoryRecord it, DLink<E> p, DLink<E> n, int count){
		value = it;
		prev = p; 
		next = n;
		key = new Key(count);
	}
	
	DLink(DLink<E> p, DLink<E> n) { 
		prev = p; 
		next = n; 
	}
	
	/** Get and set methods for the data members */
	DLink<E> getNext() {
		return next;
	}
	
	void setNext(DLink<E> nextval) {
		next = nextval;
	}
	
	DLink<E> getPrev() {
		return prev;
	}
	
	void setPrev(DLink<E> prevval) {
		prev = prevval;
	}

	InventoryRecord getValue() {
		return value;
	}

	String getKey() {
		return "IN" + getKeyNum();
	}

	int getKeyNum(){
		return this.key.getNum();
	}

	public DLink<E> compareName(DLink<E> l, DLink<E> r){
		if (l.getValue().getName().compareTo(r.getValue().getName()) >= 0){
			return l;
		}
		else {
			return r;
		}
	}

	DLink<E> compareDesc(DLink<E> l, DLink<E> r){
		if (l.getValue().getDesc().compareTo(r.getValue().getDesc()) >= 0){
			return l;
		}
		else {
			return r;
		}
	}

	DLink<E> comparePrice(DLink<E> l, DLink<E> r){
		if (l.getValue().getPrice() <= r.getValue().getPrice()){
			return l;
		}
		else {
			return r;
		}
	}

	DLink<E> compareStockQuant(DLink<E> l, DLink<E> r){
		if (l.getValue().getStockQuant() <= r.getValue().getStockQuant()){
			return l;
		}
		else {
			return r;
		}
	}

	DLink<E> compareValue(DLink<E> l, DLink<E> r){
		if (l.getValue().getValue() <= r.getValue().getValue()){
			return l;
		}
		else {
			return r;
		}
	}

	DLink<E> compareReorderLevel(DLink<E> l, DLink<E> r){
		if (l.getValue().getReorderLevel() <= r.getValue().getReorderLevel()){
			return l;
		}
		else {
			return r;
		}
	}

	DLink<E> compareReorderTime(DLink<E> l, DLink<E> r){
		if (l.getValue().getReorderTime() <= r.getValue().getReorderTime()){
			return l;
		}
		else {
			return r;
		}
	}

	DLink<E> compareReorderQuant(DLink<E> l, DLink<E> r){
		if (l.getValue().getReorderQuant() <= r.getValue().getReorderQuant()){
			return l;
		}
		else {
			return r;
		}
	}
}