package com.rig.rigsays;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addQuestions();
//db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("Can you tell me which of these animals make this sound?"
                ,"Turkey", "Cow", "Dolphin", "Turkey");
        this.addQuestion(q1);
        Question q2=new Question("Which of these facts is true about frogs? "
                , "They lick themselves to keep clean", "Frogs usually hunt alone at night"
                , "Frogs lay their eggs in water", "Frogs lay their eggs in water");
        this.addQuestion(q2);
        Question q3=new Question("Can you tell me which one is true about eagles?"
                ,"Eagles can smell water up to 3 miles away", "Bald eagle aren’t actually bald"
                ,"Most eagles have tails","Bald eagle aren’t actually bald");
        this.addQuestion(q3);
        Question q4=new Question("Can you tell me which of these animals make this sound?"
                , "Monkey", "Tiger", "Cat","Cat");
        this.addQuestion(q4);
        Question q5=new Question("Which one is true about dogs?"
                ,"They use a blowhole on top of their heads to breathe","They build their nests in tall trees"
                ,"Are considered “Man’s best friend”","Are considered “Man’s best friend”");
        this.addQuestion(q5);
        Question q6=new Question("Which one is true about grapes?"
                ,"Contain more sugar than lemons", "They can explode if you put them in the microwave"
                ,"Should never be refrigerated as the skin will blacken"
                , "They can explode if you put them in the microwave");
        this.addQuestion(q6);
        Question q7=new Question("Which of these facts is true about cherries? "
                , "Contains 92% of water", "Cherries will help you sleep better",
                "The juiciest, most delicious cherries in the world are grown in Florida"
                , "Cherries will help you sleep better");
        this.addQuestion(q7);
        Question q8=new Question("Can you tell me which one is true about kiwis?"
                ,"Kiwifruit is fat-free, and two kiwis alone contain more fiber than most bran cereal",
                "A medium sized kiwi only contains about 20 calories","In China, they are a symbol of good luck"
                ,"Kiwifruit is fat-free, and two kiwis alone contain more fiber than most bran cereal");
        this.addQuestion(q8);
        Question q9=new Question("Which one is true about strawberry?"
                , "Although they are sour, strawberries contain more sugar than lemon"
                , "An average strawberry has around 200 seeds", "Wild strawberries originated in southern Africa"
                ,"An average strawberry has around 200 seeds");
        this.addQuestion(q9);
        Question q10=new Question("Which one is true about lemons? "
                ,"Although they are sour, lemons contain more sugar than strawberries"
                ,"Lemons don’t grow on trees, they grow on big plants"
                ," It takes about 2.5 pounds of lemons to make one bottle of wine"
                ,"Although they are sour, lemons contain more sugar than strawberries");
        this.addQuestion(q10);
        Question q11=new Question("Which one is true about onions?"," Are very rich in vitamin A"
                , "Onions will lower the blood pressure and will also reduce the risk of heart attacks",
                "Onions is called maize in most countries"
                , "Onions will lower the blood pressure and will also reduce the risk of heart attacks");
        this.addQuestion(q11);
        Question q12=new Question("Which one is true about spinach?"
                , "Spinach are also called toadstools", "Eating Spinach made Popeye strong"
                , "Closely related to Squash", "Eating Spinach made Popeye strong");
        this.addQuestion(q12);
        Question q13=new Question("Which one is true about radish?","They were first cultivated in China"
                , "Radishes are good for eyesight","Eating a lot of radishes will make you sleepy"
                ,"They were first cultivated in China");
        this.addQuestion(q13);
        Question q14=new Question("Which one is true about broccoli?"
                , "Broccoli was once known as Italian Asparagus", "A cob of broccoli has 800 kernels"
                , "Is considered a fruit", "Broccoli was once known as Italian Asparagus");
        this.addQuestion(q14);
        Question q15=new Question("Which one is true about corn?"
                ,"A corn is a root vegetable","Corn will always have an even number of rows on the cob"
                ,"The corn grows on a bush","Corn will always have an even number of rows on the cob");
        this.addQuestion(q15);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
// Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}