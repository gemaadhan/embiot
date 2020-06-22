package com.gemaadhan.embiot.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_overtime")
data class OvertimeEntity (
    @PrimaryKey(autoGenerate = true)
    var overtimeId: Long = 0L,

    @ColumnInfo(name = "tanggal")
    var date: String = "",

    @ColumnInfo(name = "waktu_mulai")
    var starttime: String = date,

    @ColumnInfo(name = "waktu_selesai")
    var stoptime: String = date,

    @ColumnInfo(name = "keterangan_pekerjaan")
    var job: String = "Standby",

    @ColumnInfo(name = "customer")
    var customer: String = "",

    @ColumnInfo(name = "bayaran")
    var pay: Long = 100000L
)