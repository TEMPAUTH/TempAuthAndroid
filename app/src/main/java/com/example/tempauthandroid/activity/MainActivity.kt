package com.example.tempauthandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tempauthandroid.R
import com.example.tempauthandroid.fragment.AuthReqFragment
import com.example.tempauthandroid.fragment.AuthResFragment
import com.example.tempauthandroid.fragment.AuthUseFragment
import com.example.tempauthandroid.fragment.MyPageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var authReqFragment: AuthReqFragment
    lateinit var authResFragment: AuthResFragment
    lateinit var authUseFragment: AuthUseFragment
    lateinit var myPageFragment: MyPageFragment

//    private val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        authReqFragment = AuthReqFragment()
        authResFragment = AuthResFragment()
        authUseFragment = AuthUseFragment()
        myPageFragment = MyPageFragment()

        main_activity_bnv.bringToFront()

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_fg, authUseFragment).commit()

        main_activity_bnv.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_auth_req -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, authReqFragment).commit()
                R.id.menu_auth_res -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, authResFragment).commit()
                R.id.menu_auth_use -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, authUseFragment).commit()
                R.id.menu_my_page -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, myPageFragment).commit()
            }
            true
        }
    }
}