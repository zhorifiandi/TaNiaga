package cidoeq.taniaga;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cidoeq.taniaga.Model.Item;
import cidoeq.taniaga.Model.Message;

/**
 * Created by toshiba on 30/7/2017.
 */

public class MessageAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflter;
    String[] name;
    String[] noHP;
    String[] content;
    int nItem;

    public MessageAdapter(Context applicationContext, List<Message> msg){
        nItem = msg.size();
        context = applicationContext;
        name = new String[nItem];
        noHP = new String[nItem];
        content = new String[nItem];

        for (int i=0; i < nItem; i++){
            name[i] = msg.get(i).getName();
            noHP[i] = msg.get(i).getNoHP();
            content[i] = msg.get(i).getContent();
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
        View view = inflter.inflate(R.layout.list_message, viewGroup,false);

        TextView textNama = (TextView) view.findViewById(R.id.text_nama_petani);
        TextView textNoHP = (TextView) view.findViewById(R.id.text_no_hp_petani);
        TextView textContent = (TextView) view.findViewById(R.id.text_isi);

        textNama.setText(name[i]);
        textNoHP.setText(noHP[i]);
        textContent.setText(content[i]);

        return view;
    }
}
