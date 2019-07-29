
package com.reactlibrary;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.util.Map;

import javax.annotation.Nullable;

public class RNMyFancyLibraryModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
  private final ReactApplicationContext reactContext;

  public RNMyFancyLibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.reactContext.addLifecycleEventListener(this);
  }


  /** 
    js调用原生toast
   */
  @ReactMethod
  public void show(String message, int duration) {
    Toast.makeText( this.reactContext, message, duration).show();
  }



  
  /** 
    js调用原生页面跳转
   */
  @ReactMethod
  public void startActivityFromJS(String name, String params) {
      try{
          Activity currentActivity = getCurrentActivity();
          if(null!=currentActivity){
              Class toActivity = Class.forName(name);
              Intent intent = new Intent(currentActivity,toActivity);
              intent.putExtra("params", params);
              currentActivity.startActivity(intent);
          }
      }catch(Exception e){
         throw new JSApplicationIllegalArgumentException("不能打开Activity : "+e.getMessage());
      }
  }

  @Override
  public String getName() {
    return "RNMyFancyLibrary";
  }

  @Nullable
  @Override
  public Map<String, Object> getConstants() {
    return super.getConstants();
  }

  @Override
  public void onHostResume() {
    
  }

  @Override
  public void onHostPause() {

  }

  @Override
  public void onHostDestroy() {

  }
}