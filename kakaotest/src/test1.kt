class SwitchCollection (var value: Int?){

    //var value: Int? = null
    var left: SwitchCollection? = null
    var right: SwitchCollection? = null
    var direction = -1

    fun add(value: Int) {
        if (this.value == null) {
            this.value = value;
            return;
        }
        if (this.direction == -1) {
            if (this.left == null)
                this.left = SwitchCollection(value);
            else {
                this.left!!.add(value);
            }
        } else {
            if (this.right == null)
                this.right = SwitchCollection(value);
            else
                this.right!!.add(value);
        }
        this.direction *= -1;
    }/*
    fun add(value: Int) {
        if (this.value == null) {
            this.value = value
        } else {
            if (direction == -1) {
                // left에 삽입
            } else {
                // right에 삽입
            }
            direction *= -1
        }
    }*/

    fun contains(value: Int): Boolean {
        println("contains")
        if (this.value == value) {
            return true
        } else {
            var result = true
            if (direction == -1) {
                result = left?.contains(value) ?: true
            } else {
                result = right?.contains(value) ?: true
            }
            direction *= -1
            return result
        }
    }
}

fun main(args: Array<String>) {

    val c = SwitchCollection(0)
    for (i in 1..9) {
        c.add(i)
    }


    println("시작")

    var i = 1
    while (i <= 9) {
        if (c.contains(i)) {
            i++
        }
    }

}