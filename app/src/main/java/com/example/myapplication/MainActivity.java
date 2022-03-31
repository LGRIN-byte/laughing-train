package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  { //implements View.OnContextClickListener
    boolean isfirstInput = true; //입력 값이 처음 입력되는가를 체크
    int resultNumber = 0; //계산된 결과 값을 저장하는 변수
    char operator = '+'; // 0인 상태에서 숫자를 입력했을때 resultNumber에 숫자를 입력해야하기 때문에 +사용, 입력된 연산자를 저장하는 변수

    TextView resultText; //텍스트뷰 선언


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result_text); //리소스에 result_text아이디를 가진 뷰를 대입
    }

    @SuppressLint("ResourceType")
    public void buttonClick(View view) { //자바에선 매소드 다른덴 펑션
        if(view.getId() == R.id.all_clear_btn){
            isfirstInput = true;
            resultNumber = 0;
            operator = '+';
            resultText.setTextColor(0xFF666666);
            //resultText.setText(String.valueOf(resultNumber));
            resultText.setText(resultNumber + "");

        }

        Button getButton = findViewById(view.getId());

        if(view.getId() >= R.id.num_0_btn && view.getId() <= R.id.num_9_btn) {
            if (isfirstInput) {
                resultText.setTextColor(0xFF000000);
                resultText.setText(getButton.getText().toString());
                isfirstInput = false;
                               }
            else {
                resultText.append(getButton.getText().toString());
                }
        }


    }
}