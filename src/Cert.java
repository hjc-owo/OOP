import java.util.ArrayList;
import java.util.List;

public class Cert {
    String Aadhaar;
    int cert;

    static List<Cert> certs = new ArrayList<>();

    public Cert(String Aadhaar, int cert) {
        this.Aadhaar = Aadhaar;
        this.cert = cert;
    }
}
