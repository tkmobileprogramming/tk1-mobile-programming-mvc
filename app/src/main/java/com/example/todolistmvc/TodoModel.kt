package com.example.todolistmvc

class TodoModel {
    private val todos = mutableListOf<Todo>()

    fun addTodo(todo: Todo) {
        todos.add(todo)
    }

    fun deleteTodo(todo: Todo) {
        todos.remove(todo)
    }

    fun getTodos(): List<Todo> {
        return todos.toList()
    }
}