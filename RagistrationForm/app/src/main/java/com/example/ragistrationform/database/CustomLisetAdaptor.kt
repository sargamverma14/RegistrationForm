package com.example.ragistrationform.database

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.ragistrationform.DataClass.MyDataClass
import com.example.ragistrationform.DataClass.UserList
import com.example.ragistrationform.R
import com.example.ragistrationform.databinding.ListviewBinding
import com.example.ragistrationform.individualAllDataActivity

class CustomLisetAdaptor(val context: Context, val list : List<UserList>) :BaseAdapter(){
   companion object{
       var phone:String =""
   }
    override fun getCount(): Int {
      return  list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    var view = LayoutInflater.from(parent?.context).inflate(R.layout.listview,parent,false)
        var binding:ListviewBinding = DataBindingUtil.bind(view)!!
        view = binding.root
         val imgAsString = list[position].image
        binding.imguser.setImageBitmap(stringToBitmap(imgAsString))
        binding.tvName.text = list[position].name
        binding.tvName.setOnClickListener{
            val intent = Intent(context,individualAllDataActivity::class.java)
            val myDataClass = MyDataClass(list[position].name,
                list[position].contact,
                list[position].dob,
                list[position].address,
                list[position].email,
                list[position].aadhar,
                list[position].pan,
                list[position].gender,
                list[position].courses
                 )
            intent.putExtra("Data",myDataClass)
                context.startActivity(intent)
        }
        binding.imgcall.setOnClickListener{
            if(ActivityCompat.checkSelfPermission(context,android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            { val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+list[position].contact))
            context.startActivity(intent)
            }else{
                phone = list[position].contact
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf( android.Manifest.permission.CALL_PHONE),101)

            }
        }
        return view
    }

    private fun stringToBitmap(base64String: String): Bitmap {
        val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }


}