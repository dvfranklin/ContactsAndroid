package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{

    EditText name;
    EditText phone;
    Button  addButton;
    ListView listView;
    ArrayAdapter<String> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        addButton = (Button) findViewById(R.id.addButton);
        listView = (ListView) findViewById(R.id.listView);

        contacts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(contacts);

        addButton.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String nameField = this.name.getText().toString();
        String phoneField = this.phone.getText().toString();
        String contact = nameField + " (" + phoneField + ")";
        contacts.add(contact);

        this.name.setText("");
        this.phone.setText("");
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        String contact = contacts.getItem(i);
        contacts.remove(contact);
        return true;
    }
}
