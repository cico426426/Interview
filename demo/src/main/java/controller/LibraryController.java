package controller;

import dto.BorrowReturnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.LibraryService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestBody BorrowReturnRequest borrowRequest) {
        libraryService.borrowBook(borrowRequest.getUserId(), borrowRequest.getInventoryId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestBody BorrowReturnRequest returnRequest) {
        libraryService.returnBook(returnRequest.getUserId(), returnRequest.getInventoryId());
        return ResponseEntity.ok().build();
    }
}
