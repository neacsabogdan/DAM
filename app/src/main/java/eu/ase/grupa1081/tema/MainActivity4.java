package eu.ase.grupa1081.tema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private Button btnSign;
    private EditText eTUserName;
    private EditText eTPass;
    private EditText eTEmail;
    private RadioButton rbT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btnSign=findViewById(R.id.btnInregistrare);
        eTUserName=findViewById(R.id.eTUserName);
        eTEmail=findViewById(R.id.eTEmail);
        eTPass=findViewById(R.id.editTextTextPassword2);
        rbT=findViewById(R.id.rBTerms);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                    User u1 = new User();
                    u1.setEmail(eTEmail.getText().toString());
                    u1.setPassword(eTPass.getText().toString());
                    u1.setUsername(eTUserName.getText().toString());
                    Bundle wrapper = new Bundle();
                    wrapper.putSerializable("user",u1);
                    Intent intent = new Intent();
                    intent.putExtra("raspBundle",wrapper);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValid() {
        if (eTUserName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity4.this, "Completati username-ul", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (eTPass.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity4.this, "Completati parola", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (eTEmail.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity4.this, "Completati emailul", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(isEmailValid(eTEmail.getText().toString()))) {
            Toast.makeText(MainActivity4.this, "Email invalid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(rbT.isChecked()== false){
            Toast.makeText(MainActivity4.this,"Acceptati termenele si conditiile",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}