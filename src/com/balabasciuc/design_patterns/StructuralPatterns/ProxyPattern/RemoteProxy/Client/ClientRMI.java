package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.RemoteProxy.Client;

import com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.RemoteProxy.Server.RemoteInterface;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientRMI {

    public static void startClient()
    {
        try
        {
            RemoteInterface remoteInterface = (RemoteInterface) Naming.lookup("rmi://localhost:1020/add");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter 2 values for adding operation: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Sum is: " + remoteInterface.add(x, y));

        } catch(Exception e) { System.out.println(e);
    }
    }
}
