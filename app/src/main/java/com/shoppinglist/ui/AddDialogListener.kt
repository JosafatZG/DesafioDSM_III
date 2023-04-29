package com.shoppinglist.ui

import com.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}