package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by ramascan on 05/04/15.
 */
public class PracticalTest01SecondaryActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        final Intent intent = getIntent();
        if (intent != null){
            String totalClicks = intent.getStringExtra("totalClicks");
            ((EditText) findViewById(R.id.totalClicksText)).setText(totalClicks);
        }

        ((Button) findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("result","The OK button has been pushed.");
                setResult(5,intent);
                finish();
            }
        });

        ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("result","The CANCEL button has been pushed.");
                setResult(5,intent);
                finish();
            }
        });
    }
}
