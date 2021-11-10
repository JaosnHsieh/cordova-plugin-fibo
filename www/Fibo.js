function Fibo() {
}

Fibo.prototype.get = function (successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "Fibo", "get", []);
};


Fibo.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.fibo = new Fibo();
  return window.plugins.fibo;
};

cordova.addConstructor(Fibo.install);