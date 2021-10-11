package com.example.quizappbasic

import android.content.Context

class DataModel(context: Context) {
    public val settOpts = listOf<Data>(
        Data(context.getString(R.string.sett_opt1), false, true),
        Data(context.getString(R.string.sett_opt2), false, false),
        Data(context.getString(R.string.sett_opt3), false, false),
        Data(context.getString(R.string.sett_opt4), false, false),
        Data(context.getString(R.string.sett_opt5), false, false),
        Data(context.getString(R.string.sett_opt6), true, false),
        Data(context.getString(R.string.sett_opt7), false, false),
    )
}