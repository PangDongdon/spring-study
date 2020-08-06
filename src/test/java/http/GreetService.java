package http;

import java.rmi.RemoteException;

/**
 * @Description:
 * @Date: 2020/8/6  18:23
 * @Author: dongdong
 */
public interface GreetService extends  java.rmi.Remote {
    //创建远程接口，继承java.rmi.Remote接口
    String sayHello(String name)throws RemoteException;
}
