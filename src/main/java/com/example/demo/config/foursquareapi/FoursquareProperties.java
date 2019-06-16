package com.example.demo.config.foursquareapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "foursquare"
)
public class FoursquareProperties {

    private String apiUrl;

    /*
      This field will indicate which version of the Foursquare API you wish to
      call. If not specified it will use the last publish date of this library.
     */
    private String version;

    private String locale;

    private String clientId;

    private String clientSecret;

    public FoursquareProperties() {}

    public FoursquareProperties(String apiUrl, String version, String locale, String clientId, String clientSecret) {
        this.apiUrl = apiUrl;
        this.version = version;
        this.locale = locale;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public String toString() {
        return "FoursquareProperties{" +
                "apiUrl='" + apiUrl + '\'' +
                ", version='" + version + '\'' +
                ", locale='" + locale + '\'' +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                '}';
    }
}
