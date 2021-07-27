package sg.edu.ro.c346.id16046530.c347_p10_demomusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        // run time permission
        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,  Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PermissionChecker.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,  new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting the service
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stopping the service
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });

    }

}
