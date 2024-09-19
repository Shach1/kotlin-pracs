fun main(args: Array<String>)
{
    val expenseList = ExpenseList()

    expenseList.addExpense(Expense(200, "Transport", "2024-09-01"))
    expenseList.addExpense(Expense(100, "Transport", "2024-09-02"))
    expenseList.addExpense(Expense(100, "Food", "2024-09-03"))
    expenseList.addExpense(Expense(200, "Game", "2024-09-04"))
    expenseList.addExpense(Expense(300, "Game", "2024-09-05"))
    expenseList.addExpense(Expense(400, "Food", "2024-09-06"))
    expenseList.addExpense(Expense(500, "Food", "2024-09-06"))
    expenseList.addExpense(Expense(200, "Transport", "2024-09-08"))
    expenseList.addExpense(Expense(100, "Transport", "2024-09-09"))
    expenseList.addExpense(Expense(100, "Transport", "2024-09-10"))

    expenseList.displayExpenses()
    println("Total price: \n ${expenseList.getTotalPriceByCategory()}")
}