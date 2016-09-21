package org.xumak.camunda.spring.constants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import org.xumak.camunda.spring.api.CamundaAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xumak on 14/09/16.
 */
public class Constants {

    public static final String ALL_USERS_QUERY = "SELECT u FROM User u ORDER BY u.name ASC";
    public static final String ALL_TIME_OFF_HISTORIES_QUERY = "SELECT t FROM TimeOffHistory t";
    public static final String ALL_PHASES_QUERY = "SELECT ph FROM Phase ph";
    public static final String ALL_PHASE_HISTORIES_QUERY = "SELECT phh FROM PhaseHistory phh";
    public static final String ALL_PROCESSES_QUERY = "SELECT p FROM Process p";
    public static final String INITIAL_CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
    public static final String PROVIDER_URL = "ldap://localhost:389/o=xumak,dc=ldap,dc=javier,dc=org";
    public static final String SECURITY_AUTHENTICATION = "simple";
    public static final String SECURITY_PRINCIPAL = "cn=admin,dc=ldap,dc=javier,dc=org";
    public static final String SECURITY_CREDENTIALS = "xumakgt";
    public static CamundaAPI api;

    static {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        Retrofit baseApi = new Retrofit.Builder()
                .baseUrl(CamundaAPI.API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new OkHttpClient())
                .build();
        api = baseApi.create(CamundaAPI.class);
    }
}
