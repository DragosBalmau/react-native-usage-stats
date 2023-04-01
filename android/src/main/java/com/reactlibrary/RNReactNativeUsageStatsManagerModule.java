
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import android.app.usage.UsageStatsManager;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import android.app.usage.UsageStats;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.ClassNotFoundException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.Map;
import java.util.HashMap;

public class RNReactNativeUsageStatsManagerModule extends ReactContextBaseJavaModule {
  private static final String INTERVAL_BEST = "INTERVAL_BEST";
  private static final String	INTERVAL_DAILY = "INTERVAL_DAILY";
  private static final String INTERVAL_MONTHLY = "INTERVAL_MONTHLY";
  private static final String	INTERVAL_WEEKLY = "INTERVAL_WEEKLY";
  private static final String	INTERVAL_YEARLY = "INTERVAL_YEARLY";
  private final ReactApplicationContext reactContext;
  private UsageStatsManager mUsageStatsManager;
   private ReactContext mContext;

  public RNReactNativeUsageStatsManagerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNReactNativeUsageStatsManager";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    constants.put(INTERVAL_BEST, UsageStatsManager.INTERVAL_BEST);
    constants.put(INTERVAL_DAILY, UsageStatsManager.INTERVAL_DAILY);
    constants.put(INTERVAL_MONTHLY, UsageStatsManager.INTERVAL_MONTHLY);
    constants.put(INTERVAL_WEEKLY, UsageStatsManager.INTERVAL_WEEKLY);
    constants.put(INTERVAL_YEARLY, UsageStatsManager.INTERVAL_YEARLY);
    return constants;
  }

  @ReactMethod
  public void isAppInactive(String appPackageName, final Promise promise) {
    try {
      mUsageStatsManager = (UsageStatsManager) mContext
         .getSystemService(ReactContext.USAGE_STATS_SERVICE);
      boolean isInactive = mUsageStatsManager.isAppInactive(appPackageName);
      promise.resolve(isInactive);
    } catch (Exception ex) {
      promise.reject("ERR_UNEXPECTED_EXCEPTION", ex);
    }
  }
}
