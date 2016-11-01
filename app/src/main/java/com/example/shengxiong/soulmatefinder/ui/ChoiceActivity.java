package com.example.shengxiong.soulmatefinder.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shengxiong.soulmatefinder.R;
import com.example.shengxiong.soulmatefinder.model.Page;
import com.example.shengxiong.soulmatefinder.model.Question;



public class ChoiceActivity extends AppCompatActivity {



    public static final String TAG = ChoiceActivity.class.getSimpleName();

    private Question mQuestion = new Question();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;
    public String[] mQuestionChoice = new String[]{"2","2","2","2","2"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);


        mChoice1=(Button)findViewById(R.id.Choicebutton1);
        mChoice2=(Button)findViewById(R.id.Choicebutton2);
        mImageView =(ImageView)findViewById(R.id.imageView4);
        mTextView=(TextView)findViewById(R.id.textView2);
        LoadPage(0);
    }

    private void LoadPage(int choice){
        mCurrentPage = mQuestion.getPage(choice);
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);
        String pageText =mCurrentPage.getText();
        pageText=String.format(pageText,mName);
        mTextView.setText(pageText);

        if(mCurrentPage.isFinal()){
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("SHOW RESULT");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  showRsult();
                }
            });
        }else{
        mChoice1.setText(mCurrentPage.getChoice1().getText());
        mChoice2.setText(mCurrentPage.getChoice2().getText());

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextpage = mCurrentPage.getChoice1().getNextPage();
                int currentpage =mCurrentPage.getChoice1().getCurrentPage();
                mQuestionChoice[currentpage]= "0";
                LoadPage(nextpage);
            }
        });
        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextpage = mCurrentPage.getChoice2().getNextPage();
                int currentpage =mCurrentPage.getChoice2().getCurrentPage();
                mQuestionChoice[currentpage]= "1";
                LoadPage(nextpage);
            }
        });}
    }

    private void showRsult(){
        Intent intent = new Intent(this,ResultActivity.class);
        Bundle b=new Bundle();
        b.putStringArray(getString(R.string.Question_Choice) ,mQuestionChoice);
        intent.putExtras(b);
        startActivity(intent);
    }
}
