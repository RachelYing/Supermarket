package superMarket;
/**
 * 这是客户端的主跑函数
 * 
 * @author vickydi
 *
 */
public class CMain {

	public static void main(String[] args) {
		UserView uv = new UserView();
		Users user = uv.login();
		String role = new MAlogin().login(user);//把USER传过去
		ManagerOP cop = new ManagerOP();
		CashierOP caop = new CashierOP();
		
		// 看登录者是谁，该做什么做什么，不按要求输入的用户，给予关闭系统处罚
		if (role.equals("管理员")) {
			int a = uv.CommandManager();
			if (a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 10) {
				cop.go(uv,a);
			} else {
				System.out.println("哎。。。。。能不能看看清楚。再见！");
				System.exit(0);
			}
		}
		if (role.equals("收银员")) {
			int b = uv.CommandCashier();
			if (b == 7 || b == 8 || b == 9 || b == 10) {
				caop.go(uv,b);
			} else {
				System.out.println("哎。。。。。能不能看看清楚。再见！");
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}
}
