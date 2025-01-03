package com.example.ragistrationform

import  android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.text.Editable
import android.util.Base64
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.DataClass.MyDataClass
import com.example.ragistrationform.Factory.MainActivityFactory
import com.example.ragistrationform.databinding.ActivityMainBinding
import com.example.ragistrationform.viewModel.MainActivityViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.io.ByteArrayOutputStream
class MainActivity : AppCompatActivity() ,View.OnClickListener, RadioGroup.OnCheckedChangeListener ,CompoundButton.OnCheckedChangeListener, DatePickerDialog.OnDateSetListener {
    var bitmapToString:String? = null

    lateinit var Fname:EditText
    lateinit var Mname:EditText
    lateinit var Lname:EditText
    lateinit var Dob:EditText
    lateinit var Num:EditText
    lateinit var Gmail:EditText
    lateinit var Address:EditText
    lateinit var AadharNo:EditText
    lateinit var PanNo:EditText
    lateinit var Gender:RadioGroup
    lateinit var selectedGender:RadioButton
    lateinit var Male:RadioButton
    lateinit var Female:RadioButton
    lateinit var Others:RadioButton

    lateinit var cb1:CheckBox
    lateinit var cb2:CheckBox
    lateinit var cb3:CheckBox
    lateinit var cb4:CheckBox
    lateinit var cb5:CheckBox
    lateinit var cb6:CheckBox
    lateinit var cb7:CheckBox
    lateinit var cb8:CheckBox
    lateinit var cb9:CheckBox
    lateinit var cb10:CheckBox
    lateinit var Btn:Button
    lateinit var BtnLogOut:Button
    lateinit var calender: ImageView


