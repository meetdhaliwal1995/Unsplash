package com.example.foundcontact;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<PhnContacts> _list = new ArrayList<>();
    private int traker = 0;
    private Boolean track = true;
    RecyclerView recyclerView;
    ImageView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        search = findViewById(R.id.image_view);

        getContactList();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchDialog(getApplicationContext());
            }
        });



        ContactsAdapter contactsAdapter = new ContactsAdapter(_list, MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(contactsAdapter);
    }

    private void getContactList() {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext() && track) {
                        traker = traker + 1;
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));

                        PhnContacts model = new PhnContacts(name, phoneNo, id);

                        _list.add(model);

                        Log.e("hh", "Name: " + name);
                        Log.e("jj", "Phone Number: " + phoneNo);
                        if (traker == 200) {
                            track = false;
                        }
                    }
                    pCur.close();
                }
            }
        }
        if (cur != null) {
            cur.close();
        }

    }

    private void SearchDialog(Context applicationContext) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.search_activity, null);
        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        TextView enter = dialogView.findViewById(R.id.enter_text);
        final EditText editText = dialogView.findViewById(R.id.edit_text);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String string = editText.getText().toString();
              for (int i = 0; i<_list.size(); i++){
                  if (_list.get(i).getNumber().contains(string)){
                      Log.e("ddd","hhhh");
                      Toast.makeText(MainActivity.this, "Number already exist", Toast.LENGTH_SHORT).show();
                      break;
                  }
              }
            }
        });
    }
}
