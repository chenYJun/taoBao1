package taobao.cnjun.taobao1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import activity.Tools;
import manager.UserManager;
import model.User;


public class MainActivity extends ActionBarActivity {

    private Context context = null;
    private LayoutInflater inflater = null;
    private User LoginUser = null;
    private UserManager userManager = null;
    //定义一些创建对话框类型的标志
    private static final int DIALOG_EXIT = -1;
    private static final int DIALOG_LOGIN = 1; //代表登陆对话框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        showDialog(DIALOG_LOGIN);//调出登陆对话框
        //setContentView(R.layout.activity_main);
    }

    /**
     * 初始化系统
     */
    private void init() {
        context = this;
        this.inflater = LayoutInflater.from(this);
        userManager = new UserManager();
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
                Button btnLog = (Button) v.findViewById(R.id.btnLog);
                final EditText editUserId = (EditText) v.findViewById(R.id.edtUserId);
                final EditText editPassWord = (EditText) v.findViewById(R.id.edtPassWord);
                //final EditText editPassWord = (EditText) v.findViewById(R.id.edtPassWord);
                btnLog.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        LoginUser = userManager.Login(editUserId.getText().toString(), editPassWord.getText().toString());
                        if (LoginUser != null) {
                            dismissDialog(DIALOG_LOGIN);
                            setContentView(R.layout.activity_main);
                        } else {
                            Tools.showMessage(context, "账号或密码有误，登陆失败");
                        }
                    }
                });
                break;
            case DIALOG_EXIT:
                builder.setTitle("警告").setIcon(R.drawable.icon).setMessage("您确定要退出系统吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNegativeButton("取消", null);
            default:
                break;
        }
        return builder.create();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showDialog(DIALOG_EXIT);
            return true;
        }
        Tools.showMessage(context, "调试false");
        return false;
    }
}
