package top.wefor.now.data.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import top.wefor.now.data.http.NowApi;

/**
 * Created by tangqi on 8/20/15.
 */
public class Zhihu implements Serializable {
    @SerializedName("images")
    public List<String> images;
    @SerializedName("type")
    public int type;
    @SerializedName("id")
    public int id;
    @SerializedName("ga_prefix")
    public String ga_prefix;
    @SerializedName("title")
    public String title;
    @SerializedName("multipic")
    public boolean multipic;

    public NowItem toNow() {
        NowItem nowItem = new NowItem();
        nowItem.url = NowApi.getNewsContent(this.id);
        nowItem.collectedDate = new Date().getTime();
        nowItem.imageUrl = this.images.get(0);
        nowItem.title = this.title;
        nowItem.from = "ZhiHu";
        return nowItem;
    }

}
