package cidoeq.taniaga.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhorifiandi on 7/30/17.
 */

public class User {
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;

    @SerializedName("auth_token")
    @Expose
    private String auth_token;

    public String getEmail() {
        return email;
    }

    public String getAuthToken() {
        return auth_token;
    }
}
