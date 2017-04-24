package com.insurance.bluescheme.insure.model;

import java.security.Policy;

/**
 * Created by tonmoybarua on 27-Mar-17.
 */

public class PolicyCategory {
    private String policy_title;
    private String policy_des;
    private int imagid;
    private String photo;
    private String id;
    public PolicyCategory() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public PolicyCategory(String p_title, String p_des, int image_id) {
        policy_title = p_title;
        policy_des = p_des;
        imagid = image_id;
    }

    public String getPolicy_title() {
        return policy_title;
    }

    public void setPolicy_title(String policy_title) {
        this.policy_title = policy_title;
    }

    public String getPolicy_des() {
        return policy_des;
    }

    public void setPolicy_des(String policy_des) {
            this.policy_des = policy_des;
    }

    public int getImagid() {
        return imagid;
    }

    public void setImagid(int imagid) {
        this.imagid = imagid;
    }
}
