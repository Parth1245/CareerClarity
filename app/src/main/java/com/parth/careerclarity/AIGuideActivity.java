package com.parth.careerclarity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AIGuideActivity extends AppCompatActivity {

    EditText input;
    Button btnAsk;
    TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_guide);

        input = findViewById(R.id.input);
        btnAsk = findViewById(R.id.btnAsk);
        response = findViewById(R.id.response);

        btnAsk.setOnClickListener(v -> {
            String question = input.getText().toString();

            if (question.isEmpty()) {
                response.setText("Please enter a question");
            } else {
                callAI(question);  // ✅ REAL AI CALL
            }
        });
    }

    // ✅ REAL AI FUNCTION (FIXED POSITION)
    private void callAI(String message) {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                "{\"message\":\"" + message + "\"}"
        );

        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/ask") // emulator
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() ->
                        response.setText("Error connecting to AI")
                );
            }

            @Override
            public void onResponse(Call call, Response res) throws IOException {
                String result = res.body().string();

                runOnUiThread(() ->
                        response.setText(result)
                );
            }
        });
    }
}