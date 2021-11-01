package eu.ase.grupa1081.tema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    private EditText etemail;
    private EditText etpass;
    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String email = intent.getStringExtra("text1");
        String pass =intent.getStringExtra("text2");

        etemail=findViewById(R.id.EmailLogin);
        etpass=findViewById(R.id.PassLogin);
        if(email != "" && pass != ""){
        etemail.setText(email);
        etpass.setText(pass);
        }

        btnlogin=findViewById(R.id.butonlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etemail.getText().toString() != "" && etpass.getText().toString() != ""){
                Intent newWindow4=new Intent(MainActivity3.this,MainActivity5.class);
                startActivity(newWindow4);
            }
            }
        });
    }
}