package com.example.todolistmvc

class TodoController(private val viewUpdater: ViewUpdater) {
    private val model = TodoModel()

    fun addTodo(todo: Todo) {
        model.addTodo(todo)
        updateView()
    }

    fun deleteTodo(todo: Todo) {
        model.deleteTodo(todo)
        updateView()
    }

    private fun updateView() {
        viewUpdater.updateTodoList(model.getTodos())
    }

    interface ViewUpdater {
        fun updateTodoList(todos: List<Todo>)
    }
}