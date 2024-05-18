fun main() {
//    number1
    val contactList = listOf(
        Contact("Alice", "+1234567890", "alice@example.com"),
        Contact("Bob", "+9876543210", "bob@example.com"),
        Contact("Charlie", "+5551234567", "charlie@example.com")
    )

    val sortedByPhone = sortContacts(contactList, "phone")
    println(sortedByPhone)


    val sortedByEmail = sortContacts(contactList, "email")
    println(sortedByEmail)

    val sortedByName = sortContacts(contactList, sortBy = "name")
    println(sortedByName)

//    number 2

    val words = listOf("apple", "banana", "cat", "dog", "elephant", "frog")
    val (vowelWords, consonantWords) = splitWordsByVowelAndConsonant(words)
    println("Words starting with vowels: $vowelWords")
    println("Words starting with consonants: $consonantWords")


//    remove duplicate
//

//    shop



    val products = listOf(
        Product("Apples", "groceries", 1200.00, 5),
        Product("Toothpaste", "hygiene", 9000.00, 2),
        Product("Notebook", "general", 3000.00, 1),
        Product("battery", "appliances", 50000.00, 9),
        Product("Bread","groceries",2000.00,1),
        Product("soap","hygiene",500.00,1),
        Product("Kettle","appliances",2500.00,2),
    )

    val categoryTotals = checkCategoryTotals(products)


// Display category totals
    for ((category, total) in categoryTotals) {
        println("$category Total: $$total")
    }

// Barnie removing 'b'
excludeB("Barnie bakes brown bagels and buns")

    var result= lengthOfLastWord("   fly me   to   the moon  ")
    println(result)

    println(lengthOfEndtWord("Tak me to  church  "))

    println(lastwordLenfth("I like church"))

//    println(wordLstLength("I eat rice"))

    multiplication(56)

}







data class Contact(val name: String, val phoneNumber: String, val email: String)

fun sortContacts(contacts: List<Contact>, sortBy: String): List<Contact> {
    return when (sortBy) {
        "phone" -> contacts.sortedBy { it.phoneNumber }
        "email" -> contacts.sortedBy { it.email }
        "name" -> contacts.sortedBy { it. name}
        else -> throw IllegalArgumentException("Invalid sorting criteria. Use 'phone' or 'email'.")
    }
}
//You are sorting a list into 2 lists.
//one list contains words beginning with a vowel while another
//is to hold a list that contains words that start with consonants
//Write a function




fun splitWordsByVowelAndConsonant(words: List<String>): Pair<List<String>, List<String>> {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val vowelList = mutableListOf<String>()
    val consonantList = mutableListOf<String>()
    for (word in words) {
        val firstChar = word.toLowerCase().firstOrNull()
        if (firstChar != null) {
            if (firstChar in vowels) {
                vowelList.add(word)
            } else {
                consonantList.add(word)
            }
        }
    }
    return Pair(vowelList, consonantList)
}

//remove duplicate
//fun originalString(name:String){
//    val name1 = name.toSet()
//    nam1.toString
//    println(name1)
//




data class Product (
    var name : String,
    var category: String,
    var price : Double,
    var quantity : Int)





//data class Product(val name: String, val category: String, val quantity: Int, val price: Double)

fun checkCategoryTotals(products: List<Product>): Map<String, Double> {
    val categoryTotals = mutableMapOf<String, Double>()
    for (product in products) {
        val total = product.price * product.quantity
        categoryTotals[product.category] = categoryTotals.getOrDefault(product.category, 0.0) + total
    }
    println(categoryTotals.values.sum())
    return categoryTotals
}
/*
val products = listOf(
    Product("Apples", "groceries", 1200.00, 5),
    Product("Toothpaste", "hygiene", 9000.00, 2),
    Product("Notebook", "general", 3000.00, 1),
    Product("battery", "appliances", 50000.00, 9),
    Product("Bread","groceries",2000.00,1),
    Product("soap","hygiene",500.00,1),
    Product("Kettle","appliances",2500.00,2),
)*/

///Invoke a function that when given  the string "Barnie bakes brown bagels and buns"
// prints out a list of all the other words and characters making up the string
// excluding occurences of the letter b.
fun excludeB(word:String){
    var newWord = word.lowercase()
    println( newWord.split('b'))

}
//Write a function that takes in a sentence comprised of different words and spaces
// then returns the length of the last word
fun lengthOfLastWord(s: String): Int {
    var result =0
    for(i in s.length-1 downTo   0) {
        if ((s[i].toString() == " " && result == 0)) continue

        if (s[i].toString() == " " && result != 0) break
        result++
    }
    return result
}
//or
fun lengthOfEndtWord(s: String): Int{
    val words = s.split(" ")
    return words.lastOrNull()?.length ?: 0
}
//or
fun lastwordLenfth(word: String):Int{
    val a = word.split(" ")
    var newWord = a.last().length
    return newWord
}
//or
//fun wordLstLength(str: String): Int {
//    var subStr = str.split(" ")
//    var end = str.length - 1
//    while (end < 1) {
//        if (str[end] != str[end]) {
//            return end
//        }
//
//        end++
//    }
//    return end
//}

//
fun lastWordLength(sentence:String):Int{
    var len = 0
    val idx = sentence.trim().lastIndex
    while (idx>=0){
        if(sentence[idx]!=' '){
            len++

        } else{
            break
        }
//        idx--
    }
    return len
}
//Write a function that prints muliples of8 and 6 between 1 and 1000.

fun multiplication(numbers:Int){
    for (number in 1..1000) {
        if (number % 8 == 0 && number % 6 == 0) {
            println("Bingo! $number")
        }

    }
}
