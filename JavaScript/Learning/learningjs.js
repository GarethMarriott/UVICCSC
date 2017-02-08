
var a = 3
var b = 111

var c = a * b

var numbers = [1,2,3,5,55]

var numbers = [1,4,6]

console.log(numbers[2]);

var array = [1,2,"hello",4,"undefined"]
for (var i = 0; i < 10; i++) {
  console.log(array[i]);
  console.log(array[i+1]);
  array[i] = array[i+1]
  console.log("---");
  console.log(array[i]);
  console.log(array[i+1]);

  console.log("\n");
}
