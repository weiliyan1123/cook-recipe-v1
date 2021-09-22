package tw.tcnr06.recipe;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Cook_DBConnector {

    public static int httpstate=0;
    //--------------------------------------------------------
    private static String postUrl;
    private static String myResponse;
    static String result = null;
    private static OkHttpClient client = new OkHttpClient();
//---------------------------------------------------------

//-------000webhost 維尼-------
static String connect_ip = "https://weili.tcnrcloud110a.com/android_cook_connect_db_new02.php";

//    http://weili.tcnrcloud110a.com/android_cook/android_cook_connect_db_new.php
    //http://weili.tcnrcloud110a.com/android_cook_update_db_a.php
    //https://tcnr2021a06.000webhostapp.com/android_cook/android_cook_update_db.php
    //https://weili.tcnrcloud110a.com/android_cook/android_cook_update_db_a01.php
//-------000webhost 聖寰-------

//    static String XXX_connect_ip = "XXXXXXXXXXXXXXXX網址";

// -------000webhost 晨霖-------
//static String XXX_connect_ip = "XXXXXXXXXXXXXXXX網址";

// -------000webhost 柏昇-------
    //static String XXX_connect_ip = "XXXXXXXXXXXXXXXX網址";

// -------000webhost 柏榕-------
    //static String XXX_connect_ip = "XXXXXXXXXXXXXXXX網址";

// -------000webhost 培揚-------
    //static String XXX_connect_ip = "XXXXXXXXXXXXXXXX網址";



    //===========現在開始為維尼的區塊，勿動===========
    //----------------------------------------------------------------------------------------
    //===========查詢資料===========
    public static String executeQuery_Cook(ArrayList<String> query_string) {//Mysql查詢 標準語法
//        OkHttpClient client = new OkHttpClient();
        postUrl=connect_ip ;
        //--------------建立一個封包
        String query_0 = query_string.get(0);//外面帶參數
        //可寫  String query_0 = "SELECT * FROM......."
        FormBody body = new FormBody.Builder()
                .add("selefunc_string","query")
                .add("query_string", query_0)
                .build();
//--------------丟出封包
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
// ===========================================
        // 使用httpResponse的方法取得http 狀態碼設定給httpstate變數
        httpstate = 0;   //設 httpcode初始值
        // ===========================================
        try (Response response = client.newCall(request).execute()) {
            httpstate = response.code();
            // ===========================================
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //===========新增資料===========
    public static String executeInsert_Cook(ArrayList<String> query_string) {
        //        OkHttpClient client = new OkHttpClient();
        postUrl=connect_ip ;
        //--------------
        String query_0 = query_string.get(0);
        String query_1 = query_string.get(1);


        FormBody body = new FormBody.Builder()
                .add("selefunc_string","insert")
                .add("title", query_0)
                .add("recipe_text", query_1)

                .build();
//--------------
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //===========刪除資料===========
    public static String executeDelet_Cook(ArrayList<String> query_string) {
        //OkHttpClient client = new OkHttpClient();
        postUrl=connect_ip ;
        //--------------
        String query_0 = query_string.get(0);

        FormBody body = new FormBody.Builder()
                .add("selefunc_string","delete")
                .add("id", query_0)
                .build();
//--------------
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //===========更新資料===========
    public static String executeUpdate_Cook(ArrayList<String> query_string) {
//        OkHttpClient client = new OkHttpClient();
        postUrl=connect_ip ;
        //--------------
        String query_0 = query_string.get(0);
        String query_1 = query_string.get(1);
        String query_2 = query_string.get(2);

        FormBody body = new FormBody.Builder()
                .add("selefunc_string","update")
                .add("id", query_0)
                .add("title", query_1)
                .add("recipe_text", query_2)

                .build();
//--------------
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    //===========維尼的區塊結束，勿動===========


    //===========現在開始為聖寰的區塊，勿動===========
    //**************放入你的程式碼*************
    //===========聖寰的區塊結束，勿動===========

    //===========現在開始為晨霖的區塊，勿動===========
    //**************放入你的程式碼*************
    //===========晨霖的區塊結束，勿動===========

    //===========現在開始為柏昇的區塊，勿動===========
    //**************放入你的程式碼*************
    //===========柏昇的區塊結束，勿動===========

    //===========現在開始為柏榕的區塊，勿動===========
    //**************放入你的程式碼*************
    //===========柏榕的區塊結束，勿動===========

    //===========現在開始為培揚的區塊，勿動===========
    //**************放入你的程式碼*************
    //===========培揚的區塊結束，勿動===========




}//DBConnector END