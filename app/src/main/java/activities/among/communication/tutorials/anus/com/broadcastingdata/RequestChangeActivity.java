package activities.among.communication.tutorials.anus.com.broadcastingdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RequestChangeActivity extends AppCompatActivity {
    EditText editText;
    Button btn;

    private class myThread extends Thread {
        @Override
        public void run() {


            try {
                Log.d("CLICKED", "NOW");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_change);

        editText = (EditText) findViewById(R.id.changed_text_text_box);
        btn = (Button) findViewById(R.id.btn_request_change);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Intent intent = new Intent();
        intent.setAction("change.text.request");
        intent.putExtra("changed_text", editText.getText().toString());
        sendBroadcast(intent);
    }
}
