package com.example.kovalev_220120;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {

    SurfaceHolder surfaceHolder;
    private boolean running = true;
    private Paint backPaint;
    private Paint paint;
    private int x,y,r;

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {

        x = 0;
        y = 0;
        r = 5;

        this.surfaceHolder = surfaceHolder;
        backPaint = new Paint();
        backPaint.setStyle(Paint.Style.FILL);
        backPaint.setColor(Color.BLACK);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
    }

    public void stopReqest() {
        running = false;
    }

    public void setXY (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawPaint(backPaint);
                    canvas.drawCircle(x, y, r, paint);
                    if (r < 500) r += 1;
                    /*Thread.sleep(300);*/
                /*} catch (InterruptedException e) {
                    e.printStackTrace();*/
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
