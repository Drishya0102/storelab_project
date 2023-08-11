package com.storelab.storelab_project.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast

class AppConstant
{
    //companion means static objects,it doesnt care for instance of class and we can use variables and methods directly from any class
    companion object
    {
        //const val BASE_URL = "https://picsum.photos/"
        const val BASE_URL ="https://picsum.photos/"
        const val QUERY_PER_PAGE = 20
        const val TOTAL_IMAGES = 1000
        const val TOTAL_PAGES = TOTAL_IMAGES / QUERY_PER_PAGE
        const val DEFAULT_PAGE_INDEX = 1

        @JvmStatic
        fun isNetworkConnected(mContext: Context?): Boolean {
            val result: Boolean
            val connectivityManager =
                mContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val networkCapabilities = connectivityManager.activeNetwork ?: return false
                val activeNetwork =
                    connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
                result = when {
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } else {
                val networkInfo =
                    connectivityManager.activeNetworkInfo ?: return false
                return networkInfo.isConnected
            }

            return result
        }
       // @JvmStatic
       @JvmStatic
        fun showToast(mContext: Context?, message: String?) {
            try {
                Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                e.printStackTrace()
            } catch (e: Error) {
                Exception(e).printStackTrace()
            }
        }


    }




}