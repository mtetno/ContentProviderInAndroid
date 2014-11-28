package com.mtetno.mymasterpeice_multiplecontactpicker;

import java.util.ArrayList;

public class G_ContactList
{

private ArrayList<G_Contact> contacts = new ArrayList<G_Contact>();

public int getCount()
{
  return this.contacts.size();
}
public void addContact(G_Contact c)
{
  this.contacts.add(c);
}
public void removeContact(G_Contact c)
{
  this.contacts.remove(c);
}
public void removeContact(int id)
{
  for(int i=0;i<this.getCount();i++)
  {
   if(id==Integer.parseInt(this.contacts.get(i).id))
   {
     this.contacts.remove(this.contacts.get(i));
   }
  }
}
public G_Contact getContact(int id)
{
  G_Contact tmp=null;
  for(int i=0;i<this.getCount();i++)
  {
    if(id==Integer.parseInt(this.contacts.get(i).id))
    {
     tmp = new G_Contact(this.contacts.get(i).id,this.contacts.get(i).name,this.contacts.get(i).phone,this.contacts.get(i).label);
    }
  }
  return tmp;
}
public ArrayList<G_Contact> getContacts()
{
  return contacts;
}
public void setContacts(ArrayList<G_Contact> c)
{
  this.contacts=c;
}

}