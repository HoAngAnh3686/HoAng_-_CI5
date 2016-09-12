package ss2.vn.tk.myapplication;

import android.hardware.Camera;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private ToggleButton toggleButton;
    private Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCamera();
        setContentView(R.layout.activity_main);
        getReferences();
        toggleButton.setChecked(true);
        addListeners();
    }
    private void getCamera(){
        try {
            camera = Camera.open();
        }
        catch (RuntimeException e){
            Log.e(TAG, String.format("Could not open camera", e.getMessage()));
        }
    }
    private void getReferences(){
        toggleButton=(ToggleButton) findViewById(R.id.tb_Flash);
    }
    private void addListeners(){
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, String.format("check change : %s", isChecked));
                if (isChecked) {
                    Camera.Parameters parameters = camera.getParameters();

                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

                    camera.setParameters(parameters);
                }
                else {
                    Camera.Parameters parameters = camera.getParameters();

                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);

                    camera.setParameters(parameters);

                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
