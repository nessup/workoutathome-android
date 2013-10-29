package com.joumaa.workouthome;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by dany on 10/29/13.
 */
public class WOAHApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "xvz9p7n25fDe08VYLXJzdgqkoG68yIHoHCk96XdX", "zsMIhjSOUwcKFkpehSqTWGAdloMmsXQtAfzM6MSu");

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }
}
