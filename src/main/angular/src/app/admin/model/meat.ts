export interface IMeat {
  meatId: string;
  name: string;
  type: string;
  imageUrl: string;
  meatOriginDtos : IMeatOrigin[];
}


export interface IMeatOrigin {
  meatOriginId: string;
  animal: string;
}
