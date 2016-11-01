package com.example.shengxiong.soulmatefinder.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shengxiong.soulmatefinder.BackGroundTask;
import com.example.shengxiong.soulmatefinder.BackGroundTask2;
import com.example.shengxiong.soulmatefinder.R;
import com.example.shengxiong.soulmatefinder.model.EvaluatedTheGarbeldTruthTable;
import com.example.shengxiong.soulmatefinder.model.ParseUserData;
import com.example.shengxiong.soulmatefinder.model.UserData;
import com.example.shengxiong.soulmatefinder.model.Circuit;
import com.example.shengxiong.soulmatefinder.model.GarbledCircuit;
import com.example.shengxiong.soulmatefinder.model.GarbledEval;
import com.example.shengxiong.soulmatefinder.model.GarbledTruthTable;
import com.example.shengxiong.soulmatefinder.model.Gate;
import com.example.shengxiong.soulmatefinder.model.TruthTable;
import com.example.shengxiong.soulmatefinder.model.UserInfo;
import com.example.shengxiong.soulmatefinder.model.UserInfoAdapter;
import com.example.shengxiong.soulmatefinder.model.Wire;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "ResultTactivity";

    private TextView mTextView,mTextView2,mTextView3,mTextView4,mTextView5;
    private Gate mEXORGate1,mEXNORGate2,mEXNORGate3,mEXNORGate4,mEXNORGate5,mAndGate6,mAndGate7,mAndGate8,mAndGate9;
    private Wire mWire1,mWire2,mWire3,mWire4,mWire5,mWire6,mWire7,mWire8,mWire9,mWire10,mWire11,mWire12,
            mWire13,mWire14,mWire15,mWire16,mWire17,mWire18,mWire19;
    private TruthTable mTruthTableEXORGate1, mTruthTableEXNORGate2, mTruthTableEXNORGate3, mTruthTableEXNORGate4,
                        mTruthTableEXNORGate5,mTruthTableAndGate6,mTruthTableAndGate7,mTruthTableAndGate8,
                        mTruthTableAndGate9;
    private GarbledTruthTable mGarbledTruthTable1,mGarbledTruthTable2, mGarbledTruthTable3,mGarbledTruthTable4,
    mGarbledTruthTable5,mGarbledTruthTable6,mGarbledTruthTable7,mGarbledTruthTable8,mGarbledTruthTable9;
    private ArrayList<Gate> mGateArrayList;
    private ArrayList<Wire> mWireArrayList;
    private Circuit mCircuit1;
    private ArrayList<GarbledTruthTable> mGarbledTruthTableArrayList,mGarbledTruthTableArrayList2;
    private GarbledEval mGarbledEval1,mGarbledEval2,mGarbledEval3,mGarbledEval4,mGarbledEval5,
            mGarbledEval6,mGarbledEval7, mGarbledEval8,mGarbledEval9;
    private GarbledCircuit mGarbledCircuit;
    private ArrayList<GarbledEval> mGarbledEvalArrayList;
    private String[] mQuestionChoice;
    private String mData1,mData2,mDataOfGarbledTruthTable;
    String mJsonStringFromServer,mJsonStringFromServer2,user_return;
    private ArrayList<String> mGarbledTruthTableStringArrayList;
    private JSONObject mJsonObject,mJsonObject2;
    private JSONArray mJsonArray,mJsonArray2;
    private UserData mUserData;
    private ParseUserData mParseUserData;
    private EvaluatedTheGarbeldTruthTable mEvaluatedTheGarbeldTruthTable1,mEvaluatedTheGarbeldTruthTable2,mEvaluatedTheGarbeldTruthTable3,
    mEvaluatedTheGarbeldTruthTable4,mEvaluatedTheGarbeldTruthTable5,mEvaluatedTheGarbeldTruthTable6,mEvaluatedTheGarbeldTruthTable7,
            mEvaluatedTheGarbeldTruthTable8 ,mEvaluatedTheGarbeldTruthTable9;
    private String mReturn;
    private UserInfoAdapter mUserInfoAdapter;
    private ListView mListView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mTextView = (TextView)findViewById(R.id.myTextView);
        mTextView2 =  (TextView)findViewById(R.id.resulttextView);
        mTextView3 = (TextView)findViewById(R.id.textViewGarbled);
        mTextView4 = (TextView)findViewById(R.id.textViewPermuted);
        mTextView5 = (TextView) findViewById(R.id.textViewGarbledCircuit);

        mUserInfoAdapter = new UserInfoAdapter(this,R.layout.user_info);
        mListView = (ListView)findViewById(R.id.listView);
        mListView.setAdapter(mUserInfoAdapter);

        Bundle b=this.getIntent().getExtras();
        mQuestionChoice= b.getStringArray("QuestionChoice");

        //Show the answer
        int arraySize = mQuestionChoice.length;
        for(int i = 0; i < arraySize; i++) {
            mTextView.append(mQuestionChoice[i]);
        }

        //BuildingThePrefixCircuit
        // gate 1
        mWire1 = new Wire(1,0,1,0);
        mWire1.randomGenerateTwoKEys();
        mWire2 = new Wire(1,0,1,0);
        mWire2.randomGenerateTwoKEys();
        mWire3 = new Wire(1,0,1,0);
        mWire3.randomGenerateTwoKEys();
        mTruthTableEXORGate1 = new TruthTable(0,1,1,0);
        mEXORGate1 = new Gate(mWire1,mWire2,mWire3, mTruthTableEXORGate1);
        mGarbledTruthTable1 = new GarbledTruthTable(mEXORGate1);

        // gate 2
        mWire4 = new Wire(1,0,1,0);
        mWire4.randomGenerateTwoKEys();
        mWire5 = new Wire(1,0,1,0);
        mWire5.randomGenerateTwoKEys();
        mWire6 = new Wire(1,0,1,0);
        mWire6.randomGenerateTwoKEys();
        mTruthTableEXNORGate2 = new TruthTable(1,0,0,1);
        mEXNORGate2 = new Gate(mWire4,mWire5,mWire6, mTruthTableEXNORGate2);
        mGarbledTruthTable2 = new GarbledTruthTable(mEXNORGate2);

        // gate 3
        mWire7 = new Wire(1,0,1,0);
        mWire7.randomGenerateTwoKEys();
        mWire8 = new Wire(1,0,1,0);
        mWire8.randomGenerateTwoKEys();
        mWire9 = new Wire(1,0,1,0);
        mWire9.randomGenerateTwoKEys();
        mTruthTableEXNORGate3 = new TruthTable(1,0,0,1);
        mEXNORGate3 = new Gate(mWire7,mWire8,mWire9, mTruthTableEXNORGate3);
        mGarbledTruthTable3 = new GarbledTruthTable(mEXNORGate3);

        // gate 4
        mWire10 = new Wire(1,0,1,0);
        mWire10.randomGenerateTwoKEys();
        mWire11 = new Wire(1,0,1,0);
        mWire11.randomGenerateTwoKEys();
        mWire12 = new Wire(1,0,1,0);
        mWire12.randomGenerateTwoKEys();
        mTruthTableEXNORGate4 = new TruthTable(1,0,0,1);
        mEXNORGate4 = new Gate(mWire10,mWire11,mWire12, mTruthTableEXNORGate4);
        mGarbledTruthTable4 = new GarbledTruthTable(mEXNORGate4);

        // gate 5
        mWire13 = new Wire(1,0,1,0);
        mWire13.randomGenerateTwoKEys();
        mWire14 = new Wire(1,0,1,0);
        mWire14.randomGenerateTwoKEys();
        mWire15 = new Wire(1,0,1,0);
        mWire15.randomGenerateTwoKEys();
        mTruthTableEXNORGate5 = new TruthTable(1,0,0,1);
        mEXNORGate5 = new Gate(mWire13,mWire14,mWire15, mTruthTableEXNORGate5);
        mGarbledTruthTable5 = new GarbledTruthTable(mEXNORGate5);

        // gate 6
        mWire16 = new Wire(1,0,1,0);
        mWire16.randomGenerateTwoKEys();
        mTruthTableAndGate6 = new TruthTable(0,0,0,1);
        mAndGate6 = new Gate(mWire3,mWire6,mWire16,mTruthTableAndGate6);
        mGarbledTruthTable6 = new GarbledTruthTable(mAndGate6);

        // gate 7
        mWire17 = new Wire(1,0,1,0);
        mWire17.randomGenerateTwoKEys();
        mTruthTableAndGate7 = new TruthTable(0,0,0,1);
        mAndGate7 = new Gate(mWire9,mWire12,mWire17,mTruthTableAndGate7);
        mGarbledTruthTable7 = new GarbledTruthTable(mAndGate7);

        // gate 8
        mWire18 = new Wire(1,0,1,0);
        mWire18.randomGenerateTwoKEys();
        mTruthTableAndGate8 = new TruthTable(0,0,0,1);
        mAndGate8 = new Gate(mWire16,mWire17,mWire18,mTruthTableAndGate8);
        mGarbledTruthTable8 = new GarbledTruthTable(mAndGate8);

        // gate 9
        mWire19 = new Wire(1,0,1,0);
        mWire19.randomGenerateTwoKEys();
        mTruthTableAndGate9 = new TruthTable(0,0,0,1);
        mAndGate9 = new Gate(mWire18,mWire15,mWire19,mTruthTableAndGate9);
        mGarbledTruthTable9 = new GarbledTruthTable(mAndGate9);

        //set Answer To Each Wire And Generate the Garbled answer
        setAnswerToWire(mQuestionChoice);
        setGarbledAnswertoWire(mQuestionChoice);

        //Send Keys For Alice’s Inputs
        mData1 = Integer.toString(mWire1.getChooseGarbled())+Integer.toString(mWire4.getChooseGarbled())+Integer.toString(mWire7.getChooseGarbled())+
                Integer.toString(mWire10.getChooseGarbled())+Integer.toString(mWire13.getChooseGarbled());

        //Send Keys For Bob's Inpusts
        mData2 = Integer.toString(mWire2.getMinput1())+Integer.toString(mWire2.getMinput2())+
                Integer.toString(mWire5.getMinput1())+Integer.toString(mWire5.getMinput2())+
                Integer.toString(mWire8.getMinput1())+Integer.toString(mWire8.getMinput2())+
                Integer.toString(mWire11.getMinput1())+Integer.toString(mWire11.getMinput2())+
                Integer.toString(mWire14.getMinput1())+Integer.toString(mWire14.getMinput2());

        //send ArraylistOfPermutedGarbledTruthTableToServer
        ArrayList<String> list = new ArrayList<String>();
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable1));
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable2));
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable3));
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable4));
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable5));
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable6));
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable7));
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable8));
        list.add(convertGarbledTruthTableToString(mGarbledTruthTable9));
        JSONArray jsonArray = new JSONArray(list);
        mDataOfGarbledTruthTable = jsonArray.toString();

        //Show the Entire Garbled Circuit And is work!
        mTextView2.setText(""+"mData1 :"+mData1+"other:"+mWire1.getMinput1()+mWire1.getMinput2()+mWire2.getMinput1()+mWire2.getMinput2()+mWire3.getMinput1()+mWire3.getMinput2()+""+
        +mWire4.getMinput1()+mWire4.getMinput2()+mWire5.getMinput1()+mWire5.getMinput2()+mWire6.getMinput1()+mWire6.getMinput2());
        mTextView3.setText("" + "mData2 :"+mData2+"other:"+mGarbledTruthTable1.getGarbledTruthTable()[0][0]+mGarbledTruthTable1.getGarbledTruthTable()[0][1]+
                mGarbledTruthTable1.getGarbledTruthTable()[0][2]+mGarbledTruthTable1.getGarbledTruthTable()[1][0]+
                mGarbledTruthTable1.getGarbledTruthTable()[1][1]+mGarbledTruthTable1.getGarbledTruthTable()[1][2]+
                mGarbledTruthTable1.getGarbledTruthTable()[2][0]+mGarbledTruthTable1.getGarbledTruthTable()[2][1]+
                mGarbledTruthTable1.getGarbledTruthTable()[2][2]+mGarbledTruthTable1.getGarbledTruthTable()[3][0]+
                mGarbledTruthTable1.getGarbledTruthTable()[3][1]+mGarbledTruthTable1.getGarbledTruthTable()[3][2]+" "+
                mGarbledTruthTable2.getGarbledTruthTable()[0][0]+mGarbledTruthTable2.getGarbledTruthTable()[0][1]+
                mGarbledTruthTable2.getGarbledTruthTable()[0][2]+mGarbledTruthTable2.getGarbledTruthTable()[1][0]+
                mGarbledTruthTable2.getGarbledTruthTable()[1][1]+mGarbledTruthTable2.getGarbledTruthTable()[1][2]+
                mGarbledTruthTable2.getGarbledTruthTable()[2][0]+mGarbledTruthTable2.getGarbledTruthTable()[2][1]+
                mGarbledTruthTable2.getGarbledTruthTable()[2][2]+mGarbledTruthTable2.getGarbledTruthTable()[3][0]+
                mGarbledTruthTable2.getGarbledTruthTable()[3][1]+mGarbledTruthTable2.getGarbledTruthTable()[3][2]
        );
       mTextView4.setText(mDataOfGarbledTruthTable);

        //GetDataFromTheServer
