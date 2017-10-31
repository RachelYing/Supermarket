package superMarket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SMServer {
	ServerSocket serversocket = null;

	public void go() {
		try {
			//设了好几个socket是因为一个我RUN不起来
			serversocket = new ServerSocket(8000);
			Socket socket = serversocket.accept();	
			SMOperator smo=new SMOperator(socket);
			smo.start();
			Socket socket2=serversocket.accept();
			SMOperator smo2=new SMOperator(socket2);
			smo2.start();
			Socket socket3=serversocket.accept();
			SMOperator smo3=new SMOperator(socket3);
			smo3.start();
			Socket socket4=serversocket.accept();
			SMOperator smo4=new SMOperator(socket4);
			smo4.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

