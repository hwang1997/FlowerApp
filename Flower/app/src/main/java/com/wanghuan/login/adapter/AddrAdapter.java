package com.wanghuan.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wanghuan.login.R;
import com.wanghuan.login.model.Addr;

import java.util.List;

public class AddrAdapter extends ArrayAdapter<Addr> {

    private int resourceId;
    public AddrAdapter(Context context, int textViewResourceId, List<Addr> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        final Addr addr = getItem(position);

        View view;
        final ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.addr_address = (TextView) view.findViewById(R.id.tv_item_address);
            viewHolder.addr_name = (TextView) view.findViewById(R.id.tv_item_name);
            viewHolder.addr_tel = (TextView) view.findViewById(R.id.tv_item_tel);
            viewHolder.addr_btn_delete = (Button) view.findViewById(R.id.btn_addr_delete);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.addr_btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(getItem(position));
                Toast.makeText(getContext(),"删除"+addr.getAddress(),Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.addr_address.setText(addr.getAddress());
        viewHolder.addr_name.setText(addr.getName());
        viewHolder.addr_tel.setText(addr.getTel());
        return view;
    }

    class ViewHolder{
        TextView addr_address;
        TextView addr_name;
        TextView addr_tel;
        Button addr_btn_delete;
    }
}
