package com.hogo.rahul.retrofitusingjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {

    ArrayList<Userdatum> mlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getData();
    }

    private void getData() {

        retrofit2.Call<PostGsonModel> postGsonModelCall = Menuapi.getService().getPostList();
        postGsonModelCall.enqueue(new Callback<PostGsonModel>() {
            @Override
            public void onResponse(retrofit2.Call<PostGsonModel> call, Response<PostGsonModel> response) {

                PostGsonModel gsonModel = response.body();
                Toast.makeText(Dashboard.this, "sucess" + gsonModel, Toast.LENGTH_SHORT).show();

                mlist = (ArrayList<Userdatum>) gsonModel.getUserdata();

                for (int i = 0; i < mlist.size(); i++) {
//                    String id = mlist.get

                }
            }

            @Override
            public void onFailure(retrofit2.Call<PostGsonModel> call, Throwable t) {
                Toast.makeText(Dashboard.this, "error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
