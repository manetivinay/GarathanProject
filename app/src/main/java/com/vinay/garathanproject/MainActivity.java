package com.vinay.garathanproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vinay.garathanproject.Adapters.RecyclerViewAdapter;
import com.vinay.garathanproject.DataModel.ItemDataModel;

import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {


    RecyclerView recyclerView;
    ArrayList<ItemDataModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new ItemDataModel("Item 1", R.drawable.battle, "#4BAA50"));
        arrayList.add(new ItemDataModel("Item 2", R.drawable.beer, "#4BAA50"));
        arrayList.add(new ItemDataModel("Item 3", R.drawable.ferrari, "#4BAA50"));
        arrayList.add(new ItemDataModel("Item 4", R.drawable.jetpack_joyride, "#4BAA50"));
        arrayList.add(new ItemDataModel("Item 5", R.drawable.three_d, "#4BAA50"));
        arrayList.add(new ItemDataModel("Item 6", R.drawable.terraria, "#4BAA50"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        /*GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);*/
    }

    @Override
    public void onItemClick(ItemDataModel item){

        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
