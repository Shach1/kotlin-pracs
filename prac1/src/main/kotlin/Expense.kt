class Expense(val _price: Int, private val _category: String, private val _date: String) {

    var price = _price
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var category = _category
        get() {return field}
        set(value) {field = value}

    var date = _date
        get() {return field}
        set(value) {field = value}

    fun displayExpense()
    {
        println("$date: Category - $category, Price: $price")
    }
}
