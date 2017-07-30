package cidoeq.taniaga.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zhorifiandi on 7/30/17.
 */

public class Item {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("price")
    @Expose
    private int price;

    @SerializedName("variety")
    @Expose
    private String variety;

    @SerializedName("dimension")
    @Expose
    private String dimension;

    @SerializedName("seller_email")
    @Expose
    private String seller_email;

    @SerializedName("seller_name")
    @Expose
    private String seller_name;

    @SerializedName("seller_id")
    @Expose
    private int seller_id;

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getDimension() {
        return dimension;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public String getVariety() {
        return variety;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public String getSeller_name() {
        return seller_name;
    }
}
