package com.example.tugaskotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        initiateUI()
    }

    private fun initiateUI() {
        btn_finish.setOnClickListener(this)

        val intent = intent

        tv_displaynama.text = intent.getStringExtra("NAMA")
        tv_displaynim.text = intent.getStringExtra("NIM")
        tv_displaygender.text = intent.getStringExtra("GENDER")
        tv_displayjurusan.text = intent.getStringExtra("JURUSAN")
        tv_displayalamat.text = intent.getStringExtra("ALAMAT")
        tv_displaytanggal.text = intent.getStringExtra("TANGGAL")
        tv_displaybulan.text = intent.getStringExtra("BULAN")
        tv_displaytahun.text = intent.getStringExtra("TAHUN")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_finish -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}