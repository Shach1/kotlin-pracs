class ExpenseList
{
    private val expenses = mutableListOf<Expense>()
    private val categories = mutableListOf<String>()

    fun addExpense(expense: Expense)
    {
        expenses.add(expense)
        if (!categories.contains(expense.getCategory()))
        {
            categories.add(expense.getCategory())
        }
    }

    fun displayExpenses()
    {
        for (expense in expenses)
        {
            expense.displayExpense()
        }
    }

    fun getTotalPriceByCategory(): Map<String, Int>
    {
        val result = mutableMapOf<String, Int>()
        for (category in categories) result[category] = 0;
        for (expense in expenses)
        {
            val category: String = expense.getCategory()
            result[category] = result[category]!! + expense.getPrice()
        }
        return result
    }
}