package model;

import java.sql.Time;
import java.sql.Timestamp;

public class Inventory {
    private int inventoryId;
    private int isbn;
    private Timestamp storeTime;
    private InventoryStatus status;

    public Inventory(
            int inventoryId,
            int isbn,
            Timestamp storeTime,
            InventoryStatus status){
        this.inventoryId = inventoryId;
        this.isbn = isbn;
        this.storeTime = storeTime;
        this.status = status;
    }

    public enum InventoryStatus {
        IN_STOCK("在庫"),
        BORROWED("出借中"),
        ORGANIZING("整理中(歸還後未入庫)"),
        LOST("遺失"),
        DAMAGED("損毀"),
        DISCARDED("廢棄");

        private final String status;

        InventoryStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return this.status;
        }
    }
}
