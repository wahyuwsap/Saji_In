//package com.saji_in.db
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import com.saji_in.model.FoodItem
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import android.database.Cursor
//
//
//class FoodDatabaseHelper(context: Context) :
//    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
//
//    companion object {
//        private const val DATABASE_NAME = "food_db"
//        private const val DATABASE_VERSION = 1
//        const val TABLE_NAME = "food_items"
//    }
//
//    override fun onCreate(db: SQLiteDatabase) {
//        val createTable = """
//            CREATE TABLE $TABLE_NAME (
//                id INTEGER PRIMARY KEY AUTOINCREMENT,
//                title TEXT,
//                category TEXT,
//                imageResId INTEGER,
//                cookTime TEXT,
//                description TEXT,
//                ingredients TEXT,
//                instructions TEXT,
//                isLoved INTEGER DEFAULT 0
//            )
//        """.trimIndent()
//        db.execSQL(createTable)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
//        onCreate(db)
//    }
//
//    fun insertFoodItem(item: FoodItem): Long {
//        val db = writableDatabase
//        val values = ContentValues().apply {
//            put("title", item.title)
//            put("category", item.category)
//            put("imageResId", item.imageResId)
//            put("cookTime", item.cookTime)
//            put("description", item.description)
//            put("ingredients", Gson().toJson(item.ingredients))
//            put("instructions", item.instructions)
//            put("isLoved", if (item.isLoved) 1 else 0)
//        }
//        return db.insert(TABLE_NAME, null, values)
//    }
//
//    fun getFoodItemsByCategory(category: String): List<FoodItem> {
//        val db = readableDatabase
//        val cursor = db.query(
//            TABLE_NAME, null, "category = ?",
//            arrayOf(category), null, null, null
//        )
//
//        val list = mutableListOf<FoodItem>()
//        with(cursor) {
//            while (moveToNext()) {
//                list.add(extractFoodItem(this))
//            }
//            close()
//        }
//        return list
//    }
//
//    fun getLovedItems(): List<FoodItem> {
//        val db = readableDatabase
//        val cursor = db.query(
//            TABLE_NAME, null, "isLoved = 1",
//            null, null, null, null
//        )
//
//        val list = mutableListOf<FoodItem>()
//        with(cursor) {
//            while (moveToNext()) {
//                list.add(extractFoodItem(this))
//            }
//            close()
//        }
//        return list
//    }
//
//    fun toggleLoveStatus(item: FoodItem) {
//        val db = writableDatabase
//        val newValue = if (item.isLoved) 0 else 1
//        val values = ContentValues().apply {
//            put("isLoved", newValue)
//        }
//        db.update(TABLE_NAME, values, "title = ?", arrayOf(item.title))
//    }
//
//    private fun extractFoodItem(cursor: Cursor): FoodItem {
//        val ingredientsJson = cursor.getString(cursor.getColumnIndexOrThrow("ingredients"))
//        val ingredientsType = object : TypeToken<List<String>>() {}.type
//        return FoodItem(
//            title = cursor.getString(cursor.getColumnIndexOrThrow("title")),
//            category = cursor.getString(cursor.getColumnIndexOrThrow("category")),
//            imageResId = cursor.getInt(cursor.getColumnIndexOrThrow("imageResId")),
//            cookTime = cursor.getString(cursor.getColumnIndexOrThrow("cookTime")),
//            description = cursor.getString(cursor.getColumnIndexOrThrow("description")),
//            ingredients = Gson().fromJson(ingredientsJson, ingredientsType),
//            instructions = cursor.getString(cursor.getColumnIndexOrThrow("instructions")),
//            isLoved = cursor.getInt(cursor.getColumnIndexOrThrow("isLoved")) == 1
//        )
//    }
//
//
//    fun deleteAllItems() {
//        writableDatabase.execSQL("DELETE FROM $TABLE_NAME")
//    }
//
//    fun getFoodItemById(id: Int): FoodItem? {
//        val db = readableDatabase
//        val cursor = db.query(
//            TABLE_NAME,
//            null,
//            "id = ?",
//            arrayOf(id.toString()),
//            null,
//            null,
//            null
//        )
//
//        var item: FoodItem? = null
//        if (cursor.moveToFirst()) {
//            item = extractFoodItem(cursor)
//        }
//        cursor.close()
//        return item
//    }
//    fun isFoodItemLoved(id: Int): Boolean {
//        val db = readableDatabase
//        val cursor = db.query(
//            TABLE_NAME,
//            arrayOf("isLoved"),
//            "id = ?",
//            arrayOf(id.toString()),
//            null,
//            null,
//            null
//        )
//
//        var loved = false
//        if (cursor.moveToFirst()) {
//            loved = cursor.getInt(cursor.getColumnIndexOrThrow("isLoved")) == 1
//        }
//        cursor.close()
//        return loved
//    }
//    fun updateLoveStatus(id: Int, isLoved: Boolean) {
//        val db = writableDatabase
//        val values = ContentValues().apply {
//            put("isLoved", if (isLoved) 1 else 0)
//        }
//        db.update(TABLE_NAME, values, "id = ?", arrayOf(id.toString()))
//    }
//
//    fun getAllLovedFoodItems(): List<FoodItem> {
//        return getLovedItems()
//    }
//
//
//
//}
