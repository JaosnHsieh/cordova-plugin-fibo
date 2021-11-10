
module.exports = {
    get: function(n=0){
        return 0;
    },
};

require('cordova/exec/proxy').add('Fibo', module.exports);
