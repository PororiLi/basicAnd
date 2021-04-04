package com.porori.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("porori", ""); // 종료될때 저장했던 sharedPreference 값을 불러옴.
        et_save.setText(value);//저장한 값을 et_save에 setText -> et_save에 저장값이 보임.

    }

    @Override
    protected void onDestroy() {//액티비티를 나갈때 하는 행위
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();// SharedPreferences에 값을 임시 저장할때는 editor 사용.
        String value = et_save.getText().toString();
        editor.putString("porori", value);//editor에 putString으로 String 넣음. hong이라는 별명으로 value를 저장함.
        editor.commit();//실재적으로 save 완료하라는 것.

    }
}