package com.example.ragistrationform.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.ragistrationform.DataClass.UserList

val dbName = "Form"
val dbVersion = 1

val table2 = "LoginData"
val t2column1 = "Username"

val tableName = "FormData"
val column0 = "sno"
val column1 = "Name"
val column2 = "Contact"
val column3 = "DOB"
val column4 = "Address"
val column5 = "Mail"
val column6 = "Aadhar"
val column7 = "Pan"
val column8 = "Gender"
val column9 = "Course"
val column10 = "Image"

class DbHelper(val context: Context) :SQLiteOpenHelper(context,dbName,null,dbVersion){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE $tableName ($column0 INTEGER PRIMARY KEY AUTOINCREMENT, $column1 TEXT ,$column2 TEXT,$column3 TEXT,$column4 TEXT,$column5 TEXT,$column6 TEXT,$column7 TEXT,$column8 TEXT,$column9 TEXT,$column10 TEXT)"
        db!!.execSQL(query)
        val query2 = "CREATE TABLE $table2 ($t2column1 TEXT)"
        db.execSQL(query2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(name:String, contact:String, dob:String, address:String, mail:String, aadhar:String, pan:String, gen:String, course:String ,image :String){
        val value = ContentValues()
        value.put(column1,name)
        value.put(column2,contact)
        value.put(column3,dob)
        value.put(column4,address)
        value.put(column5,mail)
        value.put(column6,aadhar)
        value.put(column7,pan)
        value.put(column8,gen)
        value.put(column9,course)
        value.put(column10,image)

        val db = this.writableDatabase
        val rowid:Long = db.insert(tableName,null,value)
        if(rowid>0){
            Toast.makeText(context,"Succesfully Added!!", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context,"Something went wrong", Toast.LENGTH_SHORT).show()

        }

    }
    //insert ragistered username
    fun insertLoginData(username:String){
        val value = ContentValues()
        value.put(t2column1,username)
        val db = this.writableDatabase
        val rowid:Long = db.insert(table2,null,value)
        if(rowid>0){
            Toast.makeText(context,"ragistered Succesfully!!", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context,"Something went wrong", Toast.LENGTH_SHORT).show()

        }
    }
    fun getRagisteredData(name:String):String{
//       val cursor : Cursor =
        val db = this.writableDatabase
       val cursor:Cursor =  db.rawQuery("SELECT $t2column1 FROM $table2 WHERE $t2column1 = ?", arrayOf(name))
       cursor.moveToFirst()
        var rgName:String? = null
        do{
            rgName = cursor.getString(0)
        }while(cursor.moveToNext())
        return rgName?:""
    }
    fun getAllData():List<UserList>{
        var list = mutableListOf<UserList>()
        val db = this.writableDatabase
        val cursor:Cursor = db.query(tableName,null,null,null,null,null,null)
        if(cursor.count > 0){
            cursor.moveToFirst()
            do{
                var sno = cursor.getString(0)
                var name = cursor.getString(1)
               var contact = cursor.getString(2)
               var dob = cursor.getString(3)
               var address = cursor.getString(4)
               var email = cursor.getString(5)
               var aadhar = cursor.getString(6)
               var pan = cursor.getString(7)
               var gender = cursor.getString(8)
               var courses = cursor.getString(9)
                var image = cursor.getString(10)
                list.add(UserList(sno,name,contact,dob,address, email, aadhar, pan, gender, courses, image))
            }while (cursor.moveToNext())
        }
        else{
            Toast.makeText(context,"no data found",Toast.LENGTH_SHORT).show()
        }
        return list
    }

}