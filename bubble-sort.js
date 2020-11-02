//Time Complexity: O(n^2)

function bubbleSort(array) {
    var n = array.length;
    var j = n;
    while (n > 1){
        for(var i = 0; i < j - 1; i++){
            if(array[i] > array[i+1]){
                let temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        n--;
    }
}

//Testing
var arr1 = [54, 5, 76, 78, 9];
bubbleSort(arr1);
console.log(arr1);