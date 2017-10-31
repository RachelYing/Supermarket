package superMarket;
import java.util.ArrayList;

/**
 * 这是修改已经购买的数量
 * 
 * @author vickydi
 *
 */
public class ManageItemCount {
	public String go(ArrayList<SMItem> ol, ArrayList<SMItem> al, int wtcNum, int chNum) {
		int d = al.get(wtcNum).getCount() + ol.get(wtcNum).getCount() - chNum;
		// 库存里的数量+原先购买的数量-新购买的数量=现在库存的数量
		ol.get(wtcNum).setCount(chNum);
		al.get(wtcNum).setCount(d);
		String s = "数量修改成功";
		return s;
	}
}
