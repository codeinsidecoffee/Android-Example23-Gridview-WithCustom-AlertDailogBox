package com.mrlonewolfer.example54;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapter extends BaseAdapter {
    ArrayList<ImageBean> imgArrayList;
    Context context;

    ImageBean imageBean;
    ImageView imageView;
    ListView tableLayout;
    TextView textView;
    EditText edtId,edtName,edtPrice,edtQty;
    TextView txtId,txtName,txtPrice,txtQty;
    Button btnSumbit,btnCancel;
    int id,qty;
    String name;
    double price;
    ArrayList<InventoryBean> inventoryArrayList;
    InventoryBean myInventoryBeans;
    public ImageAdapter(Context context, ArrayList<ImageBean> imgArrayList) {
    this.context= context;
    this.imgArrayList= imgArrayList;
    }

    @Override
    public int getCount() {
        return imgArrayList.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            convertView=inflater.inflate(R.layout.grid_view_row_item,parent,false);
        }
        inventoryArrayList=new ArrayList<>();
        imageBean=imgArrayList.get(position);
        imageView=convertView.findViewById(R.id.grid_image);
        textView=convertView.findViewById(R.id.grid_text);

        imageView.setImageResource(imageBean.getImgId());
        textView.setText(imageBean.getImgName());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(imgArrayList.get(position).getImgName().equals("Add")){
                 LayoutInflater layoutInflater=LayoutInflater.from(context);
                   View layoutInflateView=layoutInflater.inflate
                           (R.layout.add_item_row, (ViewGroup)v.findViewById(R.id.myAddCardView));
                   final AlertDialog.Builder builder=new AlertDialog.Builder(context);
                   builder.setView(layoutInflateView);
                   final AlertDialog dailog=builder.create();

                  dailog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    edtId=layoutInflateView.findViewById(R.id.edtId);
                    edtName=layoutInflateView.findViewById(R.id.edtItemName);
                    edtPrice=layoutInflateView.findViewById(R.id.edtItemPrice);
                    edtQty=layoutInflateView.findViewById(R.id.edtItemQty);

                    btnCancel=layoutInflateView.findViewById(R.id.btnCancel);
                    btnSumbit=layoutInflateView.findViewById(R.id.btnSumbit);
                    btnSumbit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            id= Integer.parseInt(edtId.getText().toString());
                            name=edtName.getText().toString();
                            price=Double.parseDouble(edtPrice.getText().toString());
                            qty= Integer.parseInt(edtQty.getText().toString());
                            inventoryArrayList.add(new InventoryBean(id,qty,name,price));


                            Toast.makeText(context, "Data Succeffuly added \n"+
                                    inventoryArrayList.get(position).itemName+" price is"
                                            +inventoryArrayList.get(position).itemPrice
                                    , Toast.LENGTH_SHORT).show();
                            dailog.dismiss();
                            Toast.makeText(context, "Image ArrayList size : "+inventoryArrayList.size(), Toast.LENGTH_SHORT).show();

                        }
                    });


                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "You Click on Cancel : ", Toast.LENGTH_SHORT).show();
                            dailog.dismiss();
                        }
                    });

//                   Toast.makeText(context, "You Click On : "+imgArrayList.get(position).getImgName(), Toast.LENGTH_SHORT).show();
                  dailog.show();
               }

               if(imgArrayList.get(position).getImgName().equals("View")){

                   LayoutInflater layoutInflater=LayoutInflater.from(context);
                   View layoutInflateView=layoutInflater.inflate
                           (R.layout.view_row_item, (ViewGroup)v.findViewById(R.id.myAddCardView));
                   final AlertDialog.Builder builder=new AlertDialog.Builder(context);
                   builder.setView(layoutInflateView);
                   final AlertDialog dailog=builder.create();


                   dailog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                    tableLayout=layoutInflateView.findViewById(R.id.displayInventory);
                   Toast.makeText(context, "Image ArrayList size : "+inventoryArrayList.size(), Toast.LENGTH_SHORT).show();

                           TableLayoutAdapter tableAdapter= new TableLayoutAdapter(context,inventoryArrayList);
                           tableLayout.setAdapter(tableAdapter);



                       btnCancel=layoutInflateView.findViewById(R.id.btnCancel);
                       btnSumbit=layoutInflateView.findViewById(R.id.btnSumbit);
                       dailog.show();

                   

                  
               }

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Click On : "+imgArrayList.get(position).getImgName(), Toast.LENGTH_SHORT).show();
            }
        });



        return convertView;
    }


}
