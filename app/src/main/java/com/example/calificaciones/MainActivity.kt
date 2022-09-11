package com.example.calificaciones

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calificaciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        validate()
    }
    private fun validate()
    {
        binding.submit.setOnClickListener(){
            val calificacion = binding.calificacion.editText?.text.toString()
            val number = calificacion.toDouble()

            var cal = toString();
            if (number >= 90)
            {
                cal = "A";
            }
            else if(number in 80.0..89.0)
            {
                cal = "B";
            }
            else if(number in 70.0..79.0)
            {
                cal = "C";
            }
            else if(number in 60.0..69.0)
            {
                cal = "D";
            }
            else if(number < 60)
            {
                cal = "F";
            }

            Toast.makeText(this, "Calificacion: $cal", Toast.LENGTH_LONG).show()
            hideKeyboard()
            binding.textInputEditText.setText("");
        }
    }

    private fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            this.currentFocus?.let { view ->
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}

