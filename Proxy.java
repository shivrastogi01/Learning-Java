import org.apache.http.HttpHost;
import org.apache.http.client.fluent.*;

public class Proxy {
    public static void main(String[] args) throws Exception {
        System.out.println("To enable your free eval account and get "
            +"CUSTOMER, YOURZONE and YOURPASS, please contact "
            +"sales@luminati.io");
        HttpHost proxy = new HttpHost("zproxy.lum-superproxy.io", 22225);
        String res = Executor.newInstance()
            .auth(proxy, "lum-customer-c_1d5d85eb-zone-static", "3ikp3c2ygvjb")
            .execute(Request.Get("http://lumtest.com/myip.json").viaProxy(proxy))
            .returnContent().asString();
        System.out.println(res);
    }
}