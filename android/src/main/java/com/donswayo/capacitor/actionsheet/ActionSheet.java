package com.donswayo.capacitor.actionsheet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin
public class ActionSheet extends Plugin {
    @PluginMethod
    public void showActionSheet(final PluginCall call) {
        final String title = call.getString("title");
        final JSArray values = call.getArray("values");

        final String[] arrayValues =new String[values.length()];


        for (int i = 0; i < values.length(); i++) {
            arrayValues[i]=values.optString(i);
        }
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle(title);

        final JSObject ret = new JSObject();

        builder.setItems(arrayValues, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                call.success(ret);
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();


    }
}
