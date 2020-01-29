package com.example.kovalev_290120;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {

    SurfaceHolder surfaceHolder;
    private boolean running = true;

    private int[] myColors;
    private int count = 0;

    public DrawThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        myColors = new int[3];
        myColors[0] = Color.GREEN;
        myColors[1] = Color.YELLOW;
        myColors[2] = Color.RED;

    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    if (count > 2) count = 0;
                        canvas.drawColor(myColors[count]);
                        count++;
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopReqest() {
        running = false;
    }
}
