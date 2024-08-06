package com.shyam.sorting.sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SortController {

    @GetMapping("/")
    public String showSortForm() {
        return "sort";
    }

    @PostMapping("/sort")
    public String sortNumbers(@RequestParam String numbers, @RequestParam String sortType, Model model) {
        String[] array = numbers.split(",");
        int[] numArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numArray[i] = Integer.parseInt(array[i]);
        }

        // Perform sorting based on the selected sort type
        switch (sortType) {
            case "bubble":
                bubbleSort(numArray);
                break;
            case "selection":
                selectionSort(numArray);
                break;
            case "insertion":
                insertionSort(numArray);
                break;
            case "quick":
                quickSort(numArray,0,numArray.length-1);
                break;
            default:
                break;
        }
        model.addAttribute("sortedNumbers", numArray);
        model.addAttribute("numbers", numbers);
        return "sort";
    }


    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    private void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    private void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    private void quickSort(int[] numArray,int low,int high) {
        if(low<high){
            int pi = partition(numArray,low,high);
            quickSort(numArray,0,pi-1);
            quickSort(numArray,pi+1,high);
        }
    }
    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low-1;
        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;

        return i+1;
    }

}
