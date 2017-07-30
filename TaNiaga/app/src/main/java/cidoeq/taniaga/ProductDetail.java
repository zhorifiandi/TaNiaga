package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cidoeq.taniaga.Helper.SharedPrefManager;
import cidoeq.taniaga.Model.Item;

public class ProductDetail extends AppCompatActivity {

    public int priceProduct = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_back_detail);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetail.this, Home.class);
                startActivity(i);
            }
        });

        Button buttonBuy = (Button) findViewById(R.id.button_buy);
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetail.this, ConfirmPurchase.class);
                startActivity(i);
            }
        });

        Item item = SharedPrefManager.getInstance(ProductDetail.this).getItem();
        System.out.println("id : " + item.getId());
        System.out.println("Name : " + item.getName());
        System.out.println("Category : " + item.getCategory());
        System.out.println("Price : " + item.getPrice());
        System.out.println("Desc : " + item.getDescription());
        System.out.println("Dim : " + item.getDimension());
        System.out.println("Sel : " + item.getSeller_email());
        System.out.println("Var : " + item.getVariety());

        TextView textNamaProduk = (TextView) findViewById(R.id.text_nama_produk_detailed);
        TextView textHargaProduk = (TextView) findViewById(R.id.text_harga_produk_detailed);
        TextView textKategoriProduk = (TextView) findViewById(R.id.text_category_produk_detailed);
        TextView textPenjualProduk = (TextView) findViewById(R.id.text_penjual_produk_detailed);
        TextView textDeskripsiProduk = (TextView) findViewById(R.id.text_detail_description_detailed);


        priceProduct = item.getPrice();
        textNamaProduk.setText(item.getName());
        textHargaProduk.setText("Rp " + item.getPrice() + ",-");
        textKategoriProduk.setText(item.getCategory());
        textPenjualProduk.setText(item.getSeller_name());
        textDeskripsiProduk.setText(item.getDescription());

        final EditText editQuantity = (EditText) findViewById(R.id.edit_quantity);
        editQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                TextView textTotal = (TextView) findViewById(R.id.text_total_bayar_on_detailed);
                int total;
                if (editQuantity.getText().length() != 0){
                    total = Integer.parseInt(editQuantity.getText().toString()) * priceProduct;
                } else {
                    total = 0;
                }
                textTotal.setText("Total: Rp " + total + ",-");
            }
        });



    }
}
