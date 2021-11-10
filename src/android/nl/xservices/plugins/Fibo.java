package nl.xservices.plugins;

import android.view.WindowManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;

public class Fibo extends CordovaPlugin {

  private static final String ACTION_GET = "get";

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    try {
      if (ACTION_GET.equals(action)) {
          //https://cordova.apache.org/docs/en/10.x/guide/platforms/android/plugin.html
        String s = args.toString();
        Log.d("$ args.toString() s", s);
        int n = (int) args.getLong(0);
        int value = this.getFibo(n);
        callbackContext.success(value);
        return true;
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