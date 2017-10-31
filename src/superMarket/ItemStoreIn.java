package superMarket;
import java.util.ArrayList;

/**
 * 这是入库功能
 * 
 * @author vickydi
 *
 */
public class ItemStoreIn {
	public int go(ArrayList<SMItem> al, int inItem, int inNum) {
	   SMItem sm=al.get(inItem);
		int oldNum = sm.getCount();
		int newNum = oldNum + inNum;
		sm.setCount(newNum);
		return newNum;
	}
	
	
}
