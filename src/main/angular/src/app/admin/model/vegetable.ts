export interface IVegetable {
  vegetableId: string;
  name: string;
  type: string;
  info: string;
  imageUrl: string;
}


export interface IVegetableResolved {
  vegetable:IVegetable;
  error?:any;
}


