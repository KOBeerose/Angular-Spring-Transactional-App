import { TestBed } from '@angular/core/testing';

import { ContractServiceService } from './contract-service.service';

describe('ContractServiceService', () => {
  let service: ContractServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContractServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
