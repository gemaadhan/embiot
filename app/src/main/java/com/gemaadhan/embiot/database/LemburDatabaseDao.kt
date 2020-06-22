package com.gemaadhan.embiot.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LemburDatabaseDao {

    @Insert
    fun insert(overtime: OvertimeEntity)

    @Update
    fun update(overtime: OvertimeEntity)

    @Query("SELECT * from tabel_overtime WHERE overtimeId =:key")
    fun get(key: Long): OvertimeEntity

    @Query("DELETE FROM tabel_overtime WHERE overtimeId =:key")
    fun delrecord(key: Long)

    @Query("DELETE FROM tabel_overtime")
    fun delAll()

    @Query("SELECT * FROM tabel_overtime ORDER BY overtimeId DESC")
    fun getAllOvertime(): LiveData<List<OvertimeEntity>>

    @Query("SELECT * FROM tabel_overtime ORDER BY overtimeId DESC LIMIT 1")
    fun getOvertime(): OvertimeEntity?

}