import { ContractServiceService } from './../../services/contract-service.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-immobilier-details',
  templateUrl: './immobilier-details.component.html',
  styleUrls: ['./immobilier-details.component.scss']
})
export class ImmobilierDetailsComponent implements OnInit {
  id;
  Immobilier: any;

  constructor(private route: ActivatedRoute,private contractService : ContractServiceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.contractService.ImmobilierDetails(this.id).subscribe(res => {
      this.Immobilier = res;
      console.log(this.Immobilier);
    });

  }

}
