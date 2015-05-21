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
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import activity.Tools;
import manager.ProductManager;
import manager.UserManager;
import model.Product;
import model.User;


public class MainActivity extends ActionBarActivity {

    private Context context = null;
    private LayoutInflater inflater = null;
    private User LoginUser = null;
    private UserManager userManager = null;
    //定义一些创建对话框类型的标志
    private static final int DIALOG_EXIT = -1;
    private static final int DIALOG_LOGIN = 1; //代表登陆对话框
    private static final int DIALOG_REG = 0; //注册

    //定义关于LIstView相关常量
    private static final int PAGESIZE = 5; //每次取几条记录

    private int PageIndex = 0; //用于保存当前是第几页,0代表第一页
    private ProductManager productManager;
    private List<Product> products = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        showDialog(DIALOG_LOGIN);//调出登陆对话框
        //setContentView(R.layout.activity_main);
    }

    /**
     * 初始化系统数据
     */
    private void init() {
        context = this;
        this.inflater = LayoutInflater.from(this);
        userManager = new UserManager();
        productManager = new ProductManager();

    }

    /**
     * 初始化系统界面
     */
    private void initMainUi() {
        products = productManager.getProductByPager(PageIndex, PAGESIZE);
        setContentView(R.layout.activity_main);
        MyAdapter adapter = new MyAdapter(context);

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
                createLoginDialog(builder);

                break;
            case DIALOG_REG:
                createRegDialog(builder);
                break;
            case DIALOG_EXIT:
                builder.setTitle("警告").setIcon(R.drawable.icon2).setMessage("您确定要退出系统吗？")
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



    private void createLoginDialog(AlertDialog.Builder builder) {
        View v = inflater.inflate(R.layout.login_ui, null);
        builder.setTitle("登陆").setIcon(R.drawable.icon2).setView(v);
        Button btnLog = (Button) v.findViewById(R.id.btnLog);
        final EditText editUserId = (EditText) v.findViewById(R.id.edtUserId);
        final EditText editPassWord = (EditText) v.findViewById(R.id.edtPassWord);
        btnLog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LoginUser = userManager.Login(editUserId.getText().toString(), editPassWord.getText().toString());
                if (LoginUser != null) {
                    dismissDialog(DIALOG_LOGIN);
                    initMainUi();
                } else {
                    Tools.showMessage(context, "账号或密码有误，登陆失败");
                }
            }
        });

        Button btnExit = (Button) v.findViewById(R.id.btnEx);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView linkReg = (TextView) v.findViewById(R.id.linkReg);
        linkReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_REG);
            }
        });
    }



    private String getCheckCode(){
        String strInt = "";
        int i = (int) (Math.random() * 1000000);
        strInt = String.valueOf(i);
        if (strInt.length() != 6) {
            return getCheckCode();
        } else {
            return strInt;
        }
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        if (id == DIALOG_REG) {
            String chkCode = getCheckCode();
            TextView tv = (TextView) dialog.findViewById(R.id.txtChkcode);
            tv.setText(chkCode);
        }
    }

    /**
     * 用户注册
     * @param builder
     */
    private void createRegDialog(AlertDialog.Builder builder) {
        View v = inflater.inflate(R.layout.reg_ui, null);
        builder.setTitle("注册").setIcon(R.drawable.icon2).setView(v);
        Button btnReg = (Button) v.findViewById(R.id.btnReg);
        final EditText editUserId = (EditText) v.findViewById(R.id.edtUserId);
        final EditText editPassWord = (EditText) v.findViewById(R.id.edtPassWord);
        final TextView txtChkCode = (TextView) v.findViewById(R.id.txtChkcode);
        final EditText editChkCode = (EditText) v.findViewById(R.id.edtChkCode);
        btnReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!editChkCode.getText().toString().equals(txtChkCode.getText().toString())) {
                    Tools.showMessage(context, "验证验输入错误，请重新输入!");
                    String chkCode = getCheckCode();
                    txtChkCode.setText(chkCode);
                    return;
                }

                User user = new User(editUserId.getText().toString(), editPassWord.getText().toString());
                User result = userManager.Register(user);
                if (result != null) {
                    dismissDialog(DIALOG_REG);
                } else {
                    Tools.showMessage(context, "注册用户失败!");
                    String chkCode = getCheckCode();
                    txtChkCode.setText(chkCode);
                }
            }
        });

        txtChkCode.setOnClickListener(new View.OnClickListener() {//每次点击验证验刷新
            @Override
            public void onClick(View v) {
                txtChkCode.setText(getCheckCode());
            }
        });

        Button btnExit = (Button) v.findViewById(R.id.btnEx);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog(DIALOG_REG);
            }
        });

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


    class MyAdapter extends BaseAdapter {
        private Context context;
        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return products.size();
        }

        @Override
        public Object getItem(int position) {
            return products.get(position);
        }

        @Override
        public long getItemId(int position) {
            return products.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.productitem, parent, false);
            }
            ImageView imgPhot = (ImageView) convertView.findViewById(R.id.imagePhoto);
            imgPhot.setImageResource(R.drawable.p2);
            TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
            TextView txtPrice = (TextView) convertView.findViewById(R.id.txtPrice);
            txtName.setText(products.get(position).getName().toString());
            txtPrice.setText(String.valueOf(products.get(position).getUnitPrice()));
            return convertView;
        }
    }

}
