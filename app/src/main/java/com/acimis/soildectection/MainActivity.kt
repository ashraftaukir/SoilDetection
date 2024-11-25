package com.acimis.soildectection

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE_PICK_FILE = 1000 // Request code for file picker
    private lateinit var resultTextView: TextView

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.tvResult)

        // Start the file picker to select "JXCT.csv"
        pickCSVFile()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun pickCSVFile() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "*/*"  // Allow all file types
        }
        startActivityForResult(intent, REQUEST_CODE_PICK_FILE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PICK_FILE && resultCode == RESULT_OK) {
            val uri: Uri? = data?.data
            if (uri != null) {
                val fileName = getFileName(uri)
                if (fileName?.endsWith(".CSV", ignoreCase = true) == true) {
                    // If the file is JXCT.CSV (case-insensitive), proceed to read it
                    readCSVFile(uri)
                } else {
                    Toast.makeText(this, "Selected file is not a CSV file", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "File selection canceled", Toast.LENGTH_SHORT).show()
        }
    }

    // Helper function to get the file name from the URI
    private fun getFileName(uri: Uri): String? {
        var name: String? = null
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            val nameIndex = it.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
            if (it.moveToFirst()) {
                name = it.getString(nameIndex)
            }
        }
        return name
    }


    private fun readCSVFile(uri: Uri) {
        try {
            contentResolver.openInputStream(uri)?.use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    val builder = StringBuilder()
                    var line = reader.readLine()
                    while (line != null) {
                        val columns = line.split(",")
                        builder.append("Row: ${columns.joinToString(", ")}\n")
                        line = reader.readLine()
                    }
                    // Display the CSV data in the TextView
                    resultTextView.text = builder.toString()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error reading CSV file: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
