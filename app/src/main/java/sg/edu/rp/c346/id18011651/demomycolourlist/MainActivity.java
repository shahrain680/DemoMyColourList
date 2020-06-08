package sg.edu.rp.c346.id18011651.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    EditText etIndexElement;
    Button btnRemove;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement=findViewById(R.id.editTextColour);
        btnAdd=findViewById(R.id.buttonAddItem);
        lvColour=findViewById(R.id.listViewColour);
        etIndexElement=findViewById(R.id.editTextIndex);
        btnRemove=findViewById(R.id.buttonRemoveItem);
        btnUpdate=findViewById(R.id.buttonUpdateItem);
        final ArrayList <String> alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");
        final ArrayAdapter aaColour=new ArrayAdapter(this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour =etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = (lvColour.getItemAtPosition(position)).toString();
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if(pos>(alColours.size()-1)){
                    Toast.makeText(MainActivity.this,"There is no such position",Toast.LENGTH_SHORT).show();
                }else{
                    alColours.remove(pos);
                }
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour =etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                for(String s:alColours){
                    if(s.equalsIgnoreCase(colour)||pos>(alColours.size()-1)){
                        Toast.makeText(MainActivity.this,"Colour already exists or position does not exist",Toast.LENGTH_SHORT).show();
                    }else{
                        alColours.add(pos,colour);
                    }
                }
                aaColour.notifyDataSetChanged();
            }
        });
    }
}
