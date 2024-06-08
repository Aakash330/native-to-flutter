package com.hellodoctor.nativetoflutter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.clickme).setOnClickListener(v -> {
            try {
                Intent intent = FlutterActivity
                        .withNewEngine()
                        .initialRoute("/")
                        // Specify initial route if needed
                        .build(MainActivity.this);
                startActivity(intent);
            }catch (Exception pe)
            {
                Log.d("errorjhhg",pe.getMessage()+"");
                Toast.makeText(MainActivity.this, "error "+pe.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },2000);


       // FlutterActivity.createDefaultIntent(this);
       /* try {
            Class<?> c = Class.forName("com.example.my_flutter_two.Access");
            startActivity(new Intent(this, c));
            Toast.makeText(this, "goog to go", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            Toast.makeText(this, "erro :"+e.getMessage(), Toast.LENGTH_SHORT).show();

          //  throw new RuntimeException(e);
        }*/


    }
}