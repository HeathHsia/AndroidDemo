package listview.heath.com.listview;

import android.widget.ImageView;

public class Brand {

    public String itemTitle; // 标题
    public String itemImgUrl; // 车标

    public Brand (String title, String imgUrl) {
        this.itemTitle = title;
        this.itemImgUrl = imgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public Brand() {

    }
}
