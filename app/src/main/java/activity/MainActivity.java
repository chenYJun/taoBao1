package activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;

import taobao.cnjun.taobao1.R;


public class MainActivity extends ActionBarActivity {

    private Context context = null;
    private LayoutInflater inflater = null;
    //定义一些创建对话框类型的标志
    private static final int DIALOG_LOGIN = 1; //代表登陆对话框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        this.inflater = LayoutInflater.from(this);
        showDialog(DIALOG_LOGIN);//调出登陆对话框
        //setContentView(R.layout.activity_main);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = this.buildDialog(id);
        return dialog;
    }

    /**
     * 根据不同的ID创建不同的对话框
     * @param flag
     * @return
     */
    private Dialog buildDialog(int flag) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        switch (flag) {
            case DIALOG_LOGIN:
                View v = inflater.inflate(R.layout.login_ui, null);
                builder.setTitle("登陆").setIcon(R.drawable.icon).setView(v);

                break;
            default:
        }
        return builder.create();
    }
}
