package cidoeq.taniaga.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import cidoeq.taniaga.Model.User;


/**
 * Created by zhorifiandi on 7/30/17.
 */

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "UserSharedPref";
    private static final String TAG_TOKEN = "tagtoken";
    private static final String TAG_NAME = "tagname";
    private static final String TAG_EMAIL = "tagemail";
    private static final String TAG_PHONE = "tagphone";
    private static final String TAG_ADDRESS = "tagaddress";


    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //this method will save the device token to shared preferences
    public boolean saveDeviceToken(String token){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_TOKEN, token);
        editor.apply();
        return true;
    }

    public boolean saveUserInfo(User user){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_TOKEN, getDeviceToken());
        editor.putString(TAG_EMAIL, user.getEmail());
        editor.putString(TAG_NAME, user.getName());
        editor.putString(TAG_ADDRESS, user.getAddress());
        editor.putString(TAG_PHONE, user.getPhonenumber());
        System.out.println("FROM SAVEUSER, TOKEN:");
        System.out.println(getDeviceToken());
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        System.out.println(user.getAddress());
        System.out.println(user.getPhonenumber());
        editor.apply();
        return true;
    }

    public User getUser(){
        User user = new User();
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        user.setAuthToken(getDeviceToken());
        user.setEmail(sharedPreferences.getString(TAG_EMAIL, null));
        user.setName(sharedPreferences.getString(TAG_NAME, null));
        user.setPhonenumber(sharedPreferences.getString(TAG_PHONE, null));
        user.setAddress(sharedPreferences.getString(TAG_ADDRESS, null));
        System.out.println("FROM pref, TOKEN:");
        System.out.println(user.getAuthToken());
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        System.out.println(user.getAddress());
        System.out.println(user.getPhonenumber());

        return user;
    }

    //this method will fetch the device token from shared preferences
    public String getDeviceToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(TAG_TOKEN, null);
    }

    //this method will delete the device token from shared preferences
    public boolean deleteDeviceToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_TOKEN, null);
        editor.apply();
        return true;
    }





}
