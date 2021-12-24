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
