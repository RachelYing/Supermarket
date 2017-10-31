package superMarket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 这是查询功能
 * 
 * @author vickydi
 *
 */
public class CheckItem {
	public String go(ArrayList<SMItem> al) {
		// 全部打印出来，再返回
		String s = null;
		StringBuffer sb = new StringBuffer();
		int size = al.size();
		for (int i = 0; i < size; i++) {
			sb.append(al.get(i).getNum() + " " + al.get(i).getName() + " " + al.get(i).getPrice() + " "
					+ al.get(i).getUnit() + " " + al.get(i).getCount() + " ");
			sb.append("\r\n");// 换行
			s = sb.toString();
		}
		return s;
	}
}
