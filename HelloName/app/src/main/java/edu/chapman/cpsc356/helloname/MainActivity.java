package edu.chapman.cpsc356.helloname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView nameTextView;
    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nameTextView = (TextView) findViewById(R.id.tv_name);
        this.nameEditText = (EditText) findViewById(R.id.et_name);
    }

    public void goTapped(View view)
    {
        String name = nameEditText.getText().toString();

        String display = getString(R.string.hello) + " " + name;

        this.nameTextView.setText(display);

        this.nameTextView.setVisibility(View.VISIBLE);
    }
}
