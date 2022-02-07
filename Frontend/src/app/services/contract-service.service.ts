import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContractServiceService {
  // host2: string = "http://127.0.0.1:9999/CONTRACT-SERVICE";
  host2: string = "http://127.0.0.1:8088";
  
  constructor(private http: HttpClient) { }

  Immobiliers() {
    return this.http.get(this.host2 + "/immobiliers", { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
  ImmobilierDetails(id) {
    return this.http.get(this.host2 + `/immobillierDetails/${id}`, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
  ImmobilierForSale() {
    return this.http.get(this.host2 + `/immobilier/listVisibleImmobilier`);
  }
  myImmobilier() {
    return this.http.get(this.host2 + `/myImmobiliers`, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
}
