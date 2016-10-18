package com.example.jay_tang.asynctask;

import android.graphics.Bitmap;
import android.os.Looper;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;

import java.io.ByteArrayOutputStream;

//import com.example.jay_tang.asynctask.ScreenShotFb;

/**
 * Created by Jay-Tang on 2016/10/17.
 */
public class Main {
    static  public MainActivity mainActivity ;

    static Looper looper;

    public static void main(String[] args) {

        AsyncHttpServer httpServer = new AsyncHttpServer() {
            protected boolean onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {
                return super.onRequest(request, response);
            }
        };

        Looper.prepare();
        looper = Looper.myLooper();
        System.out.println("Andcast Main Entry!");
        AsyncServer server = new AsyncServer();
        httpServer.get("/screenshot.jpg", new AnonymousClass5());
        httpServer.listen(server, 53516);

        Looper.loop();

    }

    /* renamed from: com.koushikdutta.vysor.Main.5 */
    static class AnonymousClass5 implements HttpServerRequestCallback {

        public void onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {
            try {

                Bitmap bitmap = ScreenShot.shoot(mainActivity);
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bout);
                bout.flush();
                response.send("image/jpeg", bout.toByteArray());
                return;
            } catch (Exception e) {
                response.code(500);
                response.send(e.toString());
                return;
            }
        }
    }
}