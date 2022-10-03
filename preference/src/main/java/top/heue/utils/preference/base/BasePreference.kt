package top.heue.utils.preference.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import kotlin.reflect.KProperty

abstract class BasePreference() : PreferenceFragmentCompat() {
    protected val item: Item = Item()
    abstract val resource: Int
    abstract val name: String
    private val className = this.javaClass.simpleName
    protected lateinit var root: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = super.onCreateView(inflater, container, savedInstanceState) as LinearLayout
        return root
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        preferenceManager.sharedPreferencesName = name
        addPreferencesFromResource(resource)
        Log.d(className, name)
    }

    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        if (preference.key != null)
            onClick(preference.key, preference)
        return super.onPreferenceTreeClick(preference)
    }

    protected open fun onClick(key: String, preference: Preference) {
    }
}

open class Item {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return property.name
    }

    /*operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        update()
    }*/
}