//        BackGroundTask2 backGroundTask2 = new BackGroundTask2(this);
//        backGroundTask2.execute("retrieve",getDefaults("username",this));
//        try {
//            mJsonStringFromServer = backGroundTask2.get().toString();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }catch (ExecutionException e) {
//            e.printStackTrace();
//        }
////        mTextView4.setText(mJsonStringFromServer);
//
//        //ConvertJsonData
//        try {
//            mJsonObject = new JSONObject(mJsonStringFromServer);
//            mJsonArray = mJsonObject.getJSONArray("server_response");
//            int count = 0;
//            String user_data,user_question,user_garbled;
//            while(count<mJsonArray.length()){
//                JSONObject JO = mJsonArray.getJSONObject(count);
//                user_data = JO.getString("user_data");
//                user_question = JO.getString("user_question");
//                user_garbled = JO.getString("user_garbled");
//                mUserData = new UserData(user_data,user_question,jsonStringToArray(user_garbled));
//                count++;
//                }
//            } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        //ParsingTheUserData
//       mParseUserData = new ParseUserData(mUserData);

//       mTextView4.setText("user_data: "+ mParseUserData.getUser_data()[0] + mParseUserData.getUser_data()[1]
//                + mParseUserData.getUser_data()[2]+ mParseUserData.getUser_data()[3]+ mParseUserData.getUser_data()[4]
//                + "user_question: "+ mParseUserData.getUser_question()[0][0] +mParseUserData.getUser_question()[0][1]
//                +mParseUserData.getUser_question()[1][0] +mParseUserData.getUser_question()[1][1]
//                +mParseUserData.getUser_question()[2][0] +mParseUserData.getUser_question()[2][1]
//                +mParseUserData.getUser_question()[3][0] +mParseUserData.getUser_question()[3][1]
//                +mParseUserData.getUser_question()[4][0] +mParseUserData.getUser_question()[4][1]
//                + "user_garbled1:" +mParseUserData.getUser_garbled01()[0][0]+mParseUserData.getUser_garbled01()[0][1]+
//               mParseUserData.getUser_garbled01()[0][2]+mParseUserData.getUser_garbled01()[1][0]+mParseUserData.getUser_garbled01()[1][1]+
//               mParseUserData.getUser_garbled01()[1][2]+mParseUserData.getUser_garbled01()[2][0]+mParseUserData.getUser_garbled01()[2][1]+
//               mParseUserData.getUser_garbled01()[2][2]+mParseUserData.getUser_garbled01()[3][0]+mParseUserData.getUser_garbled01()[3][1]+
//               mParseUserData.getUser_garbled01()[3][2]
//               + "user_garbled2:" +mParseUserData.getUser_garbled02()[0][0]+mParseUserData.getUser_garbled02()[0][1]+
//               mParseUserData.getUser_garbled02()[0][2]+mParseUserData.getUser_garbled02()[1][0]+mParseUserData.getUser_garbled02()[1][1]+
//               mParseUserData.getUser_garbled02()[1][2]+mParseUserData.getUser_garbled02()[2][0]+mParseUserData.getUser_garbled02()[2][1]+
//               mParseUserData.getUser_garbled02()[2][2]+mParseUserData.getUser_garbled02()[3][0]+mParseUserData.getUser_garbled02()[3][1]+
//               mParseUserData.getUser_garbled02()[3][2]
//               + "user_garbled3:" +mParseUserData.getUser_garbled03()[0][0]+mParseUserData.getUser_garbled03()[0][1]+
//               mParseUserData.getUser_garbled03()[0][2]+mParseUserData.getUser_garbled03()[1][0]+mParseUserData.getUser_garbled03()[1][1]+
//               mParseUserData.getUser_garbled03()[1][2]+mParseUserData.getUser_garbled03()[2][0]+mParseUserData.getUser_garbled03()[2][1]+
//               mParseUserData.getUser_garbled03()[2][2]+mParseUserData.getUser_garbled03()[3][0]+mParseUserData.getUser_garbled03()[3][1]+
//               mParseUserData.getUser_garbled03()[3][2]
//               + "user_garbled4:" +mParseUserData.getUser_garbled04()[0][0]+mParseUserData.getUser_garbled04()[0][1]+
//               mParseUserData.getUser_garbled04()[0][2]+mParseUserData.getUser_garbled04()[1][0]+mParseUserData.getUser_garbled04()[1][1]+
//               mParseUserData.getUser_garbled04()[1][2]+mParseUserData.getUser_garbled04()[2][0]+mParseUserData.getUser_garbled04()[2][1]+
//               mParseUserData.getUser_garbled04()[2][2]+mParseUserData.getUser_garbled04()[3][0]+mParseUserData.getUser_garbled04()[3][1]+
//               mParseUserData.getUser_garbled04()[3][2]
//               + "user_garbled5:" +mParseUserData.getUser_garbled05()[0][0]+mParseUserData.getUser_garbled05()[0][1]+
//               mParseUserData.getUser_garbled05()[0][2]+mParseUserData.getUser_garbled05()[1][0]+mParseUserData.getUser_garbled05()[1][1]+
//               mParseUserData.getUser_garbled05()[1][2]+mParseUserData.getUser_garbled05()[2][0]+mParseUserData.getUser_garbled05()[2][1]+
//               mParseUserData.getUser_garbled05()[2][2]+mParseUserData.getUser_garbled05()[3][0]+mParseUserData.getUser_garbled05()[3][1]+
//               mParseUserData.getUser_garbled05()[3][2]
//               + "user_garbled6:" +mParseUserData.getUser_garbled06()[0][0]+mParseUserData.getUser_garbled06()[0][1]+
//               mParseUserData.getUser_garbled06()[0][2]+mParseUserData.getUser_garbled06()[1][0]+mParseUserData.getUser_garbled06()[1][1]+
//               mParseUserData.getUser_garbled06()[1][2]+mParseUserData.getUser_garbled06()[2][0]+mParseUserData.getUser_garbled06()[2][1]+
//               mParseUserData.getUser_garbled06()[2][2]+mParseUserData.getUser_garbled06()[3][0]+mParseUserData.getUser_garbled06()[3][1]+
//               mParseUserData.getUser_garbled06()[3][2]
//               + "user_garbled7:" +mParseUserData.getUser_garbled07()[0][0]+mParseUserData.getUser_garbled07()[0][1]+
//               mParseUserData.getUser_garbled07()[0][2]+mParseUserData.getUser_garbled07()[1][0]+mParseUserData.getUser_garbled07()[1][1]+
//               mParseUserData.getUser_garbled07()[1][2]+mParseUserData.getUser_garbled07()[2][0]+mParseUserData.getUser_garbled07()[2][1]+
//               mParseUserData.getUser_garbled07()[2][2]+mParseUserData.getUser_garbled07()[3][0]+mParseUserData.getUser_garbled07()[3][1]+
//               mParseUserData.getUser_garbled07()[3][2]
//               + "user_garbled8:" +mParseUserData.getUser_garbled08()[0][0]+mParseUserData.getUser_garbled08()[0][1]+
//               mParseUserData.getUser_garbled08()[0][2]+mParseUserData.getUser_garbled08()[1][0]+mParseUserData.getUser_garbled08()[1][1]+
//               mParseUserData.getUser_garbled08()[1][2]+mParseUserData.getUser_garbled08()[2][0]+mParseUserData.getUser_garbled08()[2][1]+
//               mParseUserData.getUser_garbled08()[2][2]+mParseUserData.getUser_garbled08()[3][0]+mParseUserData.getUser_garbled08()[3][1]+
//               mParseUserData.getUser_garbled08()[3][2]
//               + "user_garbled9:" +mParseUserData.getUser_garbled09()[0][0]+mParseUserData.getUser_garbled09()[0][1]+
//               mParseUserData.getUser_garbled09()[0][2]+mParseUserData.getUser_garbled09()[1][0]+mParseUserData.getUser_garbled09()[1][1]+
//               mParseUserData.getUser_garbled09()[1][2]+mParseUserData.getUser_garbled09()[2][0]+mParseUserData.getUser_garbled09()[2][1]+
//               mParseUserData.getUser_garbled09()[2][2]+mParseUserData.getUser_garbled09()[3][0]+mParseUserData.getUser_garbled09()[3][1]+
//               mParseUserData.getUser_garbled09()[3][2]
//       );

