package com.example.achmerova

interface DatabaseInterface {
    fun create()
    fun read() : Any
    fun update()
    fun delete()
}