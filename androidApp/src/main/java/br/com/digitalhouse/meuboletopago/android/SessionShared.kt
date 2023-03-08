package br.com.digitalhouse.meuboletopago.android

import android.content.Context
import android.content.SharedPreferences

class SessionShared (
    sharedPreferences: SharedPreferences
) : SharedPreferences by sharedPreferences

{
        val idUser: Int
            get() = this.getInt(KEY_SESSION_COUNT, 0)

        fun updateUser(id:Int) {
            this.edit()
                .putInt(KEY_SESSION_COUNT, id)
                .apply()
        }

        companion object {
            private const val KEY_SESSION_COUNT = "boletopago"
        }
    }
