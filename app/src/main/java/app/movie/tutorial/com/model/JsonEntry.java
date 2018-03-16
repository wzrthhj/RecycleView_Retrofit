package app.movie.tutorial.com.model;

/**
 * Created by haijingx on 3/14/18.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonEntry {
    @SerializedName("photos")
    @Expose
    private PhotosResponse photos;

    @SerializedName("stat")
    @Expose
    private String stat;

    public PhotosResponse getPhotos() {
        return photos;
    }

    public void setPhotos(PhotosResponse photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
