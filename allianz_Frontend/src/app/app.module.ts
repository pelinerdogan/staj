import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddCampaignComponent } from './add-campaign/add-campaign.component';
import { CampaignCompComponent } from './campaign-comp/campaign-comp.component';
import { CampaigndetailComponent } from './campaigndetail/campaigndetail.component';
import { ShowcampaignsComponent } from './showcampaigns/showcampaigns.component';
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule
import { AllianzServiceService } from './allianz-service.service';
import { FormsModule } from '@angular/forms';
import { NavigationcompComponent } from './navigationcomp/navigationcomp.component';
import { SearchcompComponent } from './searchcomp/searchcomp.component';
import { SearchresultsComponent } from './searchresults/searchresults.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddCampaignComponent,
    CampaignCompComponent,
    CampaigndetailComponent,
    ShowcampaignsComponent,
    NavigationcompComponent,
    SearchcompComponent,
    SearchresultsComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AllianzServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
