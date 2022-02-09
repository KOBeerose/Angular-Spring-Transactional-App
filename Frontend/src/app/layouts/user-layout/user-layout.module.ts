import { AvatarModule } from 'ngx-avatar';
import { UserProfileComponent } from './../../pages/user-profile/user-profile.component';
import { AddImmobilierComponent } from './../../pages/add-immobilier/add-immobilier.component';
import { ModifyImmobilierComponent } from './../../pages/modify-immobilier/modify-immobilier.component';
import { MyImmobilierComponent } from './../../pages/my-immobilier/my-immobilier.component';
import { ImmobiliersForSaleComponent } from './../../pages/immobiliers-for-sale/immobiliers-for-sale.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  imports: [
    CommonModule,
    AvatarModule,
    CommonModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule
  ],
  declarations: [
    ImmobiliersForSaleComponent,
    MyImmobilierComponent,
    UserProfileComponent,
    AddImmobilierComponent,
    ModifyImmobilierComponent
  ]

})
export class UserLayoutModule { }
