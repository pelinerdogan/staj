import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCampaignComponent } from './add-campaign/add-campaign.component';
import { CampaigndetailComponent } from './campaigndetail/campaigndetail.component';
import { ShowcampaignsComponent } from './showcampaigns/showcampaigns.component';
import { HomeComponent } from './home/home.component';
import { SearchresultsComponent } from './searchresults/searchresults.component';
const routes: Routes = [
  {path:'add',component: AddCampaignComponent},
  { path: 'details/:id', component: CampaigndetailComponent },
  {path:'show',component: ShowcampaignsComponent},
  {path:'',component: HomeComponent},
  {path:'search',component: SearchresultsComponent},

  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
