package superMarket;
import java.io.Serializable;

/**
 * 这是用户信息的数据库
 * 
 * @author vickydi
 *
 */

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	private String role;
	private String name;
	private int pazz;

	public Users(String role, String name, int pazz) {
		this.role = role;
		this.name = name;
		this.pazz = pazz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPazz() {
		return pazz;
	}

	public void setPazz(int pazz) {
		this.pazz = pazz;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
