package org.cpm.zwl.commons.utils;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * http certificate util
 * 
 * @author Mailu
 *
 */
public class HttpCertificateUtil {

  /**
   * trust all https certificates
   */
  public static void trustAllHttpsCertificates()
      throws NoSuchAlgorithmException, KeyManagementException {
    TrustManager[] trustAllCerts = new TrustManager[1];
    TrustManager tm = new customTm();
    trustAllCerts[0] = tm;
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, null);
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
  }

  private static class customTm implements TrustManager, X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
        throws CertificateException {
      return;
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
        throws CertificateException {
      return;
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return null;
    }

  }

  /**
   * cancel hostname verifier
   */
  public static void setHostnameVerifier() {
    HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

      @Override
      public boolean verify(String hostname, SSLSession session) {
        return true;
      }
    });
  }
}
