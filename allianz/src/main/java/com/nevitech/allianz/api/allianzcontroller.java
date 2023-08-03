package com.nevitech.allianz.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nevitech.allianz.model.CampaignStatusChange;
import com.nevitech.allianz.model.campaign;
import com.nevitech.allianz.service.allianzservice;

@RequestMapping("api/v1/allianz")
@RestController
@CrossOrigin("http://localhost:4200")

public class allianzcontroller {

	private final allianzservice allianzservice;

	@Autowired
	public allianzcontroller(allianzservice service) {
		this.allianzservice = service;
	}

	@PostMapping
	public void addCampagin(@RequestBody campaign Campaign) { 
        long start = System.currentTimeMillis();
		Boolean bool = allianzservice.controlnameexists(Campaign.getName()); // kampanya isminde başka bir kampanya var mı diye kontrol edip sonrasında varsa bu kampanyayı mükerrer işaretliyor
		Campaign.setMukerrer(bool);

		allianzservice.addcampaign(Campaign);
		long end = System.currentTimeMillis();
	}

	@GetMapping
	public List<campaign> getAllcampaigns() { // Tüm kampanyaların listesini döndürüyor
		long start = System.currentTimeMillis();
		List<campaign> l = allianzservice.getAllcampaigns();
		long end = System.currentTimeMillis();
		if(end-start>5)
			System.out.println("işlem " + (end-start) + "Milisaniye sürdü");
		return l;
	}

	@GetMapping(path = "/dashboard/classifieds/statistic")
	public String campaignstatistics() { // kampanya istatistiklerini String olarak "Active : -aktif sayısı- , Deactive : -deactive sayısı-
		long start = System.currentTimeMillis();
		String s = allianzservice.getcampaignstatistics();
		long end = System.currentTimeMillis();
		if(end-start>5)
			System.out.println("işlem " + (end-start) + "Milisaniye sürdü");
		return s;
	}

	@PutMapping(path = "/activate/{id}") // isim tekrarlanabilir olduğu için aktivasyon ve deaktivasyon işlemleri id ile yapılıyor
	public void approveCampaign(@PathVariable("id") String id) {
		long start = System.currentTimeMillis();
		campaign c = allianzservice.getWithid(id);
		if (c != null) {
			if (c.getMukerrer() == false) {
				c.setStatus("active");
				
				allianzservice.deactivateoractivateCampaign(c);
			}
		}
		long end = System.currentTimeMillis();
		if(end-start>5)
			System.out.println("işlem " + (end-start) + "Milisaniye sürdü");
	}

	@PutMapping(path = "/deactivate/{id}")
	public void deactivateCampaign(@PathVariable("id") String id) {
		long start = System.currentTimeMillis();
		campaign c = allianzservice.getWithid(id);
		if (c != null) {
			if (c.getMukerrer() == false) {
				c.setStatus("Deactive");
				allianzservice.deactivateoractivateCampaign(c);
			}
		}
		long end = System.currentTimeMillis();
		if(end-start>5)
			System.out.println("işlem " + (end-start) + "Milisaniye sürdü");
	}

	@GetMapping(path = "/stateChanges/{id}") // kampanyanın idsine göre durum değişikliklerini gösteriyor
	public List<CampaignStatusChange> getCampaignStatusChanges(@PathVariable("id") String id) {
		long start = System.currentTimeMillis();
		List<CampaignStatusChange> l =  allianzservice.getCampaignStatusChanges(id);
		long end = System.currentTimeMillis();
		if(end-start>5)
			System.out.println("işlem " + (end-start) + "Milisaniye sürdü");
		return l;
      
	}

}
