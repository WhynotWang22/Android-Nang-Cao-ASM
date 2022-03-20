package com.example.hotro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Tintuc extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintuc);
        listView = findViewById(R.id.lv1);
        AsyncTask<String,Void,String> content = new RSSFeed().execute("https://vnexpress.net/rss/tin-moi-nhat.rss");
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        intent = new Intent(this,Tintuc2.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String link = arrayLink.get(position);
                intent.putExtra("openlink",link);
                startActivity(intent);
            }
        });
    }
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayLink = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    Intent intent;
    public class RSSFeed extends AsyncTask<String,Void,String>{
        //lay du lieu tu sever
        @Override
        protected String doInBackground(String... strings) {
            StringBuffer content = new StringBuffer();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = "";
                while ((line= bufferedReader.readLine())!=null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLParse xmlParse = new XMLParse();
            try {
                Document document = xmlParse.getDocument(s);
                NodeList nodeList = document.getElementsByTagName("item");
                String title = "";//lay ve title
                for (int i =0;i<nodeList.getLength();i++){
                    Element element = (Element) nodeList.item(i);//lay ve ite, i
                    title = xmlParse.getValue(element,"title")+"\n";
                    arrayList.add(title);
                    arrayLink.add(xmlParse.getValue(element,"link"));
                }
                arrayAdapter.notifyDataSetChanged();
            }catch (IOException e){
                e.printStackTrace();
            }catch (SAXException e){
                e.printStackTrace();
            }

        }
    }
}