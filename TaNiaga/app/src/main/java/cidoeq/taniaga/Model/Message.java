package cidoeq.taniaga.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zhorifiandi on 7/30/17.
 */

public class Message {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("no_hp")
    @Expose
    private String noHP;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNoHP() {
        return noHP;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
