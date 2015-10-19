package com.casasmap.yamba;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClientException;

public class StatusFragment extends Fragment {
    private static final String TAG = "Status Fragment";
    private Button buttonTweet;
    private EditText editStatus;
    //about character counter
    private TextView textCount;
    private int defaultTextColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //setContentView(R.layout.fragment_status);
        View view = inflater.inflate(R.layout.fragment_status,
                container, false);
        //Starting to work
        buttonTweet = (Button) view.findViewById(R.id.b_tweet);
        editStatus = (EditText) view.findViewById(R.id.et_tweet_message);
        //about counter
        textCount = (TextView) view.findViewById(R.id.textCount);
        //abotu text color
        defaultTextColor = textCount.getTextColors().getDefaultColor();

        editStatus.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int count = 140 - editStatus.length();
                textCount.setText(Integer.toString(count));
                textCount.setTextColor(Color.GREEN);
                if(count < 10) textCount.setTextColor(Color.RED);
                else textCount.setTextColor(defaultTextColor);
            }
        });


        buttonTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = editStatus.getText().toString();
                Log.d(TAG, "onClicked with status: " + status);
                Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
                new PostTask().execute(status);
            }
        });
        return view;
    }
    private final class PostTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            YambaClient yambaCloud = new YambaClient("student", "password");
            try{
                yambaCloud.postStatus(params[0]);
                return "Successfully psted";
            }catch (YambaClientException e){
                e.printStackTrace();
                return "Failed to post to yamba service";
            }
        }
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            Toast.makeText(getActivity(), result,
                    Toast.LENGTH_SHORT).show();
        }
    }


}
