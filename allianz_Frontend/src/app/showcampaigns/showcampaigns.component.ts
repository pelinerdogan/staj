import { Component } from '@angular/core';
import { Campaign } from '../campaign';
import { AllianzServiceService } from '../allianz-service.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-showcampaigns',
  templateUrl: './showcampaigns.component.html',
  styleUrls: ['./showcampaigns.component.css']
})
export class ShowcampaignsComponent {
  
 
  constructor(private campaignService: AllianzServiceService, private route: ActivatedRoute) { }

  campaigns: Campaign[] = [];
  filteredCampaigns: Campaign[] = [];
  query: string = '';

  campaignStatistics: any = {}; // Initialize with an empty object

 
  ngOnInit() {
    this.getCampaigns();
    this.campaignService.getStatistics().subscribe(
      (response) => {
        this.campaignStatistics = response;
    
      },
      (error) => {
        console.error('Error fetching campaign statistics:', error);
      }
    );

  
  }

  getCampaigns() {
    this.campaignService.getCampaigns().subscribe(
      (campaigns: Campaign[]) => {
        this.campaigns = campaigns;
        this.filteredCampaigns = campaigns;
      },
      (error) => {
        console.error('Error fetching campaigns:', error);
      }
    );
  }

  
}
