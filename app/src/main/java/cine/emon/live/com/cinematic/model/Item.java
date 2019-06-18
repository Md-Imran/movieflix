package cine.emon.live.com.cinematic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("portrait")
    @Expose
    private String portrait;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("createdate")
    @Expose
    private String createdate;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("royality")
    @Expose
    private String royality;
    @SerializedName("subcategory")
    @Expose
    private String subcategory;
    @SerializedName("album")
    @Expose
    private String album;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("landscape")
    @Expose
    private String landscape;
    @SerializedName("territory")
    @Expose
    private String territory;
    @SerializedName("contentId")
    @Expose
    private String contentId;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;


    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getRoyality() {
        return royality;
    }

    public void setRoyality(String royality) {
        this.royality = royality;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}