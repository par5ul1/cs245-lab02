# Two Sum
## A two sum implementation in Java.

Code breakdown has been commented inside of the code but for completeness sake, a basic explanation will be provided here.

---

The original naïve solution relied on brute force checking by using a nested loops and checking every index against every other index within the array to find a suitable match. That code ran in O(n^2)

The latest solution uses a mixture of sorting and searching to provide a better best case running time. While in the worst case the program still runs in O(n^2) — as insertion sort runs in O(n^2) — the best case for each component are the following:

- **Insertion Sort:** O(n) — everything is already sorted and the pass is only to check that.
- **Bubble Search:** O(1) — the desired value is found at the center of the list
- **twoSum():** O(n) — the found indices need to be matched back to the original array

Adding these time complexities together gives an overall best case of O(n)
