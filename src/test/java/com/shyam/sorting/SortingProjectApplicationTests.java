package com.shyam.sorting;

import com.shyam.sorting.sort.SortController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SortingProjectApplicationTests {

        private SortController sortController;
        private Model model;

        @BeforeEach
        void setUp() {
            sortController = new SortController();
            model = mock(Model.class);
        }

        @Test
        void sortNumbersBubbleSort() {
            sortController.sortNumbers("5,3,2,4,1", "bubble", model);
            verify(model).addAttribute("sortedNumbers", new int[]{1, 2, 3, 4, 5});
        }

        @Test
        void sortNumbersSelectionSort() {
            sortController.sortNumbers("5,3,2,4,1", "selection", model);
            verify(model).addAttribute("sortedNumbers", new int[]{1, 2, 3, 4, 5});
        }

        @Test
        void sortNumbersInsertionSort() {
            sortController.sortNumbers("5,3,2,4,1", "insertion", model);
            verify(model).addAttribute("sortedNumbers", new int[]{1, 2, 3, 4, 5});
        }

        @Test
        void sortNumbersQuickSort() {
            sortController.sortNumbers("5,3,2,4,1", "quick", model);
            verify(model).addAttribute("sortedNumbers", new int[]{1, 2, 3, 4, 5});
        }

        @Test
        void sortNumbersInvalidSortType() {
            sortController.sortNumbers("5,3,2,4,1", "invalid", model);
            verify(model).addAttribute("sortedNumbers", new int[]{5, 3, 2, 4, 1});
        }

        @Test
        void sortNumbersEmptyInput() {
            sortController.sortNumbers("", "bubble", model);
            verify(model).addAttribute("sortedNumbers", new int[]{});
        }

        @Test
        void sortNumbersSingleNumberInput() {
            sortController.sortNumbers("1", "bubble", model);
            verify(model).addAttribute("sortedNumbers", new int[]{1});
        }

}
