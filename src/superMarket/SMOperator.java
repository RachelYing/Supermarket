package superMarket;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
/**
 * 这是服务器处理后台的主要功能集合
 * @author vickydi
 *
 */
public class SMOperator extends Thread {
	private Socket socket;

	public SMOperator(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		go();
	}

	public void go() {
		// 想要对AL本身进行修改，可以这样吗？？？？
		// 能不能写在这里啊？？
		ArrayList<SMItem> al = new ArrayList<SMItem>();
		//这些商品一律不对外销售
		SMItem milk = new SMItem("草莓牛奶", 1, 3.52, "RMB", 100);
		SMItem sword = new SMItem("洞爷湖", 2, 25, "RMB", 100);
		SMItem doll = new SMItem("伊丽莎白", 3, 300, "RMB", 100);
		SMItem dog = new SMItem("定春", 4, 690, "RMB", 100);
		SMItem gun = new SMItem("JUST WE", 5, 5.1, "RMB", 100);
		al.add(milk);
		al.add(sword);
		al.add(doll);
		al.add(dog);
		al.add(gun);
		//OL是购买清单
		ArrayList<SMItem> ol = new ArrayList<SMItem>();
		Users user1 = new Users("管理员","银时", 123);
		Users user2 = new Users("收银员","桂", 456);
		int i;
		try {
			InputStream in = socket.getInputStream();
			switch (i = in.read()) {
			case CommandChoice.Login:
				String info = null;
				ObjectInputStream ois = new ObjectInputStream(in);
				Object object = ois.readObject();
				Users user = (Users) object;
				socket.shutdownInput();
			  boolean z=user.getRole().equals(user1.getRole());
			  boolean x=user.getName().equals(user1.getName());
			  boolean v=user.getPazz()==user1.getPazz();
			  boolean z1=user.getRole().equals(user2.getRole());
			  boolean x1=user.getName().equals(user2.getName());
			  boolean v1=user.getPazz()==user2.getPazz();
			  //验证用户信息
				if ((z&&x&&v)|| (z1&&x1&&v1) ) {
					info = user.getName() + " 欢迎登录！";
				} 				
				else {
					info = "对不起，您无权操作。";
				}
				byte[] infos = info.getBytes();
				OutputStream os = socket.getOutputStream();
				os.write(infos);
				os.close();
				//socket.close();
				break;
			case CommandChoice.ItemStoreIn:
				InputStream in2 = socket.getInputStream();
				int itemNum = new InputStreamReader(in2).read();
				InputStream in2s = socket.getInputStream();
				int inNum = new InputStreamReader(in2s).read();
				socket.shutdownInput();
				int newNum = new ItemStoreIn().go(al, itemNum, inNum);
				String info2 = "商品数量增加成功！" + "现在该商品的数量为：" + newNum;
				byte[] infos2 = info2.getBytes();
				OutputStream os2 = socket.getOutputStream();
				os2.write(infos2);
				os2.close();
				//socket.close();
				break;
			case CommandChoice.ItemStoreOut:
				String info3;
				InputStream in3 = socket.getInputStream();
				int itemNum2 = new InputStreamReader(in3).read();
				InputStream in3s = socket.getInputStream();
				int outNum = new InputStreamReader(in3s).read();
				socket.shutdownInput();
				Object object2 = new ItemStoreOut().go(al, itemNum2, outNum);
				if (object2 instanceof Integer) {
					info3 = "商品删减成功！" + "现在该商品的数量为：" + object2;
				} else {
					info3 = (String) object2;
				}
				byte[] infos3 = info3.getBytes();
				OutputStream os3 = socket.getOutputStream();
				os3.write(infos3);
				os3.close();
				//socket.close();
				break;
			case CommandChoice.AddItem:
				InputStream in4 = socket.getInputStream();
				ObjectInputStream ois4 = new ObjectInputStream(in4);
				socket.shutdownInput();
				Object object4 = ois4.read();
				SMItem itemm = (SMItem) object4;				
				new AddItem().go(al, itemm);
				String info4 = "增加成功！";
				byte[] infos4 = info4.getBytes();
				OutputStream os4 = socket.getOutputStream();
				os4.write(infos4);
				os4.close();
			    //socket.close();
				break;
			case CommandChoice.CheckItem:
				socket.shutdownInput();
				String s = new CheckItem().go(al);
				byte[] infos5 = s.getBytes();
				OutputStream os5 = socket.getOutputStream();
				os5.write(infos5);
				os5.close();
				//socket.close();
				break;
			case CommandChoice.CheckItemByNum:
				InputStream in6 = socket.getInputStream();
				int ckNum = new InputStreamReader(in6).read();
				socket.shutdownInput();
				String s2 = new CheckItemByNum().go(al, ckNum);
				byte[] infos6 = s2.getBytes();
				OutputStream os6 = socket.getOutputStream();
				os6.write(infos6);
				os6.close();
				//socket.close();
				break;
			case CommandChoice.ItemScanner:
				InputStream in7 = socket.getInputStream();
				int scannNum = new InputStreamReader(in7).read();
				InputStream in7s = socket.getInputStream();
				int buyNum = new InputStreamReader(in7s).read();
				socket.shutdownInput();
				Object object3 = new ItemScanner().go(ol, al, scannNum, buyNum);
				String info7;
				if (object3 instanceof Double) {
					info7 = "总价为：" + object3;
				} else {
					info7 = (String) object3;
				}
				byte[] infos7 = info7.getBytes();
				OutputStream os7 = socket.getOutputStream();
				os7.write(infos7);
				os7.close();
				//socket.close();
				break;
			case CommandChoice.ManageItemCount:
				InputStream in8 = socket.getInputStream();
				int wtcNum = new InputStreamReader(in8).read();
				InputStream in8s = socket.getInputStream();
				int chNum = new InputStreamReader(in8s).read();
				socket.shutdownInput();
				String info8 = new ManageItemCount().go(ol, al, wtcNum, chNum);
				byte[] infos8 = info8.getBytes();
				OutputStream os8 = socket.getOutputStream();
				os8.write(infos8);
				os8.close();
				//socket.close();
				break;
			case CommandChoice.CheckOut:
				socket.shutdownInput();
				double Tprice = new CheckOut().go(ol);
				String info9 = "您购买的总金额为：" + Tprice + ol.get(0).getUnit();
				byte[] infos9 = info9.getBytes();
				OutputStream os9 = socket.getOutputStream();
				os9.write(infos9);
				os9.close();
				//socket.close();
				break;
			case CommandChoice.ExitSys:
				socket.shutdownInput();
				String info10 = "退出成功！";
				byte[] infos10 = info10.getBytes();
				OutputStream os10 = socket.getOutputStream();
				os10.write(infos10);
				os10.close();
				//socket.close();
				break;
			default:
				String info33 = "操作错误！";
				byte[] infos33 = info33.getBytes();
				OutputStream os33 = socket.getOutputStream();
				os33.write(infos33);
				os33.close();
				//socket.close();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
