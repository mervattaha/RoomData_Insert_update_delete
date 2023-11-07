package com.example.roomdata_insert_update_delete.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User (
    @PrimaryKey(autoGenerate = true) val id: Int ,
    val user_Name: String,
    val email :String,
    val user_Password: Int,

)
