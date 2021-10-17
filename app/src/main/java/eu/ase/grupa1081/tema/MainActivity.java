package eu.ase.grupa1081.tema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnInreg;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInreg=findViewById(R.id.btninreg);

        btnInreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(newWindow);
            }
        });
        btnLogin=findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow2=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(newWindow2);
            }
        });
    }
}