package com.example.androidclasstest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.example.androidclasstest.Volley.BitmapCache;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends AppCompatActivity implements View.OnClickListener{
    private Button volley_get;
    private Button volley_post;
    private Button volley_json;
    private Button volley_imageRequest;
    private Button volley_imageLader;
    private ImageView volley_image;
    private SimpleDraweeView volley_imageNet;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(VolleyActivity.this);
        setContentView(R.layout.activity_volley);
        initView();

    }

    private void initView(){
        volley_get = findViewById(R.id.volley_get);
        volley_get.setOnClickListener(this);

        volley_post = findViewById(R.id.volley_post);
        volley_post.setOnClickListener(this);

        volley_json =  findViewById(R.id.volley_json);
        volley_json.setOnClickListener(this);

        volley_imageRequest =  findViewById(R.id.volley_imageRequest);
        volley_imageRequest.setOnClickListener(this);

        volley_imageLader =  findViewById(R.id.volley_imageLader);
        volley_imageLader.setOnClickListener(this);

        volley_image =  findViewById(R.id.volley_image);

        volley_imageNet =  findViewById(R.id.volley_imageNet);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.volley_get:
                get();
                break;
            case R.id.volley_post:
                post();
                break;
            case R.id.volley_json:
                json();
                break;
            case R.id.volley_imageRequest:
                image();
                break;
            case R.id.volley_imageLader:
                imageLoader();
                break;
            default:
                break;
        }


    }
    private  void get()
    {
        requestQueue = Volley.newRequestQueue(VolleyActivity.this);

        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    Toast.makeText(VolleyActivity.this, s, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(VolleyActivity.this,"加在错误",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);


    }
    private void post(){

        requestQueue = Volley.newRequestQueue(VolleyActivity.this);

        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(VolleyActivity.this,s,Toast.LENGTH_SHORT).show();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(VolleyActivity.this,"加在错误",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> map = new HashMap<>();
                // map.put("value1","param1");//传入参数

                return map;
            }
        };

        //将post请求添加到队列中
        requestQueue.add(stringRequest);
    }
    private void json(){
        requestQueue = Volley.newRequestQueue(VolleyActivity.this);

        //创建一个请求
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                //TestData data = new Gson().fromJson(String.valueOf(jsonObject),TestData.class);

                //volley_result.setText(jsonObject.toString());
                Toast.makeText(VolleyActivity.this,jsonObject.toString(),Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(VolleyActivity.this,"加在错误",Toast.LENGTH_SHORT).show();

            }
        });

        //将创建的请求添加到队列中
        requestQueue.add(jsonObjectRequest);

    }
    private void image(){
        requestQueue = Volley.newRequestQueue(VolleyActivity.this);

        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524383702&di=b5b98f7d0889037fcff7f8e44877d37b&imgtype=jpg&er=1&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F8%2F5129d65aaa7c4.jpg%3Fdown";

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                volley_image.setImageBitmap(bitmap);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volley_image.setImageResource(R.mipmap.ic_launcher);
            }
        });

        requestQueue.add(imageRequest);

    }
    private void imageLoader(){
        requestQueue = Volley.newRequestQueue(VolleyActivity.this);


        ImageLoader imageLoader = new ImageLoader(requestQueue,new BitmapCache());//带缓存


        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523791267641&di=5eb92a297e1d6f268c7c7bd891b566b7&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0144a5554967400000019ae917a8a4.jpg%401280w_1l_2o_100sh.png";

        ImageLoader.ImageListener imageLister = imageLoader.getImageListener(volley_imageNet,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        imageLoader.get(url,imageLister);


    }
}
