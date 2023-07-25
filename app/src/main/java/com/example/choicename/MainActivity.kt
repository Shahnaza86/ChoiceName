package com.example.choicename

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun main(args: Array<String>) {
        val scanner = Scanner(System.in)

        val names = mutableListOf<String>()
        for (i in 0 until 10) {
            println("Введите имя ${i + 1}: ")
            val name = scanner.nextLine()
            names.add(name)
        }

        println("Введите ваше имя: ")
        val userName = scanner.nextLine()

        if (checkName(names, userName)) {
            println("Можно собрать ваше имя ")
        } else {
            println("Нельзя собрать ваше имя")
        }
    }

    fun checkName(names: List<String>, userName: String): Boolean {
        val chooseLetters = userName.toLowerCase().toSet()

        for (letter in chooseLetters) {
            var found = false
            for (name in names) {
                if (name.toLowerCase().contains(letter)) {
                    found = true
                    break
                }
            }
            if (!found) {
                return false
            }
        }

        return true
    }
   }