package superMarket;
import java.util.ArrayList;
/**
 * 这是增加商品条目功能
 * @author vickydi
 *
 */
public class AddItem {
	public void go(ArrayList<SMItem> al, SMItem item) {
		al.add(item);
		int a = al.size();
		al.get(a-1).setNum(a);//第N个商品设编号为N
	}
}