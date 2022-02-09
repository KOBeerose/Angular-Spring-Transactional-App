import { ActivatedRoute, Router } from '@angular/router';

import { Component, OnInit } from '@angular/core';
import { ContractServiceService } from '../../services/contract-service.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-modify-immobilier',
  templateUrl: './modify-immobilier.component.html',
  styleUrls: ['./modify-immobilier.component.scss']
})
export class ModifyImmobilierComponent implements OnInit {
  form: FormGroup
  constructor(private Formbuilder: FormBuilder, private contractService: ContractServiceService,private route: ActivatedRoute, private router: Router) { }
  
  ngOnInit() {
    this.route.params.subscribe( params =>  {
    this.form = this.Formbuilder.group({
      id: params['id'],
      titre: "",
      ville: "",
      price: "",
      surface: "",
      picture: "",
    });
  })
  }
  register() {
    const data = {
      addressOwner: localStorage.getItem("useraddress"),
      titre: this.form.getRawValue().titre,
      ville: this.form.getRawValue().ville,
      price: this.form.getRawValue().price,
      surface: this.form.getRawValue().surface,
      image: "./assets/img/immobilier/image17.jfif",
      isAnnounced: 1,
    }
    ;
    this.contractService.ModifyImm(this.form.getRawValue().id, data).subscribe(res => {
      console.log(res);
      this.router.navigateByUrl("/User/MyImmobiliers");
      });

  }


}
