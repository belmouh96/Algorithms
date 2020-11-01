//Time Complexity: O(n^2)

function insertionSort(array){
    var n = array.length;
    var value;
    var holder;
    for(var i = 1; i < n; i++){
        value = array[i];
        holder = i;
        while(holder > 0 && array[holder - 1] > value){
            array[holder] = array[holder - 1];
            holder--;
        }
        array[holder] = value;
    }
}


//Testing
var arr1 = [4, 65, 6, 76, 244, 7, 76, 1];
insertionSort(arr1);
console.log(arr1);