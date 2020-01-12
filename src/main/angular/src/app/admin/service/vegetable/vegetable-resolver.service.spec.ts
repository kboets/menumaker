import { TestBed } from '@angular/core/testing';

import { VegetableResolverService } from './vegetable-resolver.service';

describe('VegetableResolverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VegetableResolverService = TestBed.get(VegetableResolverService);
    expect(service).toBeTruthy();
  });
});
