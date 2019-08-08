package kz.djunglestones.speechrecognizer

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kz.djunglestones.speechrecognizer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

//    private fun initImage(pos:Int) {
//
//        val imgUri = listImgUrl[pos].toUri()
//        Glide.with(this).load(imgUri.toString()).apply(RequestOptions()
//            .error(R.drawable.ic_error_black_24dp)).into(binding.viewpager)
//    }
//
//    private fun inflateLists() {
//        listName = ArrayList<String>()
//        listImgUrl = ArrayList<String>()
//        listName.add("Олень")
//        listName.add("Волк")
//        listName.add("Лисичка")
//        listImgUrl.add("http://infapteka.ru/images-API/anim1.png")
//        listImgUrl.add("http://infapteka.ru/images-API/anim2.png")
//        listImgUrl.add("http://infapteka.ru/images-API/anim3.png")
//
//    }
//
//    private fun speak() {
//        val mIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
//        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
//        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ru")
//        mIntent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Что изображено на картинке?")
//
//        try {
//            startActivityForResult(mIntent,REQUEST_CODE_SPEECH_INPUT)
//
//        }catch (exception:Exception){
//            Toast.makeText(this,exception.message,Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when(requestCode){
//            REQUEST_CODE_SPEECH_INPUT->{
//                if (resultCode == Activity.RESULT_OK && null!=data){
//                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//                    val word = result[0]
//                    if (counter<2){
//                        if (word.equals(listName.get(counter).toLowerCase())){
//                            counter = counter.inc()
//                            Toast.makeText(this,"Правильно +"+counter.toString(),Toast.LENGTH_SHORT).show()
//                            initImage(counter)
//                        }else{
//                            Toast.makeText(this,"Ой, вы сказали: "+word,Toast.LENGTH_SHORT).show()
//                        }
//                    }else{
//                        counter=0
//                        initImage(counter)
//                    }
//
//
//                }
//            }
//        }
//    }
}
