import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {Header} from "./layout/header";
import {Footer} from "./layout/footer";
import {WelcomeComponent} from './welcome/welcome.component';
import {PageNotFoundComponent} from './page-not-found.component';
import {AdminModule} from "./admin/admin.module";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CacheInterceptor} from "./CacheInterceptor";


@NgModule({
  declarations: [
    AppComponent,
    Header,
    Footer,
    WelcomeComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AdminModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: CacheInterceptor, multi: true}
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
