package com.xinto.aliuplugins.layoutcontroller.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.widget.LinearLayout
import com.aliucord.Utils
import com.aliucord.api.SettingsAPI
import com.xinto.aliuplugins.layoutcontroller.util.PREFERENCE_DEFAULT_VALUE
import com.aliucord.utils.DimenUtils
import com.discord.utilities.color.ColorCompat
import com.discord.views.CheckedSetting
import com.google.android.material.card.MaterialCardView
import com.lytefast.flexinput.R

@SuppressLint("ViewConstructor")
class SwitchItem(
    context: Context,
    settingsAPI: SettingsAPI,
    key: String,
    val description: String
) : MaterialCardView(context) {

    init {
        radius = DimenUtils.defaultPadding.toFloat()
        setCardBackgroundColor(ColorCompat.getThemedColor(context, R.b.colorBackgroundSecondary))
        layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        Utils.createCheckedSetting(context, CheckedSetting.ViewType.SWITCH, description, null)
            .apply {
                isChecked = settingsAPI.getBool(key, PREFERENCE_DEFAULT_VALUE)
                setOnCheckedListener { settingsAPI.setBool(key, it) }
                this@SwitchItem.addView(this)
            }
    }

}