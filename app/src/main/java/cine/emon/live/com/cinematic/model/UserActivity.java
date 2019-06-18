package cine.emon.live.com.cinematic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserActivity {

    @Expose
    @SerializedName("userId")
    private String userId;
    @Expose
    @SerializedName("contentId")
    private String contentId;
    @Expose
    @SerializedName("viewTime")
    private String viewTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getViewTime() {
        return viewTime;
    }

    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }

}
