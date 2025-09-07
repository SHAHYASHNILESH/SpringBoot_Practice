package design_patterns.structural.proxy.network_service_app;

public class RealNetworkService implements NetworkService {

    private String data;

    @Override
    public String fetchData(String input) {
        data = "Data fetched from remote server for input: " + input;
        return data;
    }
}