import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { UserLayoutComponent } from './layouts/user-layout/user-layout.component';
import { ForbiddenComponent } from './pages/forbidden/forbidden.component';
import { MyImmobilierComponent } from './pages/my-immobilier/my-immobilier.component';
import { AddImmobilierComponent } from './pages/add-immobilier/add-immobilier.component';


@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule,
    ReactiveFormsModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
  ],
    declarations: [
      AppComponent,
      AdminLayoutComponent,
      AuthLayoutComponent,
      UserLayoutComponent,
      ForbiddenComponent,
      
        ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
