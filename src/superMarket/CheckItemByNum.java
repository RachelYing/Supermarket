package superMarket;
import java.util.ArrayList;

/**
 * 这是按编号查询商品信息
 * 
 * @author vickydi
 *
 */
public class CheckItemByNum {
	public String go(ArrayList<SMItem> al, int ckNum) {
		String s = (String) al.get(ckNum).getClass().toString();
		return s;
	}
}
