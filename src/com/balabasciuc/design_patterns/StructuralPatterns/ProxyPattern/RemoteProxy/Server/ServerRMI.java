package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.RemoteProxy.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {

    public static void startServer()
    {
        try
        {
            Registry registry = LocateRegistry.createRegistry(1020);
            registry.rebind("add", new RIImplement());
        } catch (Exception e) {
            System.out.println(e);
    } }
}
