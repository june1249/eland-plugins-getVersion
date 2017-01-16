package com.eland.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Build;

public class GetVersion extends CordovaPlugin {
	
	private final String GET_VERSION = "get_version";

	@Override
	public boolean execute(String action, JSONArray args,
			final CallbackContext callbackContext) throws JSONException {
		if(action.equals(GET_VERSION)) {
			final JSONObject status = new JSONObject();			
			this.cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					int version = Build.VERSION.SDK_INT;					
					try {
						status.put("version", version);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			});			
			PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, status);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);			
		}
		return super.execute(action, args, callbackContext);
	}
	
	

}
