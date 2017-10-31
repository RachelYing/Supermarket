package superMarket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 这是管理员的全部功能
 * 
 * @author vickydi
 *
 */
public class ManagerOP {
	public void go(UserView uv, int a) {
		try {
			Socket socket = new Socket("localhost", 8000);
			OutputStream os = socket.getOutputStream();
			os.write(a);
			switch (a) {
			// 按照各自功能，发送需要的数据
			case CommandChoice.ItemStoreIn:
				int itemNum = uv.inStore1();
				os.write(itemNum);
				int inNum = uv.inStore2();
				os.write(inNum);
				socket.shutdownOutput();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String reply;
				while ((reply = br.readLine()) != null) {
					System.out.println(reply);
				}
				// socket.close();
				break;
			case CommandChoice.ItemStoreOut:
				int itemNum3 = uv.outStore1();
				os.write(itemNum3);
				int outNum = uv.outStore2();
				os.write(outNum);
				socket.shutdownOutput();
				InputStream is3 = socket.getInputStream();
				InputStreamReader isr3 = new InputStreamReader(is3);
				BufferedReader br3 = new BufferedReader(isr3);
				String reply3;
				while ((reply3 = br3.readLine()) != null) {
					System.out.println(reply3);
				}
				// socket.close();
				break;
			case CommandChoice.AddItem:
				int b = uv.addItem1();
				os.write(b);
				SMItem sm = uv.addItem2();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(sm);
				socket.shutdownOutput();
				InputStream is4 = socket.getInputStream();
				InputStreamReader isr4 = new InputStreamReader(is4);
				BufferedReader br4 = new BufferedReader(isr4);
				String reply4;
				while ((reply4 = br4.readLine()) != null) {
					System.out.println(reply4);
				}
				// socket.close();
				break;
			case 5:
				socket.shutdownOutput();
				InputStream is5 = socket.getInputStream();
				InputStreamReader isr5 = new InputStreamReader(is5);
				BufferedReader br5 = new BufferedReader(isr5);
				String reply5;
				while ((reply5 = br5.readLine()) != null) {
					System.out.println(reply5);
				}
				// socket.close();
				break;
			case 6:
				socket.shutdownOutput();
				InputStream is6 = socket.getInputStream();
				InputStreamReader isr6 = new InputStreamReader(is6);
				BufferedReader br6 = new BufferedReader(isr6);
				String reply6;
				while ((reply6 = br6.readLine()) != null) {
					System.out.println(reply6);
				}
				// socket.close();
				break;
			case 10:
				socket.shutdownOutput();
				InputStream is10 = socket.getInputStream();
				InputStreamReader isr10 = new InputStreamReader(is10);
				BufferedReader br10 = new BufferedReader(isr10);
				String reply10;
				while ((reply10 = br10.readLine()) != null) {
					System.out.println(reply10);
				}
				// socket.close();
				break;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
