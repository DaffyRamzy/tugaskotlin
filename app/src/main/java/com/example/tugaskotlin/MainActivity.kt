package com.example.tugaskotlin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var nama = ""
    private var nim = ""
    private var gender = ""
    private var jurusan = ""
    private var alamat = ""
    private var tanggal = ""
    private var bulan = ""
    private var tahun = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_nama.addTextChangedListener(inputData)
        et_nim.addTextChangedListener(inputData)
        rg_gender.setOnCheckedChangeListener { _, radiobutton ->
            val gender: RadioButton = findViewById(radiobutton)
            this.gender = gender.text.toString().trim()
        }
        et_jurusan.addTextChangedListener(inputData)
        et_alamat.addTextChangedListener(inputData)
        et_tanggal.addTextChangedListener(inputData)
        et_bulan.addTextChangedListener(inputData)
        et_tahun.addTextChangedListener(inputData)

        initiateUI()
    }

    private val inputData: TextWatcher = object : TextWatcher {
        @RequiresApi(Build.VERSION_CODES.M)
        override fun afterTextChanged(p0: Editable?) {
            nama = et_nama.text.toString().trim()
            nim = et_nim.text.toString().trim()
            jurusan = et_jurusan.text.toString().trim()
            alamat = et_alamat.text.toString().trim()
            tanggal = et_tanggal.text.toString().trim()
            bulan = et_bulan.text.toString().trim()
            tahun = et_tahun.text.toString().trim()

            enableBtn()
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun enableBtn() {
        btn_continue.setEnabled(
            !nama.isEmpty() && !nim.isEmpty() && !jurusan.isEmpty() && !alamat.isEmpty() && !tanggal.isEmpty() && !bulan.isEmpty() && !tahun.isEmpty()
        )
        if (!nama.isEmpty() && !nim.isEmpty() && !jurusan.isEmpty() && !alamat.isEmpty() && !tanggal.isEmpty() && !bulan.isEmpty() && !tahun.isEmpty()){
            btn_continue.setBackgroundColor(getColor(R.color.colorPrimary))
            btn_continue.setTextColor(getColor(R.color.colorAccent))
        }
        else if (nama.isEmpty() && nim.isEmpty() && jurusan.isEmpty() && alamat.isEmpty() && tanggal.isEmpty() && bulan.isEmpty() && tahun.isEmpty()) {
            btn_continue.setBackgroundColor(getColor(R.color.colorDarkerBlue))
            btn_continue.setTextColor(getColor(R.color.colorDarkerBlueText))
        }
    }

    private fun initiateUI() {
        btn_continue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_continue -> {
                val intent = Intent(this, ShowActivity::class.java)

                intent.putExtra("NAMA", nama)
                intent.putExtra("NIM", nim)
                intent.putExtra("GENDER", gender)
                intent.putExtra("JURUSAN", jurusan)
                intent.putExtra("ALAMAT", alamat)
                intent.putExtra("TANGGAL", tanggal)
                intent.putExtra("BULAN", bulan)
                intent.putExtra("TAHUN", tahun)

                startActivity(intent)
            }
        }
    }
}