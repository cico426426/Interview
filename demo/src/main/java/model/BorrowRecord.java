package model;

import java.sql.Timestamp;

public class BorrowRecord {
    private int userId;
    private int inventoryId;
    private Timestamp borrowTime;
    private Timestamp returnTime;

    public BorrowRecord(
            int userId,
            int inventoryId,
            Timestamp borrowTime,
            Timestamp returnTime){
        this.userId = userId;
        this.inventoryId = inventoryId;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
    }

}
