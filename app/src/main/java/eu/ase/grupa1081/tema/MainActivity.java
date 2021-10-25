package eu.ase.grupa1081.tema;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnInreg;
    private Button btnLogin;
    private final int ReqCode=200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInreg=findViewById(R.id.btninreg);

        btnInreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow=new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(newWindow,ReqCode);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ReqCode){
            if(resultCode==RESULT_OK){
                if(data!=null){
                    Bundle bundle1 = data.getBundleExtra("rasplog");
                    User u1=(User)bundle1.getSerializable("userlog");
                    Intent newWindow3 = new Intent(MainActivity.this,MainActivity3.class);
                    newWindow3.putExtra("login",bundle1);
                    startActivity(newWindow3);
                }
            }
        }
    }
}