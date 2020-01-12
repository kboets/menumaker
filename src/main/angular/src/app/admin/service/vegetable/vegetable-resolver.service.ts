import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {IVegetable, IVegetableResolved} from "../../model/vegetable";
import {Observable, of} from "rxjs";
import {VegetableService} from "./vegetable.service";
import {catchError, map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class VegetableResolverService implements Resolve<IVegetableResolved> {

  constructor(private vegetableService: VegetableService) {

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IVegetableResolved> {
    const id = route.paramMap.get('id')
    if (isNaN(+id)) {
      const message = `Vegetable id was not a number: ${id}`;
      console.log(message);
      return of({vegetable:null, error:message});
    }
    return this.vegetableService.getVegetableById(+id)
      .pipe(
        map(vegetable => ({vegetable:vegetable})),
        catchError(err => {
          const message = `Retrieve vegetable error: ${err}`;
          console.error(message);
          return of({vegetable:null, error:message});
        })
      );
  }
}
