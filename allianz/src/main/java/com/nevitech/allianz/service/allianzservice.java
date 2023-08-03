package com.nevitech.allianz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nevitech.allianz.dao.campaigndao;
import com.nevitech.allianz.model.CampaignStatusChange;
import com.nevitech.allianz.model.campaign;

@Service
public class allianzservice {
	private final campaigndao campaignDao;

	@Autowired
	public allianzservice(@Qualifier("insuranceDao") campaigndao campaignDao) {
		this.campaignDao = campaignDao;
	}

	public int addcampaign(campaign camp) {
		return campaignDao.insertCampaign(camp);
	}

	public List<campaign> getAllcampaigns() {

		return campaignDao.getAllRowsFromTable();
	}

	public Boolean controlnameexists(String name) {

		if (campaignDao.getCampaignByName(name) != null)
			return true;
		else
			return false;

	}

	public campaign getWithName(String name) {

		return campaignDao.getCampaignByName(name);

	}

	public campaign getWithid(String id) {

		return campaignDao.getCampaignById(id);

	}

	public void deactivateoractivateCampaign(campaign c) {
	
		campaignDao.deactivateoractivate(c);
	}

	public String getcampaignstatistics() {
		int active = campaignDao.getactivecampaigns().size();
		int deactive = campaignDao.getdeactivecampaigns().size();
		return " Active :" + active + " Deactive :" + deactive;
	}

	public List<CampaignStatusChange> getCampaignStatusChanges(String campaignId) {
		return campaignDao.getCampaignStatusChanges(campaignId);

	}

}
