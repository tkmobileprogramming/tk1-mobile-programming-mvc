package com.example.todolistmvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), TodoController.ViewUpdater {
    private lateinit var controller: TodoController
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = TodoController(this)

        val inputBox = findViewById<EditText>(R.id.inputBox)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = TodoAdapter { todo -> controller.deleteTodo(todo) }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        submitButton.setOnClickListener {
            val text = inputBox.text.toString()
            if (text.isNotEmpty()) {
                controller.addTodo(Todo(text))
                inputBox.text.clear()
            }
        }
    }

    override fun updateTodoList(todos: List<Todo>) {
        adapter.submitList(todos)
    }
}