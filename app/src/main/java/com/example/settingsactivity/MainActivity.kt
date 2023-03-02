package com.example.settingsactivity

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ekn.gruzer.gaugelibrary.FullGauge
import com.ekn.gruzer.gaugelibrary.Range


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainGauge = createFullGauge(R.id.sync_gauge, 75.0)
        val smallGauge = createFullGauge(R.id.small_gauge, 100.0)

        val swapToTasksBtn = findViewById<Button>(R.id.swap_to_tasks)
        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout)
        linearLayout.setBackgroundColor(Color.parseColor("#D3D3D3"))
        linearLayout.setOnClickListener {
            val intent = Intent(this@MainActivity, EmptyActivity::class.java)
            startActivity(intent)
        }
        val clearTasks = findViewById<Button>(R.id.clear_tasks)
        swapToTasksBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, EmptyActivity::class.java)
            startActivity(intent)
        }
        clearTasks.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("ВЫ УВЕРЕНЫ?")
            builder.setPositiveButton("ДА") { _, _ ->
                Toast.makeText(
                    applicationContext, android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
            }

            builder.setNegativeButton("НЕТ") { _, _ ->
                Toast.makeText(
                    applicationContext, android.R.string.no, Toast.LENGTH_SHORT
                ).show()
            }
            builder.show()


        }
//
//        if (!allPermissionsGranted()) {
//            // камера
//            ActivityCompat.requestPermissions(
//                this, REQUIRED_PERMISSIONS, REQUEST_CODE_CAMERA_PERMISSIONS
//            )
//            // микрофон
//            ActivityCompat.requestPermissions(
//                this, REQUIRED_PERMISSIONS, REQUEST_RECORD_AUDIO_PERMISSION
//            )
//
//            // геолокация
//            ActivityCompat.requestPermissions(
//                this, REQUIRED_PERMISSIONS, REQUEST_CODE_LOCATION_FINE_PERMISSIONS
//            )
//            ActivityCompat.requestPermissions(
//                this, REQUIRED_PERMISSIONS, REQUEST_CODE_NFC_PERMISSION
//            )
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.top_menu_settings -> {
                val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun createFullGauge(id: Int, initialValue: Double): FullGauge {
        val gauge = findViewById<FullGauge>(id)
        val range = Range()
        range.color = Color.parseColor("#ADD8E6")
        range.from = 0.0
        range.to = 100.0
        gauge.addRange(range)
        gauge.minValue = 0.0
        gauge.maxValue = 100.0
        gauge.value = initialValue
        return gauge
    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int, permissions: Array<String>, grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when (requestCode) {
//            REQUEST_CODE_CAMERA_PERMISSIONS -> {
//                if (!allPermissionsGranted()) {
//                    Toast.makeText(
//                        this,
//                        "Нет разрешения использовать камеру.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    finish()
//                }
//            }
//            REQUEST_CODE_LOCATION_FINE_PERMISSIONS -> {
//                if (!allPermissionsGranted()) {
//                    Toast.makeText(
//                        this,
//                        "Нет разрешения использовать геолокацию.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    finish()
//                }
//            }
//            REQUEST_RECORD_AUDIO_PERMISSION -> {
//                if (!allPermissionsGranted()) {
//                    Toast.makeText(
//                        this,
//                        "Нет разрешения использовать микрофон.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    finish()
//                }
//            }
//            REQUEST_CODE_NFC_PERMISSION -> {
//                if (!allPermissionsGranted()) {
//                    Toast.makeText(
//                        this,
//                        "Нет разрешения использовать NFC.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    finish()
//                }
//            }
//
//        }
//    }


//    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
//        ContextCompat.checkSelfPermission(
//            baseContext, it
//        ) == PackageManager.PERMISSION_GRANTED
//    }
//
//    companion object {
//        private const val REQUEST_CODE_CAMERA_PERMISSIONS = 10
//        private const val REQUEST_CODE_LOCATION_FINE_PERMISSIONS = 34
//        private const val REQUEST_RECORD_AUDIO_PERMISSION = 200
//        private const val REQUEST_CODE_NFC_PERMISSION = 300
//
//        private val REQUIRED_PERMISSIONS = arrayOf(
//            Manifest.permission.CAMERA,
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.RECORD_AUDIO,
//            Manifest.permission.NFC
//        )
//    }
}