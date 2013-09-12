package se.footballaddicts.tenpercentgame;

import se.footballaddicts.tenpercentgame.opengl.OpenGLES20Complete;
import android.app.Activity;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity
{
    private GLSurfaceView mGLView;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );

        startActivity( new Intent( this, OpenGLES20Complete.class ) );
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );
        return true;
    }
}
