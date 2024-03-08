package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BorrowRecordRepository;

@Service
public class LibraryService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public void borrowBook(Integer userId, Integer inventoryId) {
        borrowRecordRepository.borrowBook(userId, inventoryId);
        // Additional logic if required
    }

    public void returnBook(Integer userId, Integer inventoryId) {
        borrowRecordRepository.returnBook(userId, inventoryId);
        // Additional logic if required
    }
}
