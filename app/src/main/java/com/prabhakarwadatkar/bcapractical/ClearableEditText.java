package com.prabhakarwadatkar.bcapractical;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ClearableEditText extends LinearLayout {
    private EditText editText;
    private Button clearButton;

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        editText = new EditText(context);
        editText.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
        editText.setHint("Enter text");

        clearButton = new Button(context);
        clearButton.setText("Clear");
        clearButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        addView(editText);
        addView(clearButton);

        clearButton.setOnClickListener(v -> editText.setText(""));
    }

    public String getText() {
        return editText.getText().toString();
    }

    public void setText(String text) {
        editText.setText(text);
    }
}