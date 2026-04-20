package LLD.designpatterns.proxypattern.remoteproxy;

public class RealDataService implements IDataService {

    @Override
    public String fetchData() {
        return "Sensitive data from remote server";
    }
}
