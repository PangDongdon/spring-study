package http;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Description:
 * @Date: 2020/8/6  18:25
 * @Author: dongdong
 */
//实现远程接口
public class GreetServiceImpl extends  java.rmi.server.UnicastRemoteObject implements GreetService {

    private static final long serialVersionUID = 1032811523713405697L;

    protected GreetServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello"+name;
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException, NotBoundException {
        LocateRegistry.createRegistry(1098);
        Naming.bind("rmi://10.108.1.138/GreetService",new GreetServiceImpl());
        GreetService greetService=(GreetService)Naming.lookup("rmi://10.108.1.138/GreetService");
        System.out.println(greetService.sayHello("JObs"));
    }
}
