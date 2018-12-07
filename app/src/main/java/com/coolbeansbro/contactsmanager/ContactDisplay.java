package com.coolbeansbro.contactsmanager;



import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;




public class ContactDisplay extends ArrayAdapter<Contact> {

        private LayoutInflater mInflater;

        private List<Contact> mContacts = null;

        private ArrayList<Contact> arrayList; //used for the search bar

        private int layoutResource;



        public ContactDisplay(@NonNull Context context, @LayoutRes int resource, @NonNull List<Contact> contacts) {

            super(context, resource, contacts);

            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            layoutResource = resource;



            mContacts = null;
            this.mContacts = contacts;

            arrayList = new ArrayList<>();
            this.arrayList.addAll(mContacts);
        }



        private static class ViewHolder{

            TextView name;

            TextView number;

        }



        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final ViewHolder holder;

            if(convertView == null){
                convertView = mInflater.inflate(layoutResource, parent, false);
                holder = new ViewHolder();

                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.number = (TextView) convertView.findViewById(R.id.number);

                convertView.setTag(holder);
            } else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.name.setText(getItem(position).getName());
            holder.number.setText(getItem(position).getNumber());

            return convertView;
        }

    @Override
    public int getCount() {
        return mContacts.size();
    }
}




