package dev.abhishek.multicyclerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import dev.abhishek.twowayrecycler.ContentList;
import dev.abhishek.twowayrecycler.ItemVo;
import dev.abhishek.twowayrecycler.TwoWayRecycler;
import dev.abhishek.twowayrecycler.views.OnRecyclerItemClickListener;

public class MainActivity extends AppCompatActivity implements OnRecyclerItemClickListener {

    private TwoWayRecycler twoWayRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoWayRecycler = (TwoWayRecycler) findViewById(R.id.recycler);

        ContentList<ItemVo> itemVoList = new ContentList<>();
        int i = 0;
        while (i<10){
           itemVoList.add(new ItemVo() {});
            i++;
        }

        twoWayRecycler.setRowData(itemVoList, this);
    }

    @Override
    public void onItemClick(ItemVo content) {

    }

    @Override
    public void onItemLongClick(ItemVo content, int position) {

    }

    @Override
    public void onSeeAllPressed(ItemVo content) {

    }
}
