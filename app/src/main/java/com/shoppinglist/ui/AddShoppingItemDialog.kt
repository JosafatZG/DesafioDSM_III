package com.shoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.shoppinglist.R
import com.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name: String = etName.text.toString()
            val amount: Int? = etAmount.text.toString().toIntOrNull()
            if(name.isEmpty()) {
                Toast.makeText(context, "Por favor introduce un nombre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(amount == null) {
                Toast.makeText(context, "Por favor introduce un numero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}