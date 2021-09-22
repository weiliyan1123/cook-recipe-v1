package tw.tcnr06.recipe;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ACCESS_NETWORK_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    private ImageButton cookBtn,listBtn;
    private Intent intent = new Intent();

    /**********************************************
     permission
     **********************************************/
//所需要申請的權限數組
    private static final String[][] permissionsArray = new String[][]{
            {WRITE_EXTERNAL_STORAGE, "儲存裝置"}
    };
    private List<String> permissionsList = new ArrayList<String>();
    //申請權限後的返回碼
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkRequiredPermission(this);     //  檢查SDK版本, 確認是否獲得權限.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fridge_hp);
        setupViewComponent();
    }
    /**********************************************/
    private void checkRequiredPermission(final Activity activity) { //
//        String permission_check= String[i][0] permission;
        for (int i = 0; i < permissionsArray.length; i++) {
            if (ContextCompat.checkSelfPermission(activity, permissionsArray[i][0]) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permissionsArray[i][0]);
            }
        }
        if (permissionsList.size() != 0) {
            ActivityCompat.requestPermissions(activity, permissionsList.toArray(new
                    String[permissionsList.size()]), REQUEST_CODE_ASK_PERMISSIONS);
        }
    }

    /*** ***********************************
     *  所需要申請的權限數組
     * ************************************/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getApplicationContext(), permissionsArray[i][1] + "權限申請成功!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "權限被拒絕： " + permissionsArray[i][1], Toast.LENGTH_LONG).show();
                        //------------------
                        // 這邊是照官網說法，在確認沒有權限的時候，確認是否需要說明原因
                        // 需要的話就先顯示原因，在使用者看過原因後，再request權限
                        //-------------------
//                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, ACCESS_FINE_LOCATION)) {
//                            Util.showDialog(this, R.string.dialog_msg1, android.R.string.ok, new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    requestNeededPermission();
//                                }
//                            });
//                        } else {
//                            // 否則就直接request
//                            requestNeededPermission();
//                        }
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /*** **************request需要的權限***************/
    private void requestNeededPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, REQUEST_CODE_ASK_PERMISSIONS);
    }

    private void setupViewComponent() {

        cookBtn=(ImageButton)findViewById(R.id.cook_hp_btn);
        listBtn=(ImageButton)findViewById(R.id.list_hp_btn);
        cookBtn.setOnClickListener(this);
        listBtn.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.cook_hp_btn:

                intent.setClass(HomePage.this, Cooklist.class);
                startActivity(intent);
                break;

            case R.id.list_hp_btn://清單

                intent.setClass(HomePage.this, Cooklist.class);
                startActivity(intent);
                break;

        }


    }
}//------------END