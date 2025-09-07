package design_patterns.structural.proxy.network_service_app;

import java.util.Scanner;

public class Exercise {

    // Do not modify the run method. It demonstrates the usage of the Proxy Design Pattern to manage access to a network service.
    public void run() {

        NetworkService networkService = new NetworkServiceProxy();
        Scanner sc = new Scanner(System.in);

        String userInput = sc.nextLine();

        // TODO: Fetch data using the networkService and print the result
        System.out.println(networkService.fetchData(userInput));


        // TODO: Fetch data again using the networkService (should retrieve from cache) and print the result
        System.out.println(networkService.fetchData(userInput));

        sc.close();
    }
}
