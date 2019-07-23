package com.example.bestproject;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SPrefActivity extends AppCompatActivity {
    EditText textToSave;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spref);
        sharedPreferences = getPreferences(MODE_PRIVATE);
        textToSave = findViewById(R.id.textToSave);
        Button saveBtn = findViewById(R.id.saveBtn);

        String savedData = sharedPreferences.getString("dataToSave","");
        if(savedData.length()>0){
            textToSave.setText(savedData);
        }
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataToSave = textToSave.getText().toString();
                saveDataIntoPrefs(dataToSave);
            }
        });
    }

    private void   saveDataIntoPrefs(String dataToSave){
       // SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MODE_W);

        SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.putString("dataToSave",dataToSave);
        spEditor.commit();
    }
}
