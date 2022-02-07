import { ContractServiceService } from './../../services/contract-service.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-immobiliers-for-sale',
  templateUrl: './immobiliers-for-sale.component.html',
  styleUrls: ['./immobiliers-for-sale.component.scss']
})
export class ImmobiliersForSaleComponent implements OnInit {


  public Immobiliers: any[];
  constructor(private route: Router,private contractService : ContractServiceService) { }

  ngOnInit(): void {
    this.contractService.ImmobilierForSale().subscribe((res:any)=>{
      this.Immobiliers = res;
      this.Immobiliers = this.Immobiliers.filter(Immobilier => Immobilier);
      console.log(this.Immobiliers);
    });
  }

}
