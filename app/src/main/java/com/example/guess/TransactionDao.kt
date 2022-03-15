package com.example.guess

import androidx.room.*

// 需要標示他是 Dao
@Dao
interface TransactionDao {
    @Query("select * from `Transaction` where id = :id")
    fun getById(id: Int) : Transaction

    @Query("select * from `Transaction` ORDER BY createAt DESC")
    fun getAll() : List<Transaction>

    // 當 primary key 衝突時，我們想要處理的方法
    // 此例子是 Replace，相當於更新
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tran: Transaction)
    @Delete
    fun delete(tran: Transaction)
    @Update
    fun update(tran: Transaction)
}