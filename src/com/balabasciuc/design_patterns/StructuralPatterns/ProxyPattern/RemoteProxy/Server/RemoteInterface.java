package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.RemoteProxy.Server;

import java.rmi.*;

public interface RemoteInterface extends Remote
{
	public int add(int x, int y) throws RemoteException;
}