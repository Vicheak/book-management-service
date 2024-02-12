package com.vicheak.borrow.borrowservice.service.impl;

import com.vicheak.borrow.borrowservice.dto.BorrowerDto;
import com.vicheak.borrow.borrowservice.dto.BorrowerResponseDto;
import com.vicheak.borrow.borrowservice.entity.Borrower;
import com.vicheak.borrow.borrowservice.mapper.BorrowerMapper;
import com.vicheak.borrow.borrowservice.repository.BorrowerRepository;
import com.vicheak.borrow.borrowservice.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;
    private final BorrowerMapper borrowerMapper;

    @Override
    public List<BorrowerResponseDto> loadAllBorrowers() {
        return borrowerMapper.toBorrowerResponseDto(borrowerRepository.findAll());
    }

    @Override
    public void createNewBorrower(BorrowerDto borrowerDto) {
        Borrower borrower = borrowerMapper.toBorrower(borrowerDto);
        borrower.setJoinDate(LocalDateTime.now());
        borrowerRepository.save(borrower);
    }

}
