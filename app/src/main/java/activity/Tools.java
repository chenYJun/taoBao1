package activity;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by chen on 15-5-19.
 */
public class Tools {
    public static void showMessage(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
