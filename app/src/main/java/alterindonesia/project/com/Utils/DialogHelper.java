package alterindonesia.project.com.Utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

public class DialogHelper {

    public static void alert(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void toast(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }


    public static void toastFailedLoadRetrofit(Context context){
        Toast.makeText(context,"Terjadi masalah sambungan, silahkan coba kembali",Toast.LENGTH_SHORT).show();
    }

    public static void onDevelopProgress(Context context){
        Toast.makeText(context,"Mohon maaf, fitur dalam pengembangan",Toast.LENGTH_SHORT).show();
    }

    public static void showLoading(Context context){
        StoreObjek storeObjek = ((StoreObjek) context.getApplicationContext());
        if(storeObjek.progressDialog != null){
            storeObjek.progressDialog = null;
        }
        storeObjek.progressDialog = new ProgressDialog(context);
        storeObjek.progressDialog.setMessage("Mohon Menunggu");
        storeObjek.progressDialog.setCanceledOnTouchOutside(false);
        storeObjek.progressDialog.show();
    }

    public static void hideLoading(Context context){
        StoreObjek storeObjek = ((StoreObjek) context.getApplicationContext());
        if(storeObjek.progressDialog != null){
            storeObjek.progressDialog.dismiss();
        }
    }

    public static AlertDialog.Builder popupKonfirmasi(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Konfirmasi");
        builder.setMessage("Apakah Anda Yakin?");
        return builder;
    }

    public static AlertDialog.Builder popup(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }

}
