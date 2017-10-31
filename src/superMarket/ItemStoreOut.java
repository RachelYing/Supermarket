package superMarket;
import java.util.ArrayList;

/**
 * 这是出库功能
 * 
 * @author vickydi
 *
 */
public class ItemStoreOut {
	// 根据不一样的情况，返回的可能是数字也可能是字符串
	public Object go(ArrayList<SMItem> al, int outItem, int outNum) {
		Object object;
		int oldNum = ((SMItem) al.get(outItem)).getCount();
		if (oldNum >= outNum) {
			int newNum = oldNum - outNum;
			((SMItem) al.get(outItem)).setCount(newNum);
			object = newNum;
		} else {
			object = "库存没有这么多";
		}
		return object;
	}
}