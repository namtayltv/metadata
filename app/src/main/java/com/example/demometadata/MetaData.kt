package com.example.demometadata

class MetaData(key: Int, value: Any) {
    private var mKey: Int? = key
    private var mValue: Any? = value

    fun getKey(): Int? {
        return mKey
    }

    fun setKey(mKey: Int) {
        this.mKey = mKey
    }

    fun getValue(): Any? {
        return mValue
    }

    fun setValue(mValue: Any) {
        this.mValue = mValue
    }
}