/**
 * Created by liyaogang on 16/10/9.
 */
//var stack =
//    new java.util.LinkedList();
//[1, 2, 3, 4].forEach(function(item) {
//    stack.push(item);
//});
//print(stack);
//print(stack.getClass());

var iterator = new java.util.Iterator({
    i: 0,
    hasNext: function() {
        return this.i < 10;
    },
    next: function() {
        return this.i++;
    }
});
print(iterator instanceof Java.type("java.util.Iterator"));
while (iterator.hasNext()) {
    print("-> " + iterator.next());
}