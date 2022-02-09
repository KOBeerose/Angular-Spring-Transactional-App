import { ContractServiceService } from './../../services/contract-service.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { ImmobilierAnn } from 'src/app/model/immobilier-ann';
import { Immobilier } from 'src/app/model/immobilier';
import { transaction } from 'src/app/model/transaction';
@Component({
  selector: 'app-my-immobilier',
  templateUrl: './my-immobilier.component.html',
  styleUrls: ['./my-immobilier.component.scss']
})
export class MyImmobilierComponent implements OnInit {

  public Immobiliers: any[];
  constructor(private modalService: NgbModal,private route: Router,private contractService : ContractServiceService) { }

  ngOnInit(): void {
    this.contractService.myImmobilier(localStorage.getItem('useraddress')).subscribe((res:any)=>{
      this.Immobiliers = res;
      this.Immobiliers = this.Immobiliers.filter(Immobilier => Immobilier);
      console.log(this.Immobiliers);
    });
  }

  ImmobilierAnn:ImmobilierAnn=new ImmobilierAnn();
  Imm:Immobilier=new Immobilier();
  transaction:transaction=new transaction();
  closeResult: string="";
  privateKey:string="imane";
  Buy(p: any) {
    this.Imm=p;
    this.ImmobilierAnn.ownerAddress=p.addressOwner;
    this.ImmobilierAnn.titre=p.titer;
    this.ImmobilierAnn.price=p.price;
    console.log("gggggggggggggggggggggg"+p);
    console.log("addresssss owner"+this.ImmobilierAnn.ownerAddress);
    this.ImmobilierAnn.recipentAddress=localStorage.getItem('useraddress');
    console.log(this.ImmobilierAnn);
  }
  transfertImmobilier(){
    this.transaction.addressOwner=this.Imm.addressOwner;
    this.transaction.priceTran=this.ImmobilierAnn.price;
    this.transaction.addressrecipent=this.ImmobilierAnn.recipentAddress;
    
    // this.contractService.TransferImmobilier(this.ImmobilierAnn).subscribe(res=>{
    //   if(res==false){
    //     console.log("transaction Impossible");
    //   }
    //   else{
    //     this.contractService.ChangeOwner(this.Imm.Id,this.ImmobilierAnn.recipentAddress).subscribe(
    //       res=>{
    //         console.log(res);
    //       }
    //     );
    //     this.contractService.AddTransaction(this.Imm.Id,this.transaction).subscribe(res=>{
    //       console.log("traansaaaaaaactionnnnn");
    //       console.log(res);
    //     });
    //     console.log("transaction terminé");
    //   }
    // });
    console.log("priivaaaaate: "+this.ImmobilierAnn.recipentPrivateKey);
  }  
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
}
