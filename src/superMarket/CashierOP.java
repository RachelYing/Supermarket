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
 * 这是收银员的全部功能
 * 
 * @author vickydi
 *
 */
public class CashierOP {
	public void go(UserView uv,int a) {
		try {
			// 先看客户端发来的功能代号
			Socket socket = new Socket("localhost", 8000);
			OutputStream os = socket.getOutputStream();
			os.write(a);
			switch (a) {
			case CommandChoice.ItemScanner:
				int scannNum = uv.scannItem1();
				os.write(scannNum);
				int buyNum = uv.scannItem2();
				os.write(buyNum);
				socket.shutdownOutput();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String reply;
				while ((reply = br.readLine()) != null) {
					System.out.println(reply);
				}
				//socket.close();
				break;
			case CommandChoice.ManageItemCount:
				int a1 = uv.chItemCount1();
				os.write(a1);
				int b = uv.chItemCount2();
				os.write(b);
				socket.shutdownOutput();
				InputStream is8 = socket.getInputStream();
				InputStreamReader isr8 = new InputStreamReader(is8);
				BufferedReader br8 = new BufferedReader(isr8);
				String reply8;
				while ((reply8 = br8.readLine()) != null) {
					System.out.println(reply8);
				}
				//socket.close();
				break;
			case CommandChoice.CheckOut:
				socket.shutdownOutput();
				InputStream is9 = socket.getInputStream();
				InputStreamReader isr9 = new InputStreamReader(is9);
				BufferedReader br9 = new BufferedReader(isr9);
				String reply9;
				while ((reply9 = br9.readLine()) != null) {
					System.out.println(reply9);
				}
				//socket.close();
				break;
			case CommandChoice.ExitSys:
				socket.shutdownOutput();
				InputStream is10 = socket.getInputStream();
				InputStreamReader isr10 = new InputStreamReader(is10);
				BufferedReader br10 = new BufferedReader(isr10);
				String reply10;
				while ((reply10 = br10.readLine()) != null) {
					System.out.println(reply10);
				}
				//socket.close();
				break;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
