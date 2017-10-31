package superMarket;
import java.io.Serializable;

/**
 * 这是商品数据库
 * @author vickydi
 *
 */
public class SMItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int num;
	private double price;
	private String unit;
	private int count;

	public SMItem(String name, int num, double price, String unit, int count) {
		this.name = name;
		this.num = num;
		this.price = price;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
