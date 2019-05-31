package com.dce.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.dce.rmi.rmiservice.IRemote;
import com.dce.rmi.rmiservice.impl.RemoteServiceImpl;

public class RMIServer {
	public static void main(String[] args) {

		try {
			// 创建实例化
			IRemote remoteservice = new RemoteServiceImpl();
			// 实例化Registry
			LocateRegistry.createRegistry(1099);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("calc", remoteservice);
			System.out.println("=========服务已绑定==========");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}

	}
}
