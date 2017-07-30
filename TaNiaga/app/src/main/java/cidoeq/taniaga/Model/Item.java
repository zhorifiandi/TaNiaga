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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
