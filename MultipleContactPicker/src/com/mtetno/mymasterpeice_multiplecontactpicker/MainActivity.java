package com.mtetno.mymasterpeice_multiplecontactpicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        mTextView.setText("Click");

        mTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final int request_code = 1010;
                startActivityForResult(new Intent(MainActivity.this,
                        ContactPicker.class), request_code);

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && !data.getExtras().isEmpty()
                && data.getExtras().containsKey("selectedContacts")) {

            Object[] objArray = (Object[]) data.getExtras().getSerializable(
                    "selectedContacts");
            String selectedContacts[][] = null;
            if (objArray != null) {
                selectedContacts = new String[objArray.length][];
                
                for (int i = 0; i < objArray.length; i++) {
                    selectedContacts[i] = (String[]) objArray[i];

                    

                }
                //[[24, Tablet, 412578369688, Mobile], [48, Qwrtty, (879) 333-0922, Mobile]]
                mTextView.setText("\n" +"Name :"+selectedContacts[0][1]+"\n Mobile :"+selectedContacts[0][2]);
                // Now selectedContacts[] contains the selected contacts
            }
        }

    }
}
