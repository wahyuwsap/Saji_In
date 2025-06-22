package com.saji_in.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel : ViewModel() {

    private val _lovedItems = MutableLiveData<List<FoodItem>>(emptyList())
    val lovedItems: LiveData<List<FoodItem>> get() = _lovedItems

    private val _selectedCategory = MutableLiveData<FoodType>()
    val selectedCategory: LiveData<FoodType> get() = _selectedCategory

    fun setSelectedCategory(type: FoodType) {
        _selectedCategory.value = type
    }

    fun toggleLove(item: FoodItem) {
        val currentList = _lovedItems.value?.toMutableList() ?: mutableListOf()
        if (currentList.contains(item)) {
            currentList.remove(item)
        } else {
            currentList.add(item)
        }
        _lovedItems.value = currentList
    }

    fun isLoved(item: FoodItem): Boolean {
        return _lovedItems.value?.contains(item) == true
    }

    companion object {
        private var instance: SharedViewModel? = null

        fun getInstance(): SharedViewModel {
            if (instance == null) {
                instance = SharedViewModel()
            }
            return instance!!
        }
    }
}
