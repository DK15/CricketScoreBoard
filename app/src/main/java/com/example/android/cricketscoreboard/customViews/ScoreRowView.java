package com.example.android.cricketscoreboard.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.cricketscoreboard.R;

public class ScoreRowView extends LinearLayout {

    private TextView primaryTextView;

    private TextView secondaryTextView;

    public ScoreRowView(Context context) {
        super(context);

        init(context, null);
    }

    public ScoreRowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public ScoreRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // inflate the layout xml file
        inflate(context, R.layout.score_row_view_layout, this);

        if (attrs != null) {
            TypedArray attributeArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ScoreRowView, 0, 0);

            String primaryText;
            String secondaryText;

            try {
                primaryText = attributeArray.getString(R.styleable.ScoreRowView_primaryText);
                secondaryText = attributeArray.getString(R.styleable.ScoreRowView_secondayText);
            } finally {
                attributeArray.recycle();
            }

            primaryTextView = (TextView) findViewById(R.id.primary_text);
            if (!TextUtils.isEmpty(primaryText)) {
                primaryTextView.setText(primaryText);
            }

            secondaryTextView = (TextView) findViewById(R.id.secondary_text);
            if (!TextUtils.isEmpty(secondaryText)) {
                secondaryTextView.setText(secondaryText);
            }


        }

    }

    public void setPrimaryText(String text) {
        primaryTextView.setText(text);
    }

    public void setSecondaryTextView(String text) {
        secondaryTextView.setText(text);
    }

    public String getPrimaryText() {
        return primaryTextView.getText().toString();
    }

    public String getSecondaryText() {
        return secondaryTextView.getText().toString();
    }
}
