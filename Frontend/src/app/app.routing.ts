import { AddImmobilierComponent } from './pages/add-immobilier/add-immobilier.component';
import { ModifyImmobilierComponent } from './pages/modify-immobilier/modify-immobilier.component';
import { MyImmobilierComponent } from './pages/my-immobilier/my-immobilier.component';
import { ImmobilierDetailsComponent } from './pages/immobilier-details/immobilier-details.component';
import { ForbiddenComponent } from './pages/forbidden/forbidden.component';
import { ImmobiliersForSaleComponent } from './pages/immobiliers-for-sale/immobiliers-for-sale.component';
import { UserLayoutComponent } from './layouts/user-layout/user-layout.component';
import { ApprouveAccountComponent } from './pages/approuve-account/approuve-account.component';
import { TablesComponent } from './pages/tables/tables.component';
import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';
import { IconsComponent } from './pages/icons/icons.component';
import { MapsComponent } from './pages/maps/maps.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';

const routes: Routes = [
  {path: '',redirectTo: "/User/ImmobiliersForSale",pathMatch:"full" },
  {
    path: 'Admin',
    component: AdminLayoutComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'profile', component: UserProfileComponent },
      { path: 'tables', component: TablesComponent },
      { path: 'Immobiliers', component: TablesComponent },
      { path: 'ImmobilierDetails/:id', component: ImmobilierDetailsComponent }
    ]
  },
  {
    path: 'Auth',
    component: AuthLayoutComponent,
    children: [
      { path: 'login', component: LoginComponent },
      { path: 'approuveAccount', component: ApprouveAccountComponent },
      { path: 'register', component: RegisterComponent }

    ]
  },
  {
    path: 'User',
    component: UserLayoutComponent,
    children: [

      { path: 'ImmobiliersForSale', component: ImmobiliersForSaleComponent },
      { path: 'profile', component: UserProfileComponent },
      { path: 'tables', component: TablesComponent },
      { path: 'MyImmobiliers', component: MyImmobilierComponent },
      { path: 'AddImmobilier', component: AddImmobilierComponent },
      { path: 'user-profile', component: UserProfileComponent },
      { path: 'forbidden', component: ForbiddenComponent },
      { path: 'ModifyImmobilier', component: ModifyImmobilierComponent },
      { path: 'ModifyImmobilier/:id', component: ModifyImmobilierComponent }
    ]
  }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes)],
  exports: [
    [RouterModule]
  ],
})
export class AppRoutingModule { }
