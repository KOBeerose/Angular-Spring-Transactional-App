import { AvatarModule } from 'ngx-avatar';
import { UserProfileComponent } from './../../pages/user-profile/user-profile.component';
import { AddImmobilierComponent } from './../../pages/add-immobilier/add-immobilier.component';
import { MyImmobilierComponent } from './../../pages/my-immobilier/my-immobilier.component';
import { ImmobiliersForSaleComponent } from './../../pages/immobiliers-for-sale/immobiliers-for-sale.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [
    ImmobiliersForSaleComponent,
    MyImmobilierComponent,
    UserProfileComponent,
      AddImmobilierComponent    
  ],
  imports: [
    CommonModule,
    AvatarModule
  ]
})
export class UserLayoutModule { }
