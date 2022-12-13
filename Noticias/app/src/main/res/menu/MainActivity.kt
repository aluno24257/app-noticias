package com.squarcy.equals

import android.R
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val title: TextView = toolbar.findViewById(R.id.toolbar_title)
        setSupportActionBar(toolbar)
        title.setText(toolbar.getTitle())
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        toolbar.setPadding(0, statusBarHeight, 0, 0)
    }

    // Get Status Bar Height
    private val statusBarHeight: Int
        private get() {
            val height: Int
            val myResources = resources
            val idStatusBarHeight = myResources.getIdentifier(
                "status_bar_height", "dimen", "android"
            )
            height = if (idStatusBarHeight > 0) {
                resources.getDimensionPixelSize(idStatusBarHeight)
            } else {
                0
            }
            return height
        }

    // Inflate Search
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        return true
    }

    // If Icon Search is Clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}}