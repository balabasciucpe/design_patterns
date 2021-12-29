package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.RemoteProxy.Server;

import java.rmi.*;
import java.rmi.server.*;

public class RIImplement extends UnicastRemoteObject implements RemoteInterface
{
 public RIImplement() throws RemoteException
	{
		super(); 
	}
  public int add(int x, int y)
  {
     return x + y;
  }
}