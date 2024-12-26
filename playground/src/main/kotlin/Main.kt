package jp.kaleidot725.tray.utility

fun main() {
    println("Cat - mouseHunter(false)")
    feedAnimal(Animal.Cat(mouseHunter = false))
    println("Cat - mouseHunter(true)")
    feedAnimal(Animal.Cat(mouseHunter = true))
    println("Dog - breed(Test)")
    feedAnimal(Animal.Dog(breed = "Test"))
    println("Process List")
    processList((0..100).toList())
    printMultiDollar()
}

sealed interface Animal {
    data class Cat(val mouseHunter: Boolean) : Animal {
        fun feedCat() {
            println("Print Cat")
        }
    }

    data class Dog(val breed: String) : Animal {
        fun feedDog() {
            println("Print Dog")
        }
    }
}

private fun feedAnimal(animal: Animal) {
    when (animal)
    {
        is Animal.Dog -> animal.feedDog()
        is Animal.Cat if !animal.mouseHunter -> animal.feedCat()
        else -> println("Print Unknown animal")
    }
}

private fun processList(elements: List<Int>) {
    loop@ for (element in elements) {
        // inlineのラムダ関数からContinueやbreakを呼び出すことができないのができるようになる
        element.execute {
            if (element == 100) {
                println("BREAK : $element")
                break@loop
            }
            if (element % 2 == 0) {
                println("CONTINUE : $element")
                continue@loop
            }

            println("SUCCESS : $element")
        }
    }
}

private inline fun Int.execute(block: () -> Unit) {
    block()
}

private fun printMultiDollar() {
    val a = 100
    println($"$a")
    println($$"$$a")
    println($$$"$$$a")
    println($$"$a")
    println($$$"$$a")
}