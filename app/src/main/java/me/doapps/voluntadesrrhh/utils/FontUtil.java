package me.doapps.voluntadesrrhh.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by jonathan on 22/04/2015.
 */
public class FontUtil {
    public static Typeface setRalewayLight(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/RalewayLight.ttf");
    }

    public static Typeface setRalewayRegular(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/RalewayRegular.ttf");
    }

    public static Typeface setRalewayExtraBold(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/RalewayExtraBold.ttf");
    }
}
