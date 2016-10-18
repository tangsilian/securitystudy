package com.example.jay_tang.asynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;

import java.io.File;

import static com.koushikdutta.async.http.server.AsyncHttpServer.getContentType;

public class MainActivity extends AppCompatActivity {
  public MainActivity mainActivity ;
    File file=new File("/data/local/tmp/uzi.txt");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setport();
    }

    public void setport() {
        AsyncHttpServer server = new AsyncHttpServer();
        server.get("/", new HttpServerRequestCallback() {
            @Override
            public void onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {
                response.send("Hello!!!");
                String type = getContentType(file.getAbsolutePath());
                response.setContentType(type);
                response.sendFile(file);

            }
        });
        server.directory("/name" ,file);

// listen on port 5000
        server.listen(5000);
// browsing http://localhost:5000 will return Hello!!!


    }

}
