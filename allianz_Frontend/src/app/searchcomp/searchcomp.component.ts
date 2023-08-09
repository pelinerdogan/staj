import { Component ,EventEmitter,Input,Output} from '@angular/core';
import { Campaign } from '../campaign';
import { CampaignCompComponent } from '../campaign-comp/campaign-comp.component';
import { Router } from '@angular/router';
import { AllianzServiceService } from '../allianz-service.service';
@Component({
  selector: 'app-searchcomp',
  templateUrl: './searchcomp.component.html',
  styleUrls: ['./searchcomp.component.css']
})
export class SearchcompComponent {
  @Output() searchEvent: EventEmitter<string> = new EventEmitter<string>();

  constructor(private router: Router) { }
 
  searchQuery: string = '';
  filteredCampaigns!: Campaign[];
  showAllCampaigns: boolean = true;
 
  onSearch(query: string) {
  
  
    this.router.navigate(['/search'], { queryParams: { query: query } });
   
  }
  
}
