package sg.ihh.ms.fms.app.util.http;

import javax.net.ssl.SSLContext;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPConnectionManager {

    protected static Logger log;

    private static HTTPConnectionManager instance;

    private PoolingHttpClientConnectionManager connManager;

    private HTTPConnectionManager() {

        log = LoggerFactory.getLogger(HTTPConnectionManager.class);
        connManager = new PoolingHttpClientConnectionManager(RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", trustSelfSignCert()).build());
        connManager.setMaxTotal(200);
        connManager.setDefaultMaxPerRoute(20);
    }

    public static HTTPConnectionManager getInstance() {
        if (instance == null) {
            instance = new HTTPConnectionManager();
        }
        return instance;
    }

    public PoolingHttpClientConnectionManager getConnectionManager() {
        return connManager;
    }

    private SSLConnectionSocketFactory trustSelfSignCert() {
        SSLConnectionSocketFactory sslConnFactory = null;
        try {
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial((chain, authType) -> true).build();
            sslConnFactory = new SSLConnectionSocketFactory(sslContext, new String[] {"TLSv1.2"}, null,
                    NoopHostnameVerifier.INSTANCE);
        } catch (Exception ex) {
            log.error("trustSelfSignCert", ex);
        }
        return sslConnFactory;
    }
}

