package se.footballaddicts.tenpercentgame.opengl;

import android.util.Log;

public class RotationThread extends Thread
{
    private float           value;
    private MyGLSurfaceView myGLSurfaceView;
    private MyGLRenderer    myRenderer;
    private float           speed;
    private float           previousAngle;
    private boolean         decelerate;
    private float           friction = 0.1f;

    public RotationThread( MyGLSurfaceView myGLSurfaceView, MyGLRenderer renderer )
    {
        this.myGLSurfaceView = myGLSurfaceView;
        this.myRenderer = renderer;
    }

    @Override
    public void run()
    {
        super.run();

        while( true )
        {
            Log.d( "deceleration", Math.abs( value ) + "" );

            try
            {
                Thread.sleep( 50 );
            }
            catch( InterruptedException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.d( "rotatespeed", speed + "" );

            if( decelerate )
            {
                if( Math.abs( value ) < 1 )
                {
                    decelerate = false;
                }

                myRenderer.mAngle += value;
                myGLSurfaceView.requestRender();

                speed = (previousAngle - myRenderer.mAngle) / 50;

                if( value > 0 )
                {
                    value -= Math.pow( Math.E, speed * friction );
                }
                else if( value < 0 )
                {
                    value += Math.pow( Math.E, speed * friction );
                }
            }
            else
            {
                speed = (previousAngle - myRenderer.mAngle) / 50;
            }

            previousAngle = myRenderer.mAngle;
        }
    }

    public void decelerate()
    {
        value = speed * 50;
        decelerate = true;
    }

    public void stopRotation()
    {
        value = 0;
        decelerate = false;
    }
}
