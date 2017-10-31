package superMarket;
import java.util.ArrayList;

/**
 * 这是阶段功能，返回一种商品的总价
 * 
 * @author vickydi
 *
 */
public class CheckOut {
	public double go(ArrayList<SMItem> ol) {
		double Tprice = 0;
		for (int i = 0; i <= ol.size(); i++) {
			Tprice = Tprice + ol.get(i).getPrice() * ol.get(i).getCount();
		}
		return Tprice;
	}
}
