
//n: number of elements in the array
function selectionSort(array){
    let n = array.length;
    for(var i = 0; i < n - 1; i++){
        var min = i;
        for(var j = i + 1; j < n; j++){
            if(array[j] < array[min]){
                min = j;
            }
        }
        var temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }
}


//Testing
arr1 = [459, 43, 65, 7, 223, 9, -3, 9999];
selectionSort(arr1);
console.log(arr1);