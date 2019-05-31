package com.dce.rmi.rmiservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * desc 远程接口
 * @author wu
 * @date Create in 2019/05/31 15:03:40
 *
 */
public interface IRemote extends Remote {

	public int add(int a ,int b) throws RemoteException;
	
	public int sub(int a ,int b) throws RemoteException;
}
