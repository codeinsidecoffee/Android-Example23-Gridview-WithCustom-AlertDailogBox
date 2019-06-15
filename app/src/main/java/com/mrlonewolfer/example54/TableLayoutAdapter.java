package com.mrlonewolfer.example54;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class TableLayoutAdapter extends BaseAdapter {
    Context context;
    TextView txtId,txtName,txtPrice,txtQty;

    ArrayList<InventoryBean> inventoryArrayList;
    public TableLayoutAdapter(Context context, ArrayList<InventoryBean> inventoryArrayList) {
        this.context=context;
        this.inventoryArrayList=inventoryArrayList;
    }

    @Override
    public int getCount() {
        return inventoryArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            convertView=inflater.inflate(R.layout.custome_table_layout,parent,false);
        }
        txtId=convertView.findViewById(R.id.txtId);
        txtName=convertView.findViewById(R.id.txtName);
        txtPrice=convertView.findViewById(R.id.txtPrice);
        txtQty=convertView.findViewById(R.id.txtQty);

        txtId.setText(inventoryArrayList.get(position).getItemId()+"");
        txtName.setText(inventoryArrayList.get(position).getItemName());
        txtPrice.setText(inventoryArrayList.get(position).getItemPrice()+"");
        txtQty.setText(inventoryArrayList.get(position).getItemqty()+"");

        return convertView;
    }
}
