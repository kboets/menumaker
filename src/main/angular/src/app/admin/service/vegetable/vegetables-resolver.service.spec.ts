import { TestBed } from '@angular/core/testing';

import { VegetablesResolverService } from './vegetables-resolver.service';

describe('VegetablesResolverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VegetablesResolverService = TestBed.get(VegetablesResolverService);
    expect(service).toBeTruthy();
  });
});
