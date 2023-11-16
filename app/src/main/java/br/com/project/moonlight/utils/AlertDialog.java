package br.com.project.moonlight.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import br.com.project.moonlight.R;


public class AlertDialog extends AppCompatActivity {

    public static void showCustomDialogAlert(String msg_alert, Activity activityInPlan) {

        ConstraintLayout dialogConstraintLayout = (activityInPlan.findViewById(R.id.activity_custom_dialog));
        View view = LayoutInflater.from(activityInPlan).inflate(R.layout.activity_custom_dialog, dialogConstraintLayout );
        Button btnOk = view.findViewById(R.id.sucessoDone);
        TextView textMSG = view.findViewById(R.id.sucessoDesc);

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(activityInPlan);

        builder.setView(view);
        textMSG.setText(msg_alert);
        final androidx.appcompat.app.AlertDialog alertDialog = builder.create();

        btnOk.findViewById(R.id.sucessoDone).setOnClickListener(view1 -> {
            alertDialog.dismiss();
            Toast.makeText(activityInPlan, msg_alert,Toast.LENGTH_SHORT).show();
        });

        if (alertDialog.getWindow() != null) alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();

    }

    public static void showCustomDialogAlertNewView(String msg_alert, Activity activityInPlan, Class<?> newClassActivity, EnumElements enumElements) {

        ConstraintLayout dialogConstraintLayout = (activityInPlan.findViewById(R.id.activity_custom_dialog));
        View view = LayoutInflater.from(activityInPlan).inflate(R.layout.activity_custom_dialog, dialogConstraintLayout );
        Button btnOk = view.findViewById(R.id.sucessoDone);
        TextView textMSG = view.findViewById(R.id.sucessoDesc);

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(activityInPlan);

        builder.setView(view);
        textMSG.setText(msg_alert);
        final androidx.appcompat.app.AlertDialog alertDialog = builder.create();

        btnOk.findViewById(R.id.sucessoDone).setOnClickListener(view1 -> {

            if(msg_alert.equals(enumElements.toString())) {
                Intent intent = new Intent(activityInPlan, newClassActivity);
                activityInPlan.startActivity(intent);
            }
            alertDialog.dismiss();
            Toast.makeText(activityInPlan, msg_alert, Toast.LENGTH_SHORT).show();
        });

            alertDialog.dismiss();
            Toast.makeText(activityInPlan, msg_alert,Toast.LENGTH_SHORT).show();

        if (alertDialog.getWindow() != null) alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();
        }


}
