
var exec = require('cordova/exec');

var PLUGIN_NAME = 'OSCODE';

var GetVersionPlugin = {
  launch_app: function(sucess, failure) {
    exec(sucess, failure, PLUGIN_NAME, 'get_version', []);
  }
};

module.exports = GetVersionPlugin;
