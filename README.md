## branch set-text-webview

test to solve `framework7` fab icon wrong position on android issue.

`http://github.com/phonegap/phonegap-mobile-accessibility` seems working, it was showing error first during installing. But now it works again.

## References

https://stackoverflow.com/questions/54975291/angular-material-icon-not-centered-in-android-app-with-cordova

https://github.com/gitawego/cordova-webview-setting/blob/master/src/android/WebviewSetting.java

https://github.com/apache/cordova-android/blob/master/framework/src/org/apache/cordova/CordovaWebView.java

https://developer.android.com/reference/android/webkit/WebSettings.TextSize

# cordova-plugin-fibo

For testing cordova plugin only, get fibo from mobile native code....

template copied from https://github.com/EddyVerbruggen/Insomnia-PhoneGap-Plugin#readme

## Run

`npm i -g cordova@10.1.0`

`cordova create hello com.example.hello HelloWorld`

`cd hello`

`cordova platform add android` ("cordova-android": "^9.1.0")

`cordova plugin add https://github.com/JaosnHsieh/cordova-plugin-fibo.git`

modify `www/js/index.js` to add `test` function after `deviceready`

```diff
@@ -26,4 +26,17 @@ function onDeviceReady() {

   console.log('Running cordova-' + cordova.platformId + '@' + cordova.version);
   document.getElementById('deviceready').classList.add('ready');
+  test();
+}
+
+function test() {
+  window.plugins.fibo.get(
+    10,
+    (val) => {
+      alert(`window.plugins.fibo.get(10...) got val ${val}`);
+    },
+    (err) => {
+      alert(`err ${err}`);
+    },
+  );
 }
```

`cordova run android` (connected the android phone to computer or using emulator)
