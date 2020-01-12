import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {IVegetable} from "../../model/vegetable";
import {Observable} from "rxjs";
import {VegetableService} from "./vegetable.service";
import {IngredientError} from "../../model/ingredientError";

@Injectable({
  providedIn: 'root'
})
export class VegetablesResolverService implements Resolve<IVegetable[] | IngredientError>{

  constructor(private vegetableService: VegetableService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IVegetable[] | IngredientError> {
    return this.vegetableService.getAllVegetables();
  }
}
