package com.example.kovalev_220120;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyDraw extends SurfaceView implements SurfaceHolder.Callback {

    DrawThread drawThread;

    public MyDraw(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawThread = new DrawThread(getContext(), surfaceHolder);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        drawThread.stopReqest();
        boolean retry = true;
        while (retry) {
            try {
                drawThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawThread.setXY((int) event.getX(), (int) event.getY());
        return true;
    }
}
