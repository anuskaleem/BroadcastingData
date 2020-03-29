package activities.among.communication.tutorials.anus.com.broadcastingdata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btn;
    IntentFilter intentFilter;

    private final BroadcastReceiver TextReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "change.text.request":
                    textView.setText(intent.getStringExtra("changed_text"));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.change_text);
        btn = (Button) findViewById(R.id.click_me_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RequestChangeActivity.class);
                startActivity(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("change.text.request");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.registerReceiver(TextReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.unregisterReceiver(TextReceiver);
    }
}
