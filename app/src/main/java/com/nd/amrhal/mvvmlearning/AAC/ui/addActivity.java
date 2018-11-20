package com.nd.amrhal.mvvmlearning.AAC.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nd.amrhal.mvvmlearning.R;

public class addActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_TITLE = "title_key";
    public static final String EXTRA_REPLY_BODY = "body_key";

    TextView mtitle, mbody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mtitle = findViewById(R.id.add_title);
        mbody = findViewById(R.id.add_body);


        final Button button = findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mtitle.getText())&& TextUtils.isEmpty(mbody.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String title = mtitle.getText().toString();
                    String body = mbody.getText().toString();

                    replyIntent.putExtra(EXTRA_REPLY_TITLE , title);
                    replyIntent.putExtra(EXTRA_REPLY_BODY , body);

                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }

}
