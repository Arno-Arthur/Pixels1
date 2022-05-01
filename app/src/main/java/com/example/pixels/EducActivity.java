package com.example.pixels;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EducActivity extends SecondActivity{
    ExpandableListView exlv;
    ExpandableListAdapter exla;
    List<String> list;
    List<String> clist;
    Map<String,List<String>> collect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.educ_activity);
        exlv = findViewById(R.id.exlv);
        createList();
        createColl();
        exla = new com.example.pixels.ExpandableListAdapter(this,list,collect);
        exlv.setAdapter(exla);
        exlv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastP = -1;
            @Override
            public void onGroupExpand(int i) {
                if(lastP != -1 && i != lastP){
                    exlv.collapseGroup(lastP);
                    lastP = i;
                }

            }
        });

        exlv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String selected = exla.getChild(i,i1).toString();
                Toast.makeText(getApplicationContext(),"Загрузка", Toast.LENGTH_SHORT).show();
                click(i,i1);
                return true;

            }
        });
    }

    private void click(int i, int i1) {
        String selected = exla.getChild(i,i1).toString();
        if(selected == "Урок 1.1 - Подцарство Простейшие"){
            String url = "https://foxford.ru/wiki/biologiya/odnokletochnye-sarkodovye" +
                    "-zhgutikovye-infuzorii?utm_source=admitad&utm_medium=cpa&utm_" +
                    "content=1560786&admitad_uid=2d39795edebbbdbffda78e616ab66145&";
        Intent a = new Intent(Intent.ACTION_VIEW);
        a.setData(Uri.parse(url));
        startActivity(a);
        }
        else if (selected == "Урок 1.2 - Класс Млекопитающие"){
            String url = "https://foxford.ru/wiki/biologiya/klass-mlekopitayuschie";
            Intent a = new Intent(Intent.ACTION_VIEW);
            a.setData(Uri.parse(url));
            startActivity(a);
        }
        else if (selected == "Урок 1.3 - Класс Насекомые"){
            String url = "https://foxford.ru/wiki/biologiya/klass-nasekomye";
            Intent a = new Intent(Intent.ACTION_VIEW);
            a.setData(Uri.parse(url));
            startActivity(a);
        }
        else if (selected == "Урок 2.1 - Водоросли"){
            String url = "https://foxford.ru/wiki/biologiya/vodorosli-obshchaya-harakteristika";
            Intent a = new Intent(Intent.ACTION_VIEW);
            a.setData(Uri.parse(url));
            startActivity(a);
        }
        else if (selected == "Урок 2.2 - Отдел Плауновидные"){
            String url = "https://foxford.ru/wiki/biologiya/otdel-plaunovidnye";
            Intent a = new Intent(Intent.ACTION_VIEW);
            a.setData(Uri.parse(url));
            startActivity(a);
        }
        else if (selected == "Млекопитающие"){
            String url = "https://foxford.ru/trainings/987";
            Intent a = new Intent(Intent.ACTION_VIEW);
            a.setData(Uri.parse(url));
            startActivity(a);
        }
        else if (selected == "Покровы тела"){
            String url = "https://foxford.ru/trainings/988";
            Intent a = new Intent(Intent.ACTION_VIEW);
            a.setData(Uri.parse(url));
            startActivity(a);
        }
    }

    private void createColl() {
        String[] SModels = {"Урок 1.1 - Подцарство Простейшие", "Урок 1.2 - Класс Млекопитающие",
                "Урок 1.3 - Класс Насекомые"};
        String[] MModels = {"Урок 2.1 - Водоросли", "Урок 2.2 - Отдел Плауновидные"};
        String[] Test = {"Млекопитающие" , "Покровы тела"};
        collect = new HashMap <String, List<String>>();
        for (String group : list) {
            if (group.equals("Глава 1. Царство Животные")) {
                load(SModels);
            } else if (group.equals("Глава 2. Царство Растения")) {
                load(MModels);
            }
            else if (group.equals("Тесты")){
                load(Test);
            }
            collect.put(group,clist);
        }
    }
    private void createList () {
        list = new ArrayList<>();
        list.add("Глава 1. Царство Животные");
        list.add("Глава 2. Царство Растения");
        list.add("Тесты");
    }

    private void load(String[] mobileModel) {
        clist = new ArrayList<>();
        for(String model: mobileModel){
            clist.add(model);
        }

    }
}
