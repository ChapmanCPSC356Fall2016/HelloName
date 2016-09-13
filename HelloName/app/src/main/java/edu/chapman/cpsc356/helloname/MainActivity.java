package edu.chapman.cpsc356.helloname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView nameTextView;
    EditText nameEditText;

    Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nameTextView = (TextView) findViewById(R.id.tv_name);
        this.nameEditText = (EditText) findViewById(R.id.et_name);
        this.nameEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                Log.i("TEST", "beforeTextChanged");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                Log.i("TEST", "onTextChange");
                updateDisplay();
            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                Log.i("TEST", "afterTextChanged");
            }
        });

        this.goButton = (Button) findViewById(R.id.btn_go);
        this.goButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i("TEST", "Button was pressed");
                updateDisplay();
            }
        });

        Log.i("TEST", "onCreate Finished here");
    }

    public void updateDisplay()
    {
        String name = nameEditText.getText().toString();

        String display = getString(R.string.hello) + " " + name;

        this.nameTextView.setText(display);

        int vis = name.isEmpty() ? View.GONE : View.VISIBLE;
        this.nameTextView.setVisibility(vis);
    }
}
