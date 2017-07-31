package cidoeq.taniaga;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cidoeq.taniaga.Model.Message;

/**
 * Created by toshiba on 30/7/2017.
 */

public class ContactAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflter;
    String[] name;
    String[] noHP;
    int nItem;

    public ContactAdapter(Context applicationContext, List<Message> msg){
        nItem = msg.size();
        context = applicationContext;
        name = new String[nItem];
        noHP = new String[nItem];

        for (int i=0; i < nItem; i++){
            name[i] = msg.get(i).getName();
            noHP[i] = msg.get(i).getNoHP();
        }

        inflter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return nItem;
    }

    @Override
    public String getItem(int i) {
        return name[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View v, ViewGroup viewGroup){
        View view = inflter.inflate(R.layout.list_contact, viewGroup,false);

        TextView textNama = (TextView) view.findViewById(R.id.text_nama_petani_contact);
        TextView textNoHP = (TextView) view.findViewById(R.id.text_no_hp_petani_contact);

        textNama.setText(name[i]);
        textNoHP.setText(noHP[i]);

        return view;
    }
}
