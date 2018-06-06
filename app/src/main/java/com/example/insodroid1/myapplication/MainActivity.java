package com.example.insodroid1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList = findViewById(R.id.list);
        adapter = new Adapter(this);
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvList.setAdapter(adapter);
        adapter.setData(getList());
    }


    public ArrayList<Model> getList() {

        ArrayList<Model> models = new ArrayList<>();

        Model model1_1 = new Model("Carmelita Badura", 1);
        Model model1_1_1 = new Model("Elisha Pickert", 2);
        Model model1_1_2 = new Model("Patricia Netherton", 2);
        Model model1_1_3 = new Model("Christeen Petrey", 2);
        Model model1_1_4 = new Model("Lolita Moreman", 2);
        model1_1.models.add(model1_1_1);
        model1_1.models.add(model1_1_2);
        model1_1.models.add(model1_1_3);
        model1_1.models.add(model1_1_4);

        Model model1_2 = new Model("Manuela Kass", 1);
        Model model1_2_1 = new Model("Roseanna Branham", 2);

        Model model1_2_1_1 = new Model("Dennise Lasso", 3);
        Model model1_2_1_2 = new Model("Sabrina Shively", 3);
        Model model1_2_1_3 = new Model("Jin Haecker", 3);
        Model model1_2_1_4 = new Model("Season Parrett  ", 3);
        model1_2_1.models.add(model1_2_1_1);
        model1_2_1.models.add(model1_2_1_2);
        model1_2_1.models.add(model1_2_1_3);
        model1_2_1.models.add(model1_2_1_4);

        Model model1_2_2 = new Model("Vicky Parkhurst", 2);
        Model model1_2_3 = new Model("Taisha Dragoo", 2);
        Model model1_2_4 = new Model("Abbey Ballance", 2);
        model1_2.models.add(model1_2_1);
        model1_2.models.add(model1_2_2);
        model1_2.models.add(model1_2_3);
        model1_2.models.add(model1_2_4);

//        model1_2.models.add(model1_2_1);
//        model1_2.models.add(model1_2_2);
//        model1_1.models.add(model1_2_3);
//        model1_1.models.add(model1_2_4);


        Model model1_3 = new Model("Arlinda Fogal", 1);

        Model model1_4 = new Model("Stephen Cabe", 1);
        Model model1_4_1 = new Model("Cherilyn Lehn", 2);
        Model model1_4_2 = new Model("Lashay Baumer", 2);
        Model model1_4_3 = new Model("Abbie Kilmer", 2);
        Model model1_4_4 = new Model("Clinton Boyers", 2);
        model1_4.models.add(model1_4_1);
        model1_4.models.add(model1_4_2);
        model1_4.models.add(model1_4_3);
        model1_4.models.add(model1_4_4);

        models.add(model1_1);
        models.add(model1_2);
        models.add(model1_3);
        models.add(model1_4);


        return models;
    }

}
