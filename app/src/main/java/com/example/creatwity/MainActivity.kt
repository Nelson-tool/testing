package com.example.creatwity

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import com.example.creatwity.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popdialog.*
import kotlinx.android.synthetic.main.popdialog.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(activity_main)

        btn_add_page.setOnClickListener{val dialogView = LayoutInflater.from(this).inflate(R.layout.popdialog, null) ;

            var  builder = AlertDialog.Builder(this).setView(dialogView).setTitle("Add page")

            val alertDialog = builder.show()

            dialogView.button_start.setOnClickListener {
                alertDialog.dismiss()

                val url = alertDialog.dialogUrl.text.toString()
                val name =  alertDialog.Name.text.toString()
                val text  = alertDialog.test.text.toString()

                Log.d("ok", url)
                if (!url.isBlank()) {
                    webView = findViewById(R.id.webview)
                    webView.visibility = View.VISIBLE
                    webView.loadUrl(url)

                    print(url)
                } else {
                    textviewsection.setText("Text:" + text)
                }

            }
        }
    }
}
