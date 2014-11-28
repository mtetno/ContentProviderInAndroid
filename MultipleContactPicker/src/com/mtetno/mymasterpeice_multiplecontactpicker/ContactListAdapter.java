package com.mtetno.mymasterpeice_multiplecontactpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ContactListAdapter extends BaseAdapter
{
    Context context;
    G_ContactList gcl;
    G_ContactList selectedContacts;

    public ContactListAdapter(Context context,G_ContactList gcl)
    {
     super();
     this.context = context;
     this.gcl=gcl;
     selectedContacts = new G_ContactList();

    }
  /*Custom View Generation(You may modify this to include other Views) */
  @Override
  public View getView(int position, View convertView, ViewGroup parent)
  {
    LayoutInflater inflater = (LayoutInflater)    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

   View view_row = inflater.inflate(R.layout.contact_list_layout, parent,false);

    CheckBox chk_contact = (CheckBox) view_row.findViewById(R.id.chkbxContact);
     chk_contact.setId(Integer.parseInt(gcl.getContacts().get(position).id));

   //Text to display near checkbox [Here, Contact_Name (Number Label : Phone Number)]
     chk_contact.setText(gcl.getContacts().get(position).name.toString() + " ( "+gcl.getContacts().get(position).label+" : " + gcl.getContacts().get(position).phone.toString() + ")");

  if(alreadySelected(gcl.getContacts().get(position)))
  {
     chk_contact.setChecked(true);
  }

   //Code to get Selected Contacts.
     chk_contact.setOnCheckedChangeListener(new OnCheckedChangeListener(){

    @Override
    public void onCheckedChanged(CompoundButton arg0, boolean arg1) {


    G_Contact t = gcl.getContact(arg0.getId());
    if(t!=null && arg1)
    {
                          if(!alreadySelected(t))
                selectedContacts.addContact(t);
    }
    else if(!arg1 && t!=null)
    {
      selectedContacts.removeContact(arg0.getId());
    }


   }

  });

   return view_row;
  }
  public boolean alreadySelected(G_Contact t)
  {
    boolean ret = false;
     
    if(selectedContacts.getContact(Integer.parseInt(t.id))!=null)
         ret=true;
     
    return ret;
  }
  @Override
  public int getCount() {

   return gcl.getCount();
  }

  @Override
  public G_Contact getItem(int arg0) {
   // TODO Auto-generated method stub
   return gcl.getContacts().get(arg0);
  }

  @Override
  public long getItemId(int arg0) {
    return arg0;
    // TODO Auto-generated method stub return      Long.parseLong(gcl.getContacts().get(arg0).id);
  }
  }