package com.coolbeansbro.contactsmanager;



import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;




public class ContactDisplay extends ArrayAdapter<userContact> {

        private LayoutInflater mInflater;

        private List<userContact> mContacts = null;

        private ArrayList<userContact> arrayList; //used for the search bar

        private int layoutResource;


        ContactDisplay(@NonNull Context context, @LayoutRes int resource, @NonNull List<userContact> contacts) {

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

            holder.name.setText(arrayList.get(position).getName());
            holder.number.setText(arrayList.get(position).getNumber());

            return convertView;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }


        private Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                ArrayList<userContact> tempList=new ArrayList<userContact>();

                for (userContact c:mContacts){
                    if (c.getName().toLowerCase().contains(constraint.toString().toLowerCase())){
                        tempList.add(c);
                    }
                }

                filterResults.values = tempList;

                return filterResults;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence contraint, FilterResults results) {
                arrayList = (ArrayList<userContact>) results.values;

                if (results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };


    @NonNull
    @Override
    public Filter getFilter() {
        return myFilter;
    }

    void initFilter(){
        arrayList = new ArrayList<>();
        this.arrayList.addAll(mContacts);
    }

}




