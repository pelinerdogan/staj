package com.nevitech.allianz.dao;

import java.util.List;

import com.nevitech.allianz.model.CampaignStatusChange;
import com.nevitech.allianz.model.campaign;

public interface campaigndao {
	public int insertCampaign(campaign Campaign);

	public List<campaign> getAllRowsFromTable();

	public campaign getCampaignByName(String Name);

	public void deactivateoractivate(campaign c);

	public campaign getCampaignById(String id);

	public List<campaign> getactivecampaigns();

	public List<campaign> getdeactivecampaigns();

	public List<CampaignStatusChange> getCampaignStatusChanges(String campaignId);
}
