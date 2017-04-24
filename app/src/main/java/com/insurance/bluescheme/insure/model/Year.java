package com.insurance.bluescheme.insure.model;

/**
 * Created by tonmoybarua on 30-Mar-17.
 */

public class Year {
    private String policy_year;
    private String policy_term;

    public String getPolicy_year() {
        return policy_year;
    }

    public void setPolicy_year(String policy_year) {
        this.policy_year = policy_year;
    }

    public String getPolicy_term() {
        return policy_term;
    }

    public void setPolicy_term(String policy_term) {
        this.policy_term = policy_term;
    }


    public Year(String p_year, String p_term) {
        policy_term = p_term;
        policy_year = p_year;
    }

}
