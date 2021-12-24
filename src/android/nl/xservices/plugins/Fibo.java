package nl.xservices.plugins;

import android.view.WindowManager;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import java.lang.reflect.Method;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class Fibo extends CordovaPlugin {
  private CordovaWebView webView;
  private static final String LOG_TAG = "$ testtest";
  private static final String ACTION_GET = "get";
  
  @Override
  public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
      Log.d(LOG_TAG, "initialize");
      this.webView = webView;
      super.initialize(cordova, webView); 
      // try{
      // Log.d(LOG_TAG, "before getSettings");
      // webView.getClass().getMethod("getSettings");
      // Log.d(LOG_TAG, "after getSettings");
      // }catch(Exception e){
      //   Log.d(LOG_TAG, "exception");
      //   Log.e(LOG_TAG, "exception", e);
      // }
      
  }

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    try {
      if (ACTION_GET.equals(action)) {
        WebView inView = (WebView) this.webView.getView();
        // Boolean a = this.webView.isInitialized;

        // Log.d(LOG_TAG,this.webView.CORDOVA_VERSION);
        // Log.d(LOG_TAG,"after version");
        // // this.webView.clearHistory();
        //   // THIS PART IS MODIFIED BY THE PLUGIN
        // WebView webView = (WebView) this.webView.getView();
        // Log.d(LOG_TAG,"after getView()");
        // webView.getSettings().setTextSize(WebSettings.TextSize.LARGEST);
        // Log.d(LOG_TAG,"after setTextSize(WebSettings.TextSize.LARGEST)");
        
        // webView.getSettings().setLoadWithOverviewMode(true);
        // webView.getSettings().setUseWideViewPort(true);
        
        cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                  Log.d(LOG_TAG,"before Log.d(LOG_TAG,inView.SCHEME_GEO);");
                  Log.d(LOG_TAG,inView.SCHEME_GEO);
                  Log.d(LOG_TAG,"after Log.d(LOG_TAG,inView.SCHEME_GEO);");
                  inView.getSettings().setTextSize(WebSettings.TextSize.LARGEST);
                  Log.d(LOG_TAG,"after setTextSize(WebSettings.TextSize.LARGEST)");
        

                  // String s = args.toString();
                  // Log.d("$ args.toString() s", s);
                  // try{
                  // int n = (int) args.getLong(0);
                  // int value = getFibo(n);
                  // callbackContext.success(value);
                  // }catch(Exception e){
                  //   Log.e(LOG_TAG,"exception",e);
                  // }
                  //   // Log.d(LOG_TAG, "before setTextSize");
                  //   webView.getSettings().setTextSize(100);
                    // Log.d(LOG_TAG, "after setTextSize");
                    // webView.getSettings().setUseWideViewPort(true);
                    
                    // if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            	      //   webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            	
            	      //   Log.d(LOG_TAG, "setMediaPlaybackRequiresUserGesture: FALSE");
                    // }
                    
                    // callbackContext.success();
                }
            });
          return true;
        
        // Log.d(LOG_TAG, action);
        // Method getWhitelist = this.webView.getClass().getMethod("getWhitelist");
        // Log.d(LOG_TAG, "getWhitelist");
        // Method getSettings = this.webView.getClass().getMethod("getSettings");
        // Log.d(LOG_TAG, "getSettings");
        // Object wSettings = getSettings.invoke(this.webView);
        // Log.d(LOG_TAG, "invoke");        
        // Method getTextSize = wSettings.getClass().getMethod("getTextSize");
        // Log.d(LOG_TAG, "getTextSize");        
        // WebSettings.TextSize wTextSize = (WebSettings.TextSize) getTextSize.invoke(wSettings);
        
          
          //https://cordova.apache.org/docs/en/10.x/guide/platforms/android/plugin.html
        
        // cordova.getActivity().runOnUiThread(
        //     new Runnable() {
        //       public void run() {
              
        //         // callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        //       }
        //     });

      } else {
        callbackContext.error("Fibo." + action + " is not a supported function. Did you mean '" + ACTION_GET + "'?");
        return false;
      }
    } catch (Exception e) {
      callbackContext.error(e.getMessage());
      return false;
    }
  }

  private int getFibo(int n){
      if( n <= 1){
        return  n;
      }

      return this.getFibo(n - 1) + this.getFibo(n - 2);
  }
}