CREATE DEFINER=`root`@`localhost` PROCEDURE `BorrowBook`(IN _userID INT, IN _inventoryID INT)
BEGIN
	 DECLARE _status ENUM('在庫', '出借中', '整理中', '遗失', '损毁', '廢棄');
    
    -- 檢查圖書狀態是否為“在庫”
    SELECT status INTO _status FROM inventory WHERE inventory_id = _inventoryID;
    IF _status = '在庫' THEN
        -- 開始交易
        START TRANSACTION;
        
        -- 更新庫存狀態為“出借中”
        UPDATE inventory SET status = '出借中' WHERE inventory_id = _inventoryID;
        
        -- 新增借書記錄
        INSERT INTO borrow_record (user_id, inventory_id, borrow_time, return_time)
        VALUES (_userID, _inventoryID, NOW(), NULL);
        
        -- 提交
        COMMIT;
    ELSE
        -- 如果圖書不可藉，拋出錯誤
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = '圖書不可借用或不存在。';
    END IF;
END