//        //EvaluateTheGarbledTruthTable
//        //setAnswerAccordingToGarbledTruthTable
//        int[] ints = new int[5];
//        ints = setAnswerToGarbledTruthTable(mQuestionChoice,mParseUserData.getUser_question());
////        mTextView4.setText(""+ints[0]+ints[1]+ints[2]+ints[3]+ints[4]);
//
//        //EvaluateEachGarbled
//        mEvaluatedTheGarbeldTruthTable1 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled01(),mParseUserData.getUser_data()[0],ints[0]);
//        mEvaluatedTheGarbeldTruthTable2 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled02(),mParseUserData.getUser_data()[1],ints[1]);
//        mEvaluatedTheGarbeldTruthTable3 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled03(),mParseUserData.getUser_data()[2],ints[2]);
//        mEvaluatedTheGarbeldTruthTable4 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled04(),mParseUserData.getUser_data()[3],ints[3]);
//        mEvaluatedTheGarbeldTruthTable5 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled05(),mParseUserData.getUser_data()[4],ints[4]);
//        mEvaluatedTheGarbeldTruthTable6 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled06(),mEvaluatedTheGarbeldTruthTable1.Eval(),mEvaluatedTheGarbeldTruthTable2.Eval());
//        mEvaluatedTheGarbeldTruthTable7 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled07(),mEvaluatedTheGarbeldTruthTable3.Eval(),mEvaluatedTheGarbeldTruthTable4.Eval());
//        mEvaluatedTheGarbeldTruthTable8 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled08(),mEvaluatedTheGarbeldTruthTable6.Eval(),mEvaluatedTheGarbeldTruthTable7.Eval());
//        mEvaluatedTheGarbeldTruthTable9 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled09(),mEvaluatedTheGarbeldTruthTable8.Eval(),mEvaluatedTheGarbeldTruthTable5.Eval());
//        mReturn = ""+ mEvaluatedTheGarbeldTruthTable9.Eval();
////        mTextView4.setText(mReturn + ":"+mEvaluatedTheGarbeldTruthTable9.Eval());
////        mTextView4.setText("1: "+mParseUserData.getUser_data()[0]+ints[0]+mEvaluatedTheGarbeldTruthTable1.Eval()+" "+
////                "2: "+mParseUserData.getUser_data()[1]+ints[1]+mEvaluatedTheGarbeldTruthTable2.Eval()+" "+
////                "3: "+mParseUserData.getUser_data()[2]+ints[2]+mEvaluatedTheGarbeldTruthTable3.Eval()+" "+
////                "4: "+mParseUserData.getUser_data()[3]+ints[3]+mEvaluatedTheGarbeldTruthTable4.Eval()+" "+
////                "5: "+mParseUserData.getUser_data()[4]+ints[4]+mEvaluatedTheGarbeldTruthTable5.Eval()+" "+
////                "6: "+mEvaluatedTheGarbeldTruthTable1.Eval()+mEvaluatedTheGarbeldTruthTable2.Eval()+mEvaluatedTheGarbeldTruthTable6.Eval()+" "+
////                "7: "+mEvaluatedTheGarbeldTruthTable3.Eval()+mEvaluatedTheGarbeldTruthTable4.Eval()+mEvaluatedTheGarbeldTruthTable7.Eval()+" "+
////                "8: "+mEvaluatedTheGarbeldTruthTable6.Eval()+mEvaluatedTheGarbeldTruthTable7.Eval()+mEvaluatedTheGarbeldTruthTable8.Eval()+" "+
////                "9: "+mEvaluatedTheGarbeldTruthTable8.Eval()+mEvaluatedTheGarbeldTruthTable5.Eval()+mEvaluatedTheGarbeldTruthTable9.Eval()+" "
////        );

        //uploadResultsFromevaluation(USE THE BUTTON RETURN)

        //Retrieve the results from the server
