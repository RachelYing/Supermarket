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
 * 暂时管理员和收银员不分家，发送USER信息让服务器判断 下面那个MA，没有任何意义！
 * 
 * @author vickydi
 *
 */

public class MAlogin {
	public String login(Users user) {
		try {
			Socket socket = new Socket("localhost", 8000);
			OutputStream os = socket.getOutputStream();
			os.write(1);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(user);
			socket.shutdownOutput();
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String reply;
			while ((reply = br.readLine()) != null) {
				System.out.println(reply);
				if (!reply.equals("对不起，您无权操作。")) {
					System.out.println("请您选择：");
				} else {
					System.exit(0);
				}
			}
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user.getRole();
	}
}