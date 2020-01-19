import { Component, OnInit } from '@angular/core';
import {IMeat} from "../../model/meat";
import {ActivatedRoute} from "@angular/router";
import {IngredientError} from "../../model/ingredientError";

@Component({
  templateUrl: '../../meat-overview.html'
})
export class MeatComponent implements OnInit {

  meatList: IMeat[] = [];
  error : IngredientError;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    const resolvedData : IMeat[] | IngredientError =  this.route.snapshot.data['meats'];
    if (resolvedData instanceof IngredientError) {
      this.error = resolvedData;
    } else {
      this.meatList = resolvedData;
    }
  }

}
