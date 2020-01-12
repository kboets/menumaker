import {Component, OnInit} from "@angular/core";
import * as _ from 'underscore';
import {IVegetable} from "../../model/vegetable";
import {ActivatedRoute} from "@angular/router";
import {IngredientError} from "../../model/ingredientError";

@Component({
  templateUrl: '../../vegetables-overview.html'
})
export class VegetablesComponent implements OnInit {

  vegetables: IVegetable[] = [];
  filteredVegetables: IVegetable[] = [];
  vegetablesKeys: string [] = [];
  selectedVegetableKey:string;
  all:string = "Alles";
  errors : IngredientError;

  constructor(private route: ActivatedRoute) { }

  changeType(vegetableKey:string) {
    if(vegetableKey == this.all) {
      this.filteredVegetables = this.vegetables;
    } else {
      this.filteredVegetables = _.where(this.vegetables, {type:vegetableKey});
    }

  }

  ngOnInit(): void {
    const resolvedData: IVegetable[] | IngredientError = this.route.snapshot.data['vegetables'];
    if (resolvedData instanceof IngredientError) {
      this.errors = resolvedData;
    } else {
      this.initVegetablesKeys(resolvedData);
    }
  }

  initVegetablesKeys(vegetablesList:IVegetable[]) {
    this.vegetables = vegetablesList;
    let vegetablesByType = _.groupBy(this.vegetables,"type");
    this.vegetablesKeys = _.allKeys(vegetablesByType);
    this.vegetablesKeys.push(this.all);
    this.filteredVegetables = this.vegetables;
  }
}
