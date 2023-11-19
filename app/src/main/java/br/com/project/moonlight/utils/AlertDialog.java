package br.com.project.moonlight.utils;

import static br.com.project.moonlight.utils.EnumElements.MSG_ALERT;
import static br.com.project.moonlight.utils.EnumElements.MSG_VOLTAR;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import br.com.project.moonlight.MainActivity;
import br.com.project.moonlight.R;
import cn.pedant.SweetAlert.SweetAlertDialog;


public class AlertDialog extends AppCompatActivity {



    public void alertDialog(Context context, EnumElements enumElements){

        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(MSG_ALERT.toString())
                .setContentText(enumElements.toString())
                .setConfirmText(MSG_VOLTAR.toString()).show();

    }

    public void alertDialogErro(Context context, EnumElements enumElements){

        new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(MSG_ALERT.toString())
                .setContentText(enumElements.toString())
                .setConfirmText(MSG_VOLTAR.toString()).show();

    }

    public void alertDialogOk(Context context, EnumElements enumElements, Activity activity) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setTitleText(MSG_ALERT.toString())
                .setContentText(enumElements.toString())
                .setConfirmText(MSG_VOLTAR.toString())
                .setConfirmClickListener(sDialog -> {
                    // Código para redirecionar para uma nova activity
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);

                    // Finalizar a activity atual (se necessário)
                    activity.finish();
                }).show();
    }
}
