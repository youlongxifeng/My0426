package com.alc.my0426

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/21
 */
class HomeFragment : Fragment() {
    lateinit var text_name:TextView;

    companion object{
        public   fun  getInstance( value:String):HomeFragment{
            var homeFragment:HomeFragment= HomeFragment()
            var bundle:Bundle=Bundle()
            bundle.putString("name",value)
            homeFragment.arguments=bundle
            return homeFragment
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return super.onCreateView(inflater, container, savedInstanceState)
        var view:View=inflater.inflate(R.layout.home_fragmeng,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_name=view.findViewById<TextView>(R.id.text_name)
        var name:String= arguments?.get("name") as String
        text_name.text=name
        val helloHe:String="nihao"
        val helloShe:String="你好"
        var isEqual:Boolean=false
        text_name.setOnClickListener {

            if(isEqual){
                val result=helloHe==helloShe
                Log.i("YYY","result===${result}")
            }else{
                val result=helloHe!=helloShe
                Log.i("YYY","result=!==${result}")
            }
            isEqual=!isEqual
        }
    }
}