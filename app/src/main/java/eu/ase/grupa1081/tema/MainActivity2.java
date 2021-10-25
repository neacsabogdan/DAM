package eu.ase.grupa1081.tema;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    private Button btnInreg;
    private final int MainActivityRequest=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnInreg=findViewById(R.id.btnSignup);
        btnInreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
                startActivityForResult(intent,MainActivityRequest);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MainActivityRequest){
            if(resultCode==RESULT_OK){
                if(data!=null){
                    Bundle bundle1 = data.getBundleExtra("raspBundle");
                    User u1=(User)bundle1.getSerializable("user");
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("userlog",u1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("rasplog",bundle2);
                    setResult(RESULT_OK,intent2);
                    finish();
                }
            }
        }
    }
}