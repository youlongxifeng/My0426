package com.alc.my0426.myapp

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.alc.my0426.MainFragmentStateAdapter
import com.alc.my0426.R
import com.alc.my0426.base.BaseFragment
import com.alc.my0426.ext.nav
import com.alc.my0426.ext.navigateAction
import com.alc.my0426.utils.MyUtils
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/23
 */
class Nav1Fragment  : BaseFragment() {
    lateinit var text_name: TextView;

    companion object{
        public   fun  getInstance( value:String): Nav1Fragment {
            var homeFragment: Nav1Fragment = Nav1Fragment()
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
        var view: View =inflater.inflate(R.layout.nav1_fragmeng,container,false)
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
            parms.putString("name","action_nav1Fragment_to_detailsfragment你好")
          //  NavController.navigate(text_name).navigate(R.id.action_nav1Fragment_to_detailsfragment,parms);
            nav().navigateAction( R.id.action_nav1Fragment_to_detailsfragment,  parms)
        }
    }
}