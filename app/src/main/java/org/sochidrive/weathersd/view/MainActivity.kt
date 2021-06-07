package org.sochidrive.weathersd.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sochidrive.weathersd.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container,MainFragment.newInstance())
                .commit()
        }
    }
}