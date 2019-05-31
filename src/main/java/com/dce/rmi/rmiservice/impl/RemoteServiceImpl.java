package com.dce.rmi.rmiservice.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.dce.rmi.rmiservice.IRemote;

/**
 * desc 远程接口实现类
 * @author wu
 * @date Create in 2019/05/31 15:05:40
 */
public class RemoteServiceImpl extends UnicastRemoteObject implements IRemote {

	private int count;
	public RemoteServiceImpl() throws RemoteException {
		count = 0;
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		count++;
		System.out.println("调用次数"+count);
		return a + b;
	}

	@Override
	public int sub(int a, int b) throws RemoteException {
		count++;
		System.out.println("调用次数"+count);
		return a - b;
	}

}
