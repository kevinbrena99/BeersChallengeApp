package com.brena.beerschallengeapp.data.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import java.lang.Exception

/**
 * Created by Kevin Breña on 3/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class ConnectionUtilsImpl(private val applicationContext: Context): ConnectionUtils {

    companion object {
        private val TAG = ConnectionUtilsImpl::class.java.simpleName
    }
    override fun isNetworkAvailable(): Boolean {
        try {
            val connectivityManager = applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val nw = connectivityManager.activeNetwork ?: return false
                val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
                return when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    //for other device how are able to connect with Ethernet
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } else {
                val nwInfo = connectivityManager.activeNetworkInfo ?: return false
                return nwInfo.isConnected
            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception happened: ${e.message}")
            return false
        }
    }
}