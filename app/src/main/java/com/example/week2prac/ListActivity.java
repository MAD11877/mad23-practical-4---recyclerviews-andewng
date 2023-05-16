package com.example.week2prac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private ArrayList<User> userList= new ArrayList<>();
    private RecyclerViewClickListener listener;

    String title ="List Activity";
    ImageView imageView;
    AlertDialog.Builder builder;
    TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);




    }
    private int generateNO(){
        Random random= new Random();
        int randNum =random.nextInt(99999999);
        return randNum;

    }
    Integer RandomNum;

    private void openAlertBox(int pos) {
        txt = findViewById(R.id.textView);
        builder = new AlertDialog.Builder(ListActivity.this);
        builder.setTitle("User profile");
        builder.setMessage(userList.get(pos).getName()+generateNO());
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                RandomNum=generateNO();
                Intent newAct = new Intent(ListActivity.this,MainActivity.class);
                newAct.putExtra("randomNumber",RandomNum);
                newAct.putExtra("username",userList.get(pos).getName());
                newAct.putExtra("desc",userList.get(pos).getDescription());
                newAct.putExtra("followed",userList.get(pos).getFollowed());
                startActivity(newAct);


            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @Override
    protected void onResume(){
        userList.add(new User("Abel","hello",generateNO(),true));
        userList.add( new User("Ben","hi", generateNO(),true));
        userList.add( new User("Cassie","bye",generateNO(),false));
        userList.add( new User("Damian","131313",generateNO(),false));
        userList.add( new User("Erik","12345",generateNO(),false));
        userList.add( new User("Terry","145",generateNO(),true));
        userList.add( new User("Wendy","13334",generateNO(),true));
        userList.add( new User("Andrew","28026",generateNO(),false));
        userList.add( new User("Xq","670067",generateNO(),true));
        userList.add( new User("Miki","260028",generateNO(),false));
        userList.add(new User("Yves","545454",generateNO(),true));
        userList.add(new User("Marcus","25679",generateNO(),true));
        userList.add( new User("Isaac","88888",generateNO(),false));
        userList.add( new User("Daniel","78901",generateNO(),true));
        userList.add(new User("Jaden","600069",generateNO(),false));
        userList.add( new User("Name","122233",generateNO(),true));
        userList.add( new User("Harry","009001",generateNO(),false));
        userList.add( new User("Oompa","00701",generateNO(),false));
        userList.add( new User("Salah","29013",generateNO(),false));
        userList.add( new User("Kevin","170115",generateNO(),false));


        super.onResume();
        Log.v(title,"On resume");

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        setOnClickListener();
        BrandsAdapter mAdapter = new BrandsAdapter(userList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
    public class BrandViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nametxt;
        TextView destxt;

        public BrandViewHolder(View itemView){
            super(itemView);
            nametxt=itemView.findViewById(R.id.textView3);
            destxt=itemView.findViewById(R.id.textView4);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());

        }
    }
   public class BrandsAdapter extends
           RecyclerView.Adapter<BrandViewHolder>{



        public BrandsAdapter(ArrayList<User>userList) {

        }
       @NonNull
       @Override
       public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,
                   parent,
                   false);
           return new BrandViewHolder(item);

       }

       @Override
       public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        String name = userList.get(position).getName();
        String desc = userList.get(position).getDescription();
        holder.nametxt.setText(name);
        holder.destxt.setText("Description "+desc);

       }

       @Override
       public int getItemCount() {
           return userList.size();
       }

   }
   private void setOnClickListener(){
        listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int pos) {
                openAlertBox(pos);
            }
        };
   }

   public interface RecyclerViewClickListener{
    void onClick(View v,int pos);

   }








}