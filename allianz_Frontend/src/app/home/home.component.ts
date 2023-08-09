import { Component ,EventEmitter,Input,Output} from '@angular/core';
import { Campaign } from '../campaign';
import { CampaignCompComponent } from '../campaign-comp/campaign-comp.component';
import { Router } from '@angular/router';
import { AllianzServiceService } from '../allianz-service.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(private router: Router) { }
  
  
}