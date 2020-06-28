package com.rest.testgeopagos.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager @SuppressLint("CommitPrefEdits") constructor(context: Context) {

    companion object {
        private var singleton: SharedPreferencesManager? = null
        private lateinit var preferences: SharedPreferences
        private lateinit var editor: SharedPreferences.Editor

        fun with(context: Context): SharedPreferencesManager {
            if (null == singleton)
                singleton = SharedPreferencesManager(context)
            return singleton as SharedPreferencesManager
        }
    }

    private val amountKey = "amountKey"
    private val paymentKey = "paymentKey"
    private val issuerKey = "issuerKey"

    init {
        preferences = context.getSharedPreferences("TEST_GEO_PAGOS", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

    fun saveAmount(amount: String) {
        editor.putString(amountKey, amount).apply()
    }

    fun getAmount() : String {
        return preferences.getString(amountKey, "") ?: ""
    }

    fun clearAmount() {
        editor.remove(amountKey)
    }

    fun savePaymentId(payment: String) {
        editor.putString(paymentKey, payment).apply()
    }

    fun getPaymentId() : String {
        return preferences.getString(paymentKey, "") ?: ""
    }

    fun clearPayment() {
        editor.remove(paymentKey)
    }

    fun saveIssuerId(issuer: String) {
        editor.putString(issuerKey, issuer).apply()
    }

    fun getIssuerId() : String {
        return preferences.getString(issuerKey, "") ?: ""
    }

    fun clearIssuerId() {
        editor.remove(issuerKey)
    }

    fun clearPref() {
        clearAmount()
        clearIssuerId()
        clearPayment()
    }

}