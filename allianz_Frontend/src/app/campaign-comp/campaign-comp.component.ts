import { Component ,Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import { Campaign } from '../campaign';
import { Router } from '@angular/router';
@Component({
  selector: 'app-campaign-comp',
  templateUrl: './campaign-comp.component.html',
  styleUrls: ['./campaign-comp.component.css']
})
export class CampaignCompComponent {
  @Input() camp!: Campaign; 
  constructor(private router: Router) {}

  navigateToDetails(campaignId: string): void {
    this.router.navigate(['/details', campaignId]);
  }
}
