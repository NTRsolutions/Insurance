package com.insurance.bluescheme.insure.model;

/**
 * Created by tonmoybarua on 20-Apr-17.
 */

public class InsureCategory {

           private String id ;
           private String title;
           private String description;
           private String  photo;
    int img;
    public InsureCategory(String p_title, String p_des, int image_id) {
        title = p_title;
        description = p_des;
        img = image_id;
    }
    public InsureCategory() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
