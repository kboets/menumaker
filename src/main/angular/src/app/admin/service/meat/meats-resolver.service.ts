import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {IngredientError} from "../../model/ingredientError";
import {IMeat} from "../../model/meat";
import {MeatService} from "./meat.service";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class MeatsResolverService implements Resolve<IMeat[] | IngredientError>{

  constructor(private meatService: MeatService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IMeat[] | IngredientError> {
    return this.meatService.getAllMeat();
  }

}
