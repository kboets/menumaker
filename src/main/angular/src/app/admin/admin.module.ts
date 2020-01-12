import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {VegetablesComponent} from "./components/vegetable/vegetables.component";
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {VegetablesDetailComponent} from "./components/vegetable/vegetables-detail.component";
import {VegetableResolverService} from "./service/vegetable/vegetable-resolver.service";
import {VegetablesResolverService} from "./service/vegetable/vegetables-resolver.service";
import { MeatComponent } from './components/meat/meat.component';



@NgModule({
  declarations: [
    VegetablesComponent,
    VegetablesDetailComponent,
    MeatComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild([
      {path: 'vegetables',
        component: VegetablesComponent,
        resolve: {vegetables:VegetablesResolverService}
      },
      {path: 'vegetables/:id/read',
        component: VegetablesDetailComponent,
        resolve: {resolvedData:VegetableResolverService}
       },
      {path: 'vegetables/:id/edit',
        component: VegetablesDetailComponent,
        resolve: {resolvedData:VegetableResolverService}
      }
    ]),
    ReactiveFormsModule
  ]
})
export class AdminModule { }
