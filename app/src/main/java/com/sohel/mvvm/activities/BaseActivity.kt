package com.sohel.mvvm.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

public open class   BaseActivity :AppCompatActivity()/*, LifecycleRegistryOwner*/ {
    internal var progressDialog: ProgressDialog? = null
   // internal var lifecycleRegistry = LifecycleRegistry(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    protected fun showLoading() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog!!.show()
        }
    }

    protected fun hideLoading() {
        if (progressDialog != null) {
            progressDialog!!.dismiss()
        }
    }


    /*override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }*/


}