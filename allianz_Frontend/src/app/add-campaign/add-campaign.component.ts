import { Component } from '@angular/core';
import { Campaign } from '../campaign';
import { AllianzServiceService } from '../allianz-service.service';

@Component({
  selector: 'app-add-campaign',
  templateUrl: './add-campaign.component.html',
  styleUrls: ['./add-campaign.component.css']
})
export class AddCampaignComponent {
  camp: Campaign = { name: '', detail: '', category: '' ,id : '', status: '' ,mukerrer : false};
  formData = { name: '', detail: '', category: '' }; 
  constructor(private apiService: AllianzServiceService) {}

    

  submitForm(): void {

    this.formData.name=this.camp.name;
    this.formData.detail=this.camp.detail;
    this.formData.category=this.camp.category;
    

    this.apiService.addCampaign(this.formData).subscribe(
    (response) => {
       console.log('Campaign added:', response);
       window.location.reload();
        
     },
      (error) => {
        console.error('Error adding campaign:', error);
     }
     );
     
  }
  
}
