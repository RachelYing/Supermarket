package superMarket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 扫描的时候要把已经扫描的商品记录下来，累计数量，要把库存的商品减去相应的数量
 * 
 * @author vickydi
 *
 */
public class ItemScanner {
	public Object go(ArrayList<SMItem> ol, ArrayList<SMItem> al, int scannNum, int buyNum) {
		Object object = null;
		for (int a = 0; a < al.size(); a++) {
			if (scannNum != a) {
				object = "无该商品！";
			} else {
				int b = al.get(scannNum).getCount();
				int c = 0;
				double price = 0;
				
				for (int i = 0; i < ol.size(); i++) {
					if (scannNum == i) {//如果已经存在于OL中
						c = ol.get(scannNum).getCount();
						c = c + buyNum;
						ol.get(i).setCount(c);//修改数目
					} else {//如果不存在与OL中
						ol.add(al.get(scannNum));//把它加进去
						ol.get(scannNum).setCount(buyNum);//把数目加上						
					}
					al.get(scannNum).setCount(b - buyNum);//修改库存数量
				}				
				price = al.get(scannNum).getPrice();
				object = c * price;
			}
		}
		return object;
	}
}