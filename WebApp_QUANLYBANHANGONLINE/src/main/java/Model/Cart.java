package Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long, Item> listItem;

    public Cart() {
        listItem = new HashMap<>();
    }

    public Cart(Map<Long, Item> listItem) {
        this.listItem = listItem;
    }

    public Map<Long, Item> getListItem() {
        return listItem;
    }

    public void setListItem(Map<Long, Item> listItem) {
        this.listItem = listItem;
    }
    
    //thêm vào giỏ hàng
    public void AddItem(Long key, Item item) {
    	boolean bol = listItem.containsKey(key);
    	if (bol) {
    		int quantity_old=item.getQuantity();
    		item.setQuantity(quantity_old+1);
    		listItem.put((long) item.getProduct().getMasanpham(),item);
    	}
    	else
    	{
    		listItem.put((long) item.getProduct().getMasanpham(),item);
    	}
    }
    public void SubItem(Long key,Item item) {
    	boolean check=listItem.containsKey(key);
    	if(check) {
    		int quanlity_old=item.getQuantity();
    		if (quanlity_old<=1) {
    			listItem.remove(key);
    		}
    		else
    		{
    			item.setQuantity(quanlity_old-1);
    			listItem.put(key, item);
    		}
    	}
    }
    public void DeleteItem(Long key) {
    	boolean bol= listItem.containsKey(key);
    	if(bol) {
    		listItem.remove(key);
    	}
    }
    public int countItem() {
    	int count=0;
    	count=listItem.size();
    	return count;
    }
    public double total() {
    	int count=0;
    	for (Map.Entry<Long, Item> list : listItem.entrySet()) {
    		count+=list.getValue().getProduct().getDongia()* list.getValue().getQuantity();
    	}
    	return count;
    }
}