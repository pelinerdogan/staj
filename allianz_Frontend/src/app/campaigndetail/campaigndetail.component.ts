import { Component, OnInit, inject } from '@angular/core';
import { Campaign } from '../campaign';
import { ActivatedRoute } from '@angular/router';

import { AllianzServiceService } from '../allianz-service.service';
import { Statesofcampaign } from '../statesofcampaign';
@Component({
  selector: 'app-campaigndetail',
  templateUrl: './campaigndetail.component.html',
  styleUrls: ['./campaigndetail.component.css']
})
export class CampaigndetailComponent implements OnInit  {
  campaign!: Campaign ;
  showStateChanges = false;
  statechanes : Statesofcampaign[]=[];
campaignId: string | null = null;// Create a variable to hold the campaign id


constructor(private campaignService: AllianzServiceService, private route: ActivatedRoute) { }
ngOnInit(): void {
  this.route.paramMap.subscribe(params => {
    const campaignId = params.get('id');
    if (campaignId) {
      this.getCampaignDetails(campaignId);
    }
  });
}

getCampaignDetails(id: string): void {
  this.campaignService.getCampaignById(id)
    .subscribe(campaign => {
      this.campaign = campaign;
    });
}

deactivateCampaign(): void {
  if (this.campaign) {
    this.campaignService.deactivateCampaign(this.campaign.id)
      .subscribe(updatedCampaign => {
        this.campaign = updatedCampaign;
        window.location.reload();
        
      });
  }
}

activateCampaign(): void {
  if (this.campaign) {
    this.campaignService.activateCampaign(this.campaign.id)
      .subscribe(updatedCampaign => {
        this.campaign = updatedCampaign;
        window.location.reload();

      });
  }

}
toggleStateChangeButtons(): void {
  this.showStateChanges = !this.showStateChanges;
  this.campaignService.getStateChanges(this.campaign.id).subscribe(statechange => {
    this.statechanes = statechange;
  });
  
}

}