    lateinit var viewModel:MainActivityViewModel
    lateinit var factory :MainActivityFactory
    lateinit var binding :ActivityMainBinding
    var selecedCourse = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        factory = MainActivityFactory(this@MainActivity)
        viewModel = ViewModelProvider(this,factory)[MainActivityViewModel::class.java]
        title ="Fill The Form"
        Fname = findViewById(R.id.fname)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
        val tl1 =findViewById<TextInputLayout>(R.id.TL1)
        Fname.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.isNullOrEmpty()) {
                    tl1.isCounterEnabled = true
                    tl1.helperText = "required field!"
                }
                else {
                    tl1.isCounterEnabled = true
                    tl1.helperText = null
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
        Mname = findViewById(R.id.mname)
        Lname = findViewById(R.id.lname)
        val tl3 =findViewById<TextInputLayout>(R.id.TL3)
        Lname.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.isNullOrEmpty()) {
                    tl3.isCounterEnabled = true
                    tl3.helperText = "required field!"
                }
                else {
                    tl3.isCounterEnabled = true
                    tl3.helperText = null
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
        Dob = findViewById(R.id.dob)

        val tl5 =findViewById<TextInputLayout>(R.id.TL5)
        Dob.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.isNullOrEmpty()) {
                    tl5.helperText = "required field!"
                }
                else {

                    tl5.helperText = null
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
//        Dob.setEnabled(false)
        Num = findViewById(R.id.number)
        val tl4 =findViewById<TextInputLayout>(R.id.TL4)
        Num.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.isNullOrEmpty()) {
                    tl4.isCounterEnabled = true
                    tl4.helperText = "required field!"
                }
                else {
                    tl4.isCounterEnabled = true
                    tl4.helperText = null
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
        Gmail = findViewById(R.id.mail)

        val tl7 =findViewById<TextInputLayout>(R.id.TL7)
        Gmail.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.isNullOrEmpty()) {
                    tl7.isCounterEnabled = true
                    tl7.helperText = "required field!"
                }
                else {
                    tl7.isCounterEnabled = true
                    tl7.helperText = null
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
        Address = findViewById(R.id.address)

        val tl6 =findViewById<TextInputLayout>(R.id.TL6)
        Address.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.isNullOrEmpty()) {
                    tl6.isCounterEnabled = true
                    tl6.helperText = "required field!"
                }
                else {
                    tl6.isCounterEnabled = true
                    tl6.helperText = null
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
        AadharNo = findViewById(R.id.aadharNo)
        val tl8 =findViewById<TextInputLayout>(R.id.TL8)
        AadharNo.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.isNullOrEmpty()) {
                    tl8.isCounterEnabled = true
                    tl8.helperText = "required field!"
                }
                else {
                    tl8.isCounterEnabled = true
                    tl8.helperText = null
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
        PanNo = findViewById(R.id.panNo)
        val tl9 =findViewById<TextInputLayout>(R.id.TL9)
        PanNo.addTextChangedListener(object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.isNullOrEmpty()) {
                    tl9.isCounterEnabled = true
                    tl9.helperText = "required field!"
                }
                else {
                    tl9.isCounterEnabled = true
                    tl9.helperText = null
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
        Gender = findViewById(R.id.rg_gender)
        Male = findViewById(R.id.male)
        Female = findViewById(R.id.female)
        Others = findViewById(R.id.others)
        calender = findViewById(R.id.calender)




        cb1 = findViewById(R.id.cb1)
        cb2 = findViewById(R.id.cb2)
        cb3 = findViewById(R.id.cb3)
        cb4 = findViewById(R.id.cb4)
        cb5 = findViewById(R.id.cb5)
        cb6 = findViewById(R.id.cb6)
        cb7 = findViewById(R.id.cb7)
        cb8 = findViewById(R.id.cb8)
        cb9 = findViewById(R.id.cb9)
        cb10 = findViewById(R.id.cb10)
        BtnLogOut = findViewById(R.id.logout)



        Btn = findViewById(R.id.submit)

        //submit btn listener
        Btn.setOnClickListener(this)
        //logout btn listener
        BtnLogOut.setOnClickListener(this)
        //dob image listener
        Dob.setOnClickListener(this)
        //radio btn listener
        Gender.setOnCheckedChangeListener(this)
        //checkboxes listeners
        cb1.setOnCheckedChangeListener(this)
        cb2.setOnCheckedChangeListener(this)
        cb3.setOnCheckedChangeListener(this)
        cb4.setOnCheckedChangeListener(this)
        cb5.setOnCheckedChangeListener(this)
        cb6.setOnCheckedChangeListener(this)
        cb7.setOnCheckedChangeListener(this)
        cb8.setOnCheckedChangeListener(this)
        cb9.setOnCheckedChangeListener(this)
        cb10.setOnCheckedChangeListener(this)


        binding.img.setOnClickListener{
            if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED)
            {
              val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent,200)
            }
            else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 121)

            }
        }
    }


    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.logout ->{
                viewModel.logout()
                val intent = Intent(this,Login_Activity::class.java)
                startActivity(intent)
            }
            R.id.submit -> {

                if (Fname.text.toString().isEmpty() &&
                    Lname.text.toString().isEmpty() &&
                    Dob.text.toString().isEmpty() &&
                    Gmail.text.toString().isEmpty() &&
                    Num.text.isEmpty() &&
                    Address.text.toString().isEmpty() &&
                    AadharNo.text.isEmpty() &&
                    PanNo.text.isEmpty() &&
                    !Male.isChecked && !Female.isChecked && !Others.isChecked &&
                    !cb1.isChecked && !cb2.isChecked && !cb3.isChecked && !cb4.isChecked &&
                    !cb5.isChecked && !cb6.isChecked && !cb7.isChecked && !cb8.isChecked &&
                    !cb9.isChecked && !cb10.isChecked

                ) {
                    Toast.makeText(applicationContext, "All Fields are Empty!!", Toast.LENGTH_SHORT)
                        .show()
                } else if (Fname.text.toString().isEmpty()) {
                    Snackbar.make(v!!, "Enter First Name", Snackbar.LENGTH_SHORT).show()

                } else if (Lname.text.toString().isEmpty()) {
                    Snackbar.make(v!!, "Enter Last Name", Snackbar.LENGTH_SHORT).show()
                } else if (Dob.text.toString().isEmpty()) {
                    Snackbar.make(v!!, "Date of Birth Missing !!", Snackbar.LENGTH_SHORT).show()
                } else if (Num.text.length < 10 || Num.text.isEmpty()) {
                    Snackbar.make(
                        v!!,
                        "you have Entered less than 10 digit in Mobile NO.",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else if (Address.text.toString().isEmpty()) {
                    Snackbar.make(v!!, "Enter Address", Snackbar.LENGTH_SHORT).show()
                } else if (Gmail.text.toString().isEmpty()) {
                    Snackbar.make(v!!, "Enter Gmail-Id", Snackbar.LENGTH_SHORT).show()
                } else if (AadharNo.text.isEmpty()) {
                    Snackbar.make(v!!, "Enter Aadhar No.", Snackbar.LENGTH_SHORT).show()
                } else if (PanNo.text.isEmpty()) {
                    Snackbar.make(v!!, "Enter Pan No.", Snackbar.LENGTH_SHORT).show()
                } else if (!Male.isChecked && !Female.isChecked && !Others.isChecked) {
                    Snackbar.make(v!!, "Please Select Gender", Snackbar.LENGTH_SHORT).show()
                } else if ( !cb1.isChecked && !cb2.isChecked && !cb3.isChecked && !cb4.isChecked &&
                    !cb5.isChecked && !cb6.isChecked && !cb7.isChecked && !cb8.isChecked &&
                    !cb9.isChecked && !cb10.isChecked) {
                    Snackbar.make(v!!, "Please Select Courses", Snackbar.LENGTH_SHORT).show()
                }
                else {
//                    val intent = Intent(this, MainActivity2::class.java)
//                    var dataClass = MyDataClass(
//                        "Name :" + Fname.text + " " + Mname.text + " " + Lname.text,
//                        "Contact : +91 " + Num.text,
//                        "Date of Birth :"  + Dob.text,
//                        "Address :" + Address.text,
//                        "Email-Id :" + Gmail.text,
//                        "Aadhar No. :xxxx xxxx " + AadharNo.text,
//                        "Pan No.:" + PanNo.text,
//                        "Gender :" + selectedGender.text,
//                        "Selected Courses: " + selecedCourse.joinToString(",", "", " ")
//                        )
                    viewModel.insertFormData(
                        Fname.text.toString() + " " + Mname.text.toString() + " " + Lname.text.toString(),
                        Num.text.toString(),
                        Dob.text.toString(),
                        Address.text.toString(),
                        Gmail.text.toString(),
                        AadharNo.text.toString(),
                        PanNo.text.toString(),
                        selectedGender.text.toString(),
                        selecedCourse.joinToString(",", "", " "),
                        bitmapToString!!


                    )
//                        intent.putExtra("dataClass",dataClass)
//                    startActivity(intent)
                    Fname.setText("")
                    Mname.setText("")
                    Lname.setText("")
                    Num.setText("")
                    Dob.setText("")
                    Address.setText("")
                    Gmail.setText("")
                    AadharNo.setText("")
                    PanNo.setText("")
                    Male.setChecked(false)
                    Female.setChecked(false)
                   Others.setChecked(false)
                    binding.img.setImageBitmap(null)
                    cb1.setChecked(false)
                    cb2.setChecked(false)
                    cb3.setChecked(false)
                    cb4.setChecked(false)
                    cb5.setChecked(false)
                    cb6.setChecked(false)
                    cb7.setChecked(false)
                    cb8.setChecked(false)
                    cb9.setChecked(false)
                    cb10.setChecked(false)

                }
            }

            R.id.dob ->{
                val cal = DatePickerDialog(this)
                cal.show()
                cal.setOnDateSetListener(this)
            }
        }
    }


    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView!!.text.toString()){
            "Java"->{
                if(isChecked) selecedCourse.add("java")
                else selecedCourse.remove("java")
//                Log.d("TAG", "..."+selecedCourse)

            }
            "Kotlin"->{
                if(isChecked) selecedCourse.add("Kotlin")
                else selecedCourse.remove("Kotlin")
//                Log.d("TAG", "..."+selecedCourse)


            }
            "C"->{
                if(isChecked) selecedCourse.add("C")
                else selecedCourse.remove("C")
//                Log.d("TAG", "..."+selecedCourse)

            }
            "C++"->{
                if(isChecked) selecedCourse.add("C++")
                else selecedCourse.remove("C++")
//                Log.d("TAG", "..."+selecedCourse)

            }
            "Python"->{
                if(isChecked) selecedCourse.add("Python")
                else selecedCourse.remove("Python")
//                Log.d("TAG", "..."+selecedCourse)

            }
            "C#"->{
                if(isChecked) selecedCourse.add("C#")
                else selecedCourse.remove("C#")
//                Log.d("TAG", "..."+selecedCourse)

            }
            "JavaScript"->{
                if(isChecked) selecedCourse.add("JavaScript")
                else selecedCourse.remove("Javascript")
//                Log.d("TAG", "..."+selecedCourse)

            }
            "PHP"->{
                if(isChecked) selecedCourse.add("PHP")
                else selecedCourse.remove("PHP")
//                Log.d("TAG", "..."+selecedCourse)

            }
            "Go"->{
                if(isChecked) selecedCourse.add("Go")
                else selecedCourse.remove("Go")
//                Log.d("TAG", "..."+selecedCourse)

            }"Ruby"->{
            if(isChecked) selecedCourse.add("Ruby")
            else selecedCourse.remove("Ruby")
//                Log.d("TAG", "..."+selecedCourse)

        }

        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        selectedGender = findViewById<RadioButton>(checkedId)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        Dob.setText("" +dayOfMonth + "/" + (month+1) + "/" +year)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.viewdata->{
                val intent =Intent(this,ViewDataNamesActivity::class.java)
               startActivity(intent)
                }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 121 && grantResults.isNotEmpty() && permissions.size > 0){
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 200)
        }else{
            Toast.makeText(this, "Permission denied !!", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 200 && resultCode == RESULT_OK){
            val bitmap: Bitmap = data!!.extras!!.get("data") as Bitmap
            binding.img.setImageBitmap(bitmap)
          bitmapToString = BitMapToString(bitmap)
        }

    }

    fun BitMapToString(bitmap: Bitmap): String {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }



}

