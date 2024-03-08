package repository;

import model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
    @Procedure(name="BorrowBook")
    void borrowBook(@Param("user_id_in") Integer userId, @Param("inventory_id_in") Integer inventoryId);
    @Procedure(name = "ReturnBook")
    void returnBook(@Param("user_id_in") Integer userId, @Param("inventory_id_in") Integer inventoryId);
}
