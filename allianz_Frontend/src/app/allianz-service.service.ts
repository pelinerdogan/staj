import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Campaign } from './campaign'; // Import the Campaign interface if defined in a separate file
import { Statesofcampaign } from './statesofcampaign';

@Injectable({
  providedIn: 'root'
})
export class AllianzServiceService {

  private baseUrl = 'http://localhost:8080/api/v1/allianz';

  constructor(private http: HttpClient) { }

  // Get a list of campaigns
  getCampaigns(): Observable<Campaign[]> {
    return this.http.get<Campaign[]>(`${this.baseUrl}`);
  }

  // Activate a campaign with the given id
  activateCampaign(id: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/activate/${id}`, {});
  }

  // Deactivate a campaign with the given id
  deactivateCampaign(id: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/deactivate/${id}`, {});
  }

  // Add a new campaign
  addCampaign(formData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, formData);
  }

  // Get statistics of the database as a string
  getStatistics(): Observable<any> {
    return this.http.get(`${this.baseUrl}/dashboard/classifieds/statistic`);
    
  }

  

  // Get state changes of a campaign with the given id
  getStateChanges(id: string): Observable<Statesofcampaign[]> {
    return this.http.get<Statesofcampaign[]>(`${this.baseUrl}/stateChanges/${id}`);
  }

  getCampaignById(id:string):Observable<Campaign>{
    return this.http.get<Campaign>(`${this.baseUrl}/details/${id}`);
  }
}