//        BackGroundTask2 backGroundTask2_2 = new BackGroundTask2(this);
//        backGroundTask2_2.execute("returnretrieve",getDefaults("username",this));
//        try {
//            mJsonStringFromServer2 = backGroundTask2_2.get().toString();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }catch (ExecutionException e) {
//            e.printStackTrace();
//        }
////        mTextView4.setTexonStringFromServer2);
//        //ConvertJsonData
//        try {
//            mJsonObject2 = new JSONObject(mJsonStringFromServer2);
//            mJsonArray2 = mJsonObject2.getJSONArray("server_response");
//            int count = 0;
//            while(count<mJsonArray2.length()){
//                JSONObject JO = mJsonArray2.getJSONObject(count);
//                user_return = JO.getString("user_return");
//
//            count++;
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        mTextView3.setText(user_return);

        // circuit 1
        mGateArrayList = new ArrayList<Gate>();
        mGateArrayList.add(mEXORGate1);
        mGateArrayList.add(mEXNORGate2);
        mGateArrayList.add(mEXNORGate3);
        mGateArrayList.add(mEXNORGate4);
        mGateArrayList.add(mEXNORGate5);
        mGateArrayList.add(mAndGate6);
        mGateArrayList.add(mAndGate7);
        mGateArrayList.add(mAndGate8);
        mGateArrayList.add(mAndGate9);

        mWireArrayList = new ArrayList<Wire>();
        mWireArrayList.add(mWire1);
        mWireArrayList.add(mWire2);
        mWireArrayList.add(mWire3);
        mWireArrayList.add(mWire4);
        mWireArrayList.add(mWire5);
        mWireArrayList.add(mWire6);
        mWireArrayList.add(mWire7);
        mWireArrayList.add(mWire8);
        mWireArrayList.add(mWire9);
        mWireArrayList.add(mWire10);
        mWireArrayList.add(mWire11);
        mWireArrayList.add(mWire12);
        mWireArrayList.add(mWire13);
        mWireArrayList.add(mWire14);
        mWireArrayList.add(mWire15);
        mWireArrayList.add(mWire16);
        mWireArrayList.add(mWire17);
        mWireArrayList.add(mWire18);

        mCircuit1 = new Circuit(mGateArrayList,mWireArrayList,mWire19);

        //GarbleCircuit
        mGarbledEval1 = new GarbledEval(mGarbledTruthTable1,mWire1.getChooseGarbled(),mWire2.getChooseGarbled());
        mGarbledEval1.eval();
        mGarbledEval2 = new GarbledEval(mGarbledTruthTable2,mWire4.getChooseGarbled(),mWire5.getChooseGarbled());
        mGarbledEval2.eval();
        mGarbledEval3 = new GarbledEval(mGarbledTruthTable3,mWire7.getChooseGarbled(),mWire8.getChooseGarbled());
        mGarbledEval3.eval();
        mGarbledEval4 = new GarbledEval(mGarbledTruthTable4,mWire10.getChooseGarbled(),mWire11.getChooseGarbled());
        mGarbledEval4.eval();
        mGarbledEval5 = new GarbledEval(mGarbledTruthTable5,mWire13.getChooseGarbled(),mWire14.getChooseGarbled());
        mGarbledEval5.eval();
        mGarbledEval6 = new GarbledEval(mGarbledTruthTable6,mGarbledEval1.getOutput1(),mGarbledEval2.getOutput1());
        mGarbledEval6.eval();
        mGarbledEval7 = new GarbledEval(mGarbledTruthTable7,mGarbledEval3.getOutput1(),mGarbledEval4.getOutput1());
        mGarbledEval7.eval();
        mGarbledEval8 = new GarbledEval(mGarbledTruthTable8,mGarbledEval6.getOutput1(),mGarbledEval7.getOutput1());
        mGarbledEval8.eval();
        mGarbledEval9 = new GarbledEval(mGarbledTruthTable9,mGarbledEval8.getOutput1(),mGarbledEval5.getOutput1());
        mGarbledEval9.eval();
    }

    public void userUpload(View view){
        String name = getDefaults("username",this) ;
        String data1 = mData1;
        String data2 = mData2;
        String data3 = mDataOfGarbledTruthTable;
        String method = "upload";
        BackGroundTask backGroundTask = new BackGroundTask(this);
        backGroundTask.execute(method,name,data1,data2,data3);
    }

    public void userRetrieve(View view){
        //GetDataFromTheServer
        BackGroundTask2 backGroundTask2 = new BackGroundTask2(this);
        backGroundTask2.execute("retrieve",getDefaults("username",this));
        try {
            mJsonStringFromServer = backGroundTask2.get().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
        mTextView.setText(mJsonStringFromServer);

        //ConvertJsonData
        try {
            mJsonObject = new JSONObject(mJsonStringFromServer);
            mJsonArray = mJsonObject.getJSONArray("server_response");
            int count = 0;
            String user_data,user_question,user_garbled;
            while(count<mJsonArray.length()){
                JSONObject JO = mJsonArray.getJSONObject(count);
                user_data = JO.getString("user_data");
                user_question = JO.getString("user_question");
                user_garbled = JO.getString("user_garbled");
                mUserData = new UserData(user_data,user_question,jsonStringToArray(user_garbled));
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //ParsingTheUserData
        mParseUserData = new ParseUserData(mUserData);
        mTextView2.setText("user_data: "+ mParseUserData.getUser_data()[0] + mParseUserData.getUser_data()[1]
                + mParseUserData.getUser_data()[2]+ mParseUserData.getUser_data()[3]+ mParseUserData.getUser_data()[4]
                + "user_question: "+ mParseUserData.getUser_question()[0][0] +mParseUserData.getUser_question()[0][1]
                +mParseUserData.getUser_question()[1][0] +mParseUserData.getUser_question()[1][1]
                +mParseUserData.getUser_question()[2][0] +mParseUserData.getUser_question()[2][1]
                +mParseUserData.getUser_question()[3][0] +mParseUserData.getUser_question()[3][1]
                +mParseUserData.getUser_question()[4][0] +mParseUserData.getUser_question()[4][1]
                + "user_garbled1:" +mParseUserData.getUser_garbled01()[0][0]+mParseUserData.getUser_garbled01()[0][1]+
               mParseUserData.getUser_garbled01()[0][2]+mParseUserData.getUser_garbled01()[1][0]+mParseUserData.getUser_garbled01()[1][1]+
               mParseUserData.getUser_garbled01()[1][2]+mParseUserData.getUser_garbled01()[2][0]+mParseUserData.getUser_garbled01()[2][1]+
               mParseUserData.getUser_garbled01()[2][2]+mParseUserData.getUser_garbled01()[3][0]+mParseUserData.getUser_garbled01()[3][1]+
               mParseUserData.getUser_garbled01()[3][2]
               + "user_garbled2:" +mParseUserData.getUser_garbled02()[0][0]+mParseUserData.getUser_garbled02()[0][1]+
               mParseUserData.getUser_garbled02()[0][2]+mParseUserData.getUser_garbled02()[1][0]+mParseUserData.getUser_garbled02()[1][1]+
               mParseUserData.getUser_garbled02()[1][2]+mParseUserData.getUser_garbled02()[2][0]+mParseUserData.getUser_garbled02()[2][1]+
               mParseUserData.getUser_garbled02()[2][2]+mParseUserData.getUser_garbled02()[3][0]+mParseUserData.getUser_garbled02()[3][1]+
               mParseUserData.getUser_garbled02()[3][2]
               + "user_garbled3:" +mParseUserData.getUser_garbled03()[0][0]+mParseUserData.getUser_garbled03()[0][1]+
               mParseUserData.getUser_garbled03()[0][2]+mParseUserData.getUser_garbled03()[1][0]+mParseUserData.getUser_garbled03()[1][1]+
               mParseUserData.getUser_garbled03()[1][2]+mParseUserData.getUser_garbled03()[2][0]+mParseUserData.getUser_garbled03()[2][1]+
               mParseUserData.getUser_garbled03()[2][2]+mParseUserData.getUser_garbled03()[3][0]+mParseUserData.getUser_garbled03()[3][1]+
               mParseUserData.getUser_garbled03()[3][2]
               + "user_garbled4:" +mParseUserData.getUser_garbled04()[0][0]+mParseUserData.getUser_garbled04()[0][1]+
               mParseUserData.getUser_garbled04()[0][2]+mParseUserData.getUser_garbled04()[1][0]+mParseUserData.getUser_garbled04()[1][1]+
               mParseUserData.getUser_garbled04()[1][2]+mParseUserData.getUser_garbled04()[2][0]+mParseUserData.getUser_garbled04()[2][1]+
               mParseUserData.getUser_garbled04()[2][2]+mParseUserData.getUser_garbled04()[3][0]+mParseUserData.getUser_garbled04()[3][1]+
               mParseUserData.getUser_garbled04()[3][2]
               + "user_garbled5:" +mParseUserData.getUser_garbled05()[0][0]+mParseUserData.getUser_garbled05()[0][1]+
               mParseUserData.getUser_garbled05()[0][2]+mParseUserData.getUser_garbled05()[1][0]+mParseUserData.getUser_garbled05()[1][1]+
               mParseUserData.getUser_garbled05()[1][2]+mParseUserData.getUser_garbled05()[2][0]+mParseUserData.getUser_garbled05()[2][1]+
               mParseUserData.getUser_garbled05()[2][2]+mParseUserData.getUser_garbled05()[3][0]+mParseUserData.getUser_garbled05()[3][1]+
               mParseUserData.getUser_garbled05()[3][2]
               + "user_garbled6:" +mParseUserData.getUser_garbled06()[0][0]+mParseUserData.getUser_garbled06()[0][1]+
               mParseUserData.getUser_garbled06()[0][2]+mParseUserData.getUser_garbled06()[1][0]+mParseUserData.getUser_garbled06()[1][1]+
               mParseUserData.getUser_garbled06()[1][2]+mParseUserData.getUser_garbled06()[2][0]+mParseUserData.getUser_garbled06()[2][1]+
               mParseUserData.getUser_garbled06()[2][2]+mParseUserData.getUser_garbled06()[3][0]+mParseUserData.getUser_garbled06()[3][1]+
               mParseUserData.getUser_garbled06()[3][2]
               + "user_garbled7:" +mParseUserData.getUser_garbled07()[0][0]+mParseUserData.getUser_garbled07()[0][1]+
               mParseUserData.getUser_garbled07()[0][2]+mParseUserData.getUser_garbled07()[1][0]+mParseUserData.getUser_garbled07()[1][1]+
               mParseUserData.getUser_garbled07()[1][2]+mParseUserData.getUser_garbled07()[2][0]+mParseUserData.getUser_garbled07()[2][1]+
               mParseUserData.getUser_garbled07()[2][2]+mParseUserData.getUser_garbled07()[3][0]+mParseUserData.getUser_garbled07()[3][1]+
               mParseUserData.getUser_garbled07()[3][2]
               + "user_garbled8:" +mParseUserData.getUser_garbled08()[0][0]+mParseUserData.getUser_garbled08()[0][1]+
               mParseUserData.getUser_garbled08()[0][2]+mParseUserData.getUser_garbled08()[1][0]+mParseUserData.getUser_garbled08()[1][1]+
               mParseUserData.getUser_garbled08()[1][2]+mParseUserData.getUser_garbled08()[2][0]+mParseUserData.getUser_garbled08()[2][1]+
               mParseUserData.getUser_garbled08()[2][2]+mParseUserData.getUser_garbled08()[3][0]+mParseUserData.getUser_garbled08()[3][1]+
               mParseUserData.getUser_garbled08()[3][2]
               + "user_garbled9:" +mParseUserData.getUser_garbled09()[0][0]+mParseUserData.getUser_garbled09()[0][1]+
               mParseUserData.getUser_garbled09()[0][2]+mParseUserData.getUser_garbled09()[1][0]+mParseUserData.getUser_garbled09()[1][1]+
               mParseUserData.getUser_garbled09()[1][2]+mParseUserData.getUser_garbled09()[2][0]+mParseUserData.getUser_garbled09()[2][1]+
               mParseUserData.getUser_garbled09()[2][2]+mParseUserData.getUser_garbled09()[3][0]+mParseUserData.getUser_garbled09()[3][1]+
               mParseUserData.getUser_garbled09()[3][2]
       );
        //EvaluateTheGarbledTruthTable
        //setAnswerAccordingToGarbledTruthTable
        int[] ints = new int[5];
        ints = setAnswerToGarbledTruthTable(mQuestionChoice,mParseUserData.getUser_question());
//        mTextView4.setText(""+ints[0]+ints[1]+ints[2]+ints[3]+ints[4]);

        //EvaluateEachGarbled
        mEvaluatedTheGarbeldTruthTable1 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled01(),mParseUserData.getUser_data()[0],ints[0]);
        mEvaluatedTheGarbeldTruthTable2 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled02(),mParseUserData.getUser_data()[1],ints[1]);
        mEvaluatedTheGarbeldTruthTable3 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled03(),mParseUserData.getUser_data()[2],ints[2]);
        mEvaluatedTheGarbeldTruthTable4 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled04(),mParseUserData.getUser_data()[3],ints[3]);
        mEvaluatedTheGarbeldTruthTable5 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled05(),mParseUserData.getUser_data()[4],ints[4]);
        mEvaluatedTheGarbeldTruthTable6 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled06(),mEvaluatedTheGarbeldTruthTable1.Eval(),mEvaluatedTheGarbeldTruthTable2.Eval());
        mEvaluatedTheGarbeldTruthTable7 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled07(),mEvaluatedTheGarbeldTruthTable3.Eval(),mEvaluatedTheGarbeldTruthTable4.Eval());
        mEvaluatedTheGarbeldTruthTable8 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled08(),mEvaluatedTheGarbeldTruthTable6.Eval(),mEvaluatedTheGarbeldTruthTable7.Eval());
        mEvaluatedTheGarbeldTruthTable9 = new EvaluatedTheGarbeldTruthTable(mParseUserData.getUser_garbled09(),mEvaluatedTheGarbeldTruthTable8.Eval(),mEvaluatedTheGarbeldTruthTable5.Eval());
        mReturn = ""+ mEvaluatedTheGarbeldTruthTable9.Eval();
        mTextView3.setText(mReturn + ":"+mEvaluatedTheGarbeldTruthTable9.Eval());
        mTextView4.setText("1: "+mParseUserData.getUser_data()[0]+ints[0]+mEvaluatedTheGarbeldTruthTable1.Eval()+" "+
                "2: "+mParseUserData.getUser_data()[1]+ints[1]+mEvaluatedTheGarbeldTruthTable2.Eval()+" "+
                "3: "+mParseUserData.getUser_data()[2]+ints[2]+mEvaluatedTheGarbeldTruthTable3.Eval()+" "+
                "4: "+mParseUserData.getUser_data()[3]+ints[3]+mEvaluatedTheGarbeldTruthTable4.Eval()+" "+
                "5: "+mParseUserData.getUser_data()[4]+ints[4]+mEvaluatedTheGarbeldTruthTable5.Eval()+" "+
                "6: "+mEvaluatedTheGarbeldTruthTable1.Eval()+mEvaluatedTheGarbeldTruthTable2.Eval()+mEvaluatedTheGarbeldTruthTable6.Eval()+" "+
                "7: "+mEvaluatedTheGarbeldTruthTable3.Eval()+mEvaluatedTheGarbeldTruthTable4.Eval()+mEvaluatedTheGarbeldTruthTable7.Eval()+" "+
                "8: "+mEvaluatedTheGarbeldTruthTable6.Eval()+mEvaluatedTheGarbeldTruthTable7.Eval()+mEvaluatedTheGarbeldTruthTable8.Eval()+" "+
                "9: "+mEvaluatedTheGarbeldTruthTable8.Eval()+mEvaluatedTheGarbeldTruthTable5.Eval()+mEvaluatedTheGarbeldTruthTable9.Eval()+" "
        );

        //upload Evaluated results to server
        String name = getDefaults("username",this) ;
        String user_return = mReturn ;
        String method = "return";
        BackGroundTask backGroundTask = new BackGroundTask(this);
        backGroundTask.execute(method,name,user_return);
    }

    public void userReturn(View view){
        String name = getDefaults("username",this) ;
        String user_return = mReturn ;
        String method = "return";
        BackGroundTask backGroundTask = new BackGroundTask(this);
        backGroundTask.execute(method,name,user_return);
    }

    public void userRetrieveReturn(View view){
        //Retrieve the results from the server
        BackGroundTask2 backGroundTask2_2 = new BackGroundTask2(this);
        backGroundTask2_2.execute("returnretrieve",getDefaults("username",this));
        try {
            mJsonStringFromServer2 = backGroundTask2_2.get().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
                mTextView.setText(mJsonStringFromServer2);
        //ConvertJsonData
        try {
            mJsonObject2 = new JSONObject(mJsonStringFromServer2);
            mJsonArray2 = mJsonObject2.getJSONArray("server_response");
            int count = 0;
            while(count<mJsonArray2.length()){
                JSONObject JO = mJsonArray2.getJSONObject(count);
                user_return = JO.getString("user_return");
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mTextView2.setText(user_return);
        mTextView3.setText(""+mWire19.getMinput2());
        //Show the Result
        if (Integer.parseInt(user_return) == mWire19.getMinput2()){
            mTextView4.setText("MATCH");
            userRetrieveEmail();
        } else {
            mTextView4.setText("NOT MATCH");
        }
    }

    private void userRetrieveEmail(){
        //Retrieve the user email from the server
        String user_name = null;
        String user_email = null;
        BackGroundTask2 backGroundTask2_2 = new BackGroundTask2(this);
        backGroundTask2_2.execute("emailretrieve",getDefaults("username",this));
        try {
            mJsonStringFromServer2 = backGroundTask2_2.get().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
        mTextView.setText(mJsonStringFromServer2);
        //ConvertJsonData
        try {
            mJsonObject2 = new JSONObject(mJsonStringFromServer2);
            mJsonArray2 = mJsonObject2.getJSONArray("server_response");
            int count = 0;
            while(count<mJsonArray2.length()){
                JSONObject JO = mJsonArray2.getJSONObject(count);
                user_name = JO.getString("user_name");
                user_email = JO.getString("user_email");
                UserInfo userInfo = new UserInfo(user_name,user_email);
                mUserInfoAdapter.add(userInfo);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"user name and user email",Toast.LENGTH_LONG).show();

    }

    private int[] setAnswerToGarbledTruthTable(String[] strings, int[][] ints){
        String[] mStrings = strings;
        int[][] mInts = ints;
        int[] mInt = new int[5];
        int answer1 = Integer.parseInt(mStrings[0]);
        int answer2 = Integer.parseInt(mStrings[1]);
        int answer3 = Integer.parseInt(mStrings[2]);
        int answer4 = Integer.parseInt(mStrings[3]);
        int answer5 = Integer.parseInt(mStrings[4]);
        if(answer1 == 0){
            mInt[0] = ints[0][0];
        }else{
            mInt[0] = ints[0][1];
        }
        if(answer2 == 0){
            mInt[1] = ints[1][0];
        }else{
            mInt[1] = ints[1][1];
        }
        if(answer3 == 0){
            mInt[2] = ints[2][0];
        }else{
            mInt[2] = ints[2][1];
        }
        if(answer4 == 0){
            mInt[3] = ints[3][0];
        }else{
            mInt[3] = ints[3][1];
        }
        if(answer5 == 0){
            mInt[4] = ints[4][0];
        }else{
            mInt[4] = ints[4][1];
        }
        return  mInt;
    }

    private ArrayList<String> jsonStringToArray(String jsonString) throws JSONException {

        ArrayList<String> stringArray = new ArrayList<String>();

        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
            stringArray.add(jsonArray.getString(i));
        }

        return stringArray;
    }

    public String convertGarbledTruthTableToString(GarbledTruthTable garbledTruthTable){
        String string;
        garbledTruthTable.permuted();
        string = ""+garbledTruthTable.getGarbledTruthTable()[0][0]+garbledTruthTable.getGarbledTruthTable()[0][1]+
                garbledTruthTable.getGarbledTruthTable()[0][2]+garbledTruthTable.getGarbledTruthTable()[1][0]+
                garbledTruthTable.getGarbledTruthTable()[1][1]+garbledTruthTable.getGarbledTruthTable()[1][2]+
                garbledTruthTable.getGarbledTruthTable()[2][0]+garbledTruthTable.getGarbledTruthTable()[2][1]+
                garbledTruthTable.getGarbledTruthTable()[2][2]+garbledTruthTable.getGarbledTruthTable()[3][0]+
                garbledTruthTable.getGarbledTruthTable()[3][1]+garbledTruthTable.getGarbledTruthTable()[3][2];
        return string;
    }

    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    private void setAnswerToWire(String[] strings){
        String[] mString = strings;
        int answer1 = Integer.parseInt(mString[0]);
        int answer2 = Integer.parseInt(mString[1]);
        int answer3 = Integer.parseInt(mString[2]);
        int answer4 = Integer.parseInt(mString[3]);
        int answer5 = Integer.parseInt(mString[4]);

        mWire1.setChoose(answer1);
        mWire4.setChoose(answer2);
        mWire7.setChoose(answer3);
        mWire10.setChoose(answer4);
        mWire13.setChoose(answer5);
    }

    private void setGarbledAnswertoWire(String[] strings){
        String[] mStrings = strings;
        int answer1 = Integer.parseInt(mStrings[0]);
        int answer2 = Integer.parseInt(mStrings[1]);
        int answer3 = Integer.parseInt(mStrings[2]);
        int answer4 = Integer.parseInt(mStrings[3]);
        int answer5 = Integer.parseInt(mStrings[4]);
        if(answer1 == 0){
            mWire1.setChooseGarbled(mWire1.getMinput1());
        }else {
            mWire1.setChooseGarbled(mWire1.getMinput2());
        }
        if(answer2 == 0){
            mWire4.setChooseGarbled(mWire4.getMinput1());
        }else {
            mWire4.setChooseGarbled(mWire4.getMinput2());
        }
        if(answer3 == 0){
            mWire7.setChooseGarbled(mWire7.getMinput1());
        }else {
            mWire7.setChooseGarbled(mWire7.getMinput2());
        }
        if(answer4 == 0){
            mWire10.setChooseGarbled(mWire10.getMinput1());
        }else {
            mWire10.setChooseGarbled(mWire10.getMinput2());
        }
        if(answer5 == 0){
            mWire13.setChooseGarbled(mWire13.getMinput1());
        }else {
            mWire13.setChooseGarbled(mWire13.getMinput2());
        }
    }
}

