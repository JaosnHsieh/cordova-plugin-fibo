function Fibo() {
}

Fibo.prototype.get = function (n=0,successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "Fibo", "get", [n]);
};


Fibo.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.fibo = new Fibo();
  return window.plugins.fibo;
};

cordova.addConstructor(Fibo.install);