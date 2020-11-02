function quickSort(array, start, end){

    //Base Case
    if(start >= end){
        return;
    } 
    
    var pIndex = partition(array, start, end);
    quickSort(array, start, pIndex-1);
    quickSort(array, pIndex+1,end);
}

function partition(array, start, end){
    var pivot = array[end];
    var pIndex = start;
    for(var i = start; i < end; i++){
        if(array[i] <= pivot){
            let temp = array[i];
            array[i] = array[pIndex];
            array[pIndex] = temp;
            pIndex++;
        }
    }
    let temp = array[pIndex];
    array[pIndex] = array[end];
    array[end] = temp;
    return pIndex;
}


//Testing
var arr1 = [54, 6, 1, 87, 9, 45];
quickSort(arr1, 0, arr1.length - 1);
console.log(arr1);
