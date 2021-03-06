package cidoeq.taniaga;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cidoeq.taniaga.Model.Item;

/**
 * Created by toshiba on 30/7/2017.
 */

public class ItemAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflter;
    String[] name;
    int[] price;
    String[] category;
    String[] seller;
    int nItem;

    public ItemAdapter(Context applicationContext, List<Item> items){
        nItem = items.size();
        context = applicationContext;
        name = new String[nItem];
        price = new int[nItem];
        category = new String[nItem];
        seller = new String[nItem];

        for (int i=0; i < nItem; i++){
            name[i] = items.get(i).getName();
            price[i] = items.get(i).getPrice();
            category[i] = items.get(i).getCategory();
            seller[i] = items.get(i).getSeller_name();
        }


        inflter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return name.length;
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
        View view = inflter.inflate(R.layout.list_item, viewGroup,false);

        ImageView imageItem = (ImageView) view.findViewById(R.id.image_for_list_item);
        TextView nameItem = (TextView) view.findViewById(R.id.text_nama_produk_for_list_item);
        TextView priceItem = (TextView) view.findViewById(R.id.text_price_for_list_item);
        TextView categoryItem = (TextView) view.findViewById(R.id.text_category_for_list_item);
        TextView sellerItem = (TextView) view.findViewById(R.id.text_seller_for_list_item);

        imageItem.setImageResource(R.drawable.solid_gray);
        nameItem.setText(name[i]);
        priceItem.setText("Rp " + price[i] + ",-");
        categoryItem.setText(category[i]);
        sellerItem.setText(seller[i]);

        return view;
    }
}
