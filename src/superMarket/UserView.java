package superMarket;
import java.util.Scanner;

/**
 * 这是用户界面 只有打印和读客户输入的作用
 * 下面的那些“-1”是为了好和数组下标对应上
 * @author vickydi
 *
 */

public class UserView {
	public Users login() {
		// 二人共有，验证之后再分开讨论，把用户输入信息打包成user类的
		System.out.println("登录身份：");
		Scanner sc = new Scanner(System.in);
		String role = sc.nextLine();
		System.out.println("请输入用户名：");
		String uName = sc.nextLine();
		System.out.println("请输入密码：");
		int pazz = sc.nextInt();
		Users user = new Users(role, uName, pazz);
		return user;// 返回一个user类的对象
	}

	public int CommandManager() {
		// 这是客户能用的功能
		System.out.println("2.商品入库");
		System.out.println("3.商品出库");
		System.out.println("4.增加商品");
		System.out.println("5.查询全部商品");
		System.out.println("6.按编号查询商品");
		System.out.println("10.退出");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		return a;
	}

	public int CommandCashier() {
		// 这是收银员的功能
		System.out.println("7.扫描商品");
		System.out.println("8.修改购买数量");
		System.out.println("9.结账");
		System.out.println("10.退出");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		return a;
	}

	public int inStore1() {
		System.out.println("请输入您要入库的商品编号：");
		Scanner sc = new Scanner(System.in);
		int itemNum = sc.nextInt()-1;
		return itemNum;
	}

	public int inStore2() {
		System.out.println("请输入您要入库的数量：");
		Scanner sc = new Scanner(System.in);
		int inNum = sc.nextInt();
		return inNum;
	}

	public int outStore1() {
		System.out.println("请输入您要出库的商品编号：");
		Scanner sc = new Scanner(System.in);
		int itemNum = sc.nextInt()-1;
		return itemNum;
	}

	public int outStore2() {
		System.out.println("请输入您要出库的数量：");
		Scanner sc = new Scanner(System.in);
		int outNum = sc.nextInt();
		return outNum;
	}

	public int addItem1() {
		System.out.println("请输入您要出库的商品编号：");
		Scanner sc = new Scanner(System.in);
		int itemNum = sc.nextInt()-1;
		return itemNum;
	}

	public SMItem addItem2() {
		// 把用户输入信息打包成SMItem类的，再返回
		System.out.println("请输入您要增加的商品名字：");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("请输入您设定的价格：（不带单位）");
		Double d = sc.nextDouble();
		System.out.println("请输入您设定的单位：（只允许输入RMB）");
		String s2 = sc.nextLine();
		System.out.println("请输入您要入库的数量：（只允许输入大于0的整数）");
		int a = sc.nextInt();
		SMItem sm = new SMItem(s, 0, d, s2, a);
		return sm;
	}

	public int chByNum() {
		System.out.println("请输入您要查询的商品编号：");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt()-1;
		return a;
	}

	public int scannItem1() {
		System.out.println("请输入您要扫描的商品编号：");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt()-1;
		return a;
	}

	public int scannItem2() {
		System.out.println("请输入您要购买的数量：");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		return a;
	}

	public int chItemCount1() {
		System.out.println("请输入您要修改购买数量描的商品编号：");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt()-1;
		return a;
	}

	public int chItemCount2() {
		System.out.println("请再次输入您要购买的数量：");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		return a;
	}
}
