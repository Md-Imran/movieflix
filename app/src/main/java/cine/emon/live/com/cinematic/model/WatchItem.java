package cine.emon.live.com.cinematic.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WatchItem  {

    @SerializedName("portrait")
    @Expose
    private String portrait;

    @SerializedName("contentId")
    @Expose
    private String contentId;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("watchState")
    @Expose
    private String watchState;

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }


    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getWatchStatus() {
        return watchState;
    }

    public void setWatchStatus(String watchStatus) {
        this.watchState = watchStatus;
    }
}