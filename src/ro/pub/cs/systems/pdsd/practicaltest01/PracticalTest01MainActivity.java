package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import ro.pub.cs.systems.pdsd.practicaltest01.R;

public class PracticalTest01MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    EditText editText1, editText2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        editText1.setText("0");
        editText2.setText("0");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(editText1.getText().toString());
                editText1.setText("" + ++counter);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(editText2.getText().toString());
                editText2.setText("" + ++counter);
            }
        });

        ((Button) findViewById(R.id.activityButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                int clicks1 = Integer.parseInt(editText1.getText().toString());
                int clicks2 = Integer.parseInt(editText2.getText().toString());

                intent.putExtra("totalClicks", "" + (clicks1 + clicks2));
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("editText1", editText1.getText().toString());
        savedInstanceState.putString("editText2", editText2.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        String text1 = savedInstanceState.getString("editText1");
        String text2 = savedInstanceState.getString("editText2");

        editText1.setText(text1);
        editText2.setText(text2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("REQUEST CODE : " +  requestCode);
        if (requestCode == 1) {
            System.out.println("RESULT CODE : " +  resultCode);
            if (resultCode == 5) {
                String result = data.getStringExtra("result");
                System.out.println(result);
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

            }
        }
    }
}
