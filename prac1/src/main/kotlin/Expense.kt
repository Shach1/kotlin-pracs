class Expense(private val price: Int, private val category: String, private val date: String) {
    fun displayExpense()
    {
        println("$date: Category - $category, Price: $price")
    }
    fun getPrice(): Int
    {
        return price
    }
    fun getCategory(): String
    {
        return category
    }
    fun getDate(): String
    {
        return date
    }
}