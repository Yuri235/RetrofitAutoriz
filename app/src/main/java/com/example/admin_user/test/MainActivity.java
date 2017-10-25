package com.example.admin_user.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    AutorizationModel model;
    IAutorization iAutorization;
    Call <Object> call;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        model = new AutorizationModel();
        model.setEmail("kerembosar@gmail.com");
        model.setPassword("poli12345");
        model.setPhone("asfasg");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://174.138.54.52:8889/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iAutorization = retrofit.create(IAutorization.class);
         call = iAutorization.getToken(model);
    }

    @Override
    public void onClick(View view) {

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                textView.setText(response.body().toString());
                Toast.makeText(MainActivity.this , "Success" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("mLog:" , "error");
            }
        });
    }
}
