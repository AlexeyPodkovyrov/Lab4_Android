package com.example.profileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textName = findViewById<TextView>(R.id.textName)
        val textStatus = findViewById<TextView>(R.id.textStatus)
        val editName = findViewById<EditText>(R.id.editName)
        val editStatus = findViewById<EditText>(R.id.editStatus)
        val buttonEdit = findViewById<Button>(R.id.buttonEdit)
        val buttonExit = findViewById<Button>(R.id.buttonBack)

        var isEditing = false

        buttonEdit.setOnClickListener {
            if (isEditing) {
                val newName = editName.text.toString().ifEmpty { getString(R.string.profile_name) }
                val newStatus = editStatus.text.toString().ifEmpty { getString(R.string.profile_status) }
                textName.text = newName
                textStatus.text = newStatus

                textName.visibility = TextView.VISIBLE
                textStatus.visibility = TextView.VISIBLE
                editName.visibility = EditText.GONE
                editStatus.visibility = EditText.GONE

                buttonEdit.text = getString(R.string.button_edit)
                Toast.makeText(this, R.string.toast_save_message, Toast.LENGTH_SHORT).show()
            }
            else {

                textName.visibility = TextView.GONE
                textStatus.visibility = TextView.GONE
                editName.visibility = EditText.VISIBLE
                editStatus.visibility = EditText.VISIBLE

                editName.setText(textName.text.toString())
                editStatus.setText(textStatus.text.toString())

                buttonEdit.text = getString(R.string.button_save)
                Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
            }
            isEditing = !isEditing
        }

        buttonExit.setOnClickListener {
            finish()
        }
    }
}