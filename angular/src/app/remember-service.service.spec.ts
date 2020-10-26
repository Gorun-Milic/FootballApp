import { TestBed } from '@angular/core/testing';

import { RememberServiceService } from './remember-service.service';

describe('RememberServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RememberServiceService = TestBed.get(RememberServiceService);
    expect(service).toBeTruthy();
  });
});
