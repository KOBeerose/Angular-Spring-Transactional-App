import { ContractServiceService } from './../../services/contract-service.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.scss']
})
export class TablesComponent implements OnInit {

  constructor(private router:Router,private contractService : ContractServiceService) { }

  Immobiliers ;

  ngOnInit() {
    if (localStorage.getItem("Role") != "0") {
      this.router.navigateByUrl("/User/forbidden");
    }

    this.contractService.Immobiliers().subscribe((res:any)=>{
      this.Immobiliers = res;
      console.log(res);
    });


  }





}
