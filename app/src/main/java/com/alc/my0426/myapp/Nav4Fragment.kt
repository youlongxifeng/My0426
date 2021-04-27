package com.alc.my0426.myapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.alc.my0426.R
import com.alc.my0426.base.BaseFragment

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/23
 */
class Nav4Fragment  : BaseFragment() {
    lateinit var text_name: TextView;

    companion object{
        public   fun  getInstance( value:String): Nav4Fragment {
            var homeFragment: Nav4Fragment = Nav4Fragment()
            var bundle: Bundle = Bundle()
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
        var view: View =inflater.inflate(R.layout.nav4_fragmeng,container,false)
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
            var parms = Bundle()
            parms.putString("name","action_nav4Fragment_to_detailsfragment你好")
            Navigation.findNavController(text_name).navigate(R.id.action_nav4Fragment_to_detailsfragment,parms);
        }
    }
}