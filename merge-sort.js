//Merge Sort Alrightm
//Time Complexity O(nlog(n) in worst case 

function mergeSort(array){
    if(array.length <= 1) {
        return array;
    }

    const middle = array.length / 2;
    var left = array.slice(0, middle);
    var right = array.slice(middle, array.length);

    mergeSort(left);
    mergeSort(right);
    merge(left, right, array);
}

function merge(left, right, array){
    var i = 0;
    var j = 0;
    var k = 0;

    while (i < left.length && j < right.length){
        if(left[i] <= right[j]){
            array[k] = left[i];
            i++;
        } else {
            array[k] = right[j];
            j++;
        }
        k++;
    }
    while(i < left.length){
        array[k] = left[i];
        i++;
        k++;
    }
    while(j < right.length){
        array[k] = right[j];
        j++;
        k++;
    }
}


//Testing
var arr1 = [59, 34, 300, 76, 10, 788];
console.log("Before sorting:");
console.log(arr1);
mergeSort(arr1);
console.log("after Sorting:");
console.log(arr1);