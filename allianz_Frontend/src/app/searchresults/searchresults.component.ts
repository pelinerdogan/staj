import { Component, OnInit } from '@angular/core';
import { AllianzServiceService } from '../allianz-service.service';
import { ActivatedRoute } from '@angular/router';
import { Campaign } from '../campaign';

@Component({
  selector: 'app-searchresults',
  templateUrl: './searchresults.component.html',
  styleUrls: ['./searchresults.component.css']
})
export class SearchresultsComponent implements OnInit {
  constructor(private campaignService: AllianzServiceService, private route: ActivatedRoute) { }

  campaigns: Campaign[] = [];
  filteredCampaigns: Campaign[] = [];
  query: string = '';

  campaignStatistics: any = {}; // Initialize with an empty object

 
  ngOnInit() {
    this.campaignService.getCampaigns().subscribe(
      (campaigns: Campaign[]) => {
        this.campaigns = campaigns;
        this.filteredCampaigns = campaigns;
      },
      (error) => {
        console.error('Error fetching campaigns:', error);
      }
    );
   

    this.route.queryParams.subscribe((params) => {
      this.query = params['query'] || ''
      this.filteredCampaigns = this.campaigns.filter((camp) =>
      camp.name.toLowerCase().includes(this.query.toLowerCase())
    );
    });
  }
}
