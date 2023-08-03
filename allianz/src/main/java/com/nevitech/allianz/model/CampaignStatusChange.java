package com.nevitech.allianz.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campaign_status_changes")
public class CampaignStatusChange {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "campaign_id")
	    private String campaignId;

	    @Column(name = "status")
	    private String status;

	    @Column(name = "change_timestamp")
	    private Instant changeTimestamp;

    // Constructors, getters, and setters

    public CampaignStatusChange() {
    }

    public CampaignStatusChange(int id, String campaignId, String status, Instant changeTimestamp) {
        this.id = id;
        this.campaignId = campaignId;
        this.status = status;
        this.changeTimestamp = changeTimestamp;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getChangeTimestamp() {
        return changeTimestamp;
    }

    public void setChangeTimestamp(Instant changeTimestamp) {
        this.changeTimestamp = changeTimestamp;
    }
